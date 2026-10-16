# spring-boot-autoconfigure 和 @SpringBootApplication 到底是什么关系

> 全部数据来自本机 Maven 仓库实测（`spring-boot-autoconfigure` **3.3.5**（尚硅谷课用的 3.x 线）和 **4.1.1**（最新）），
> 用 PowerShell 把 jar 当 zip 拆开数出来的，不是背的。
> 配套：[[01-自动注册bean]] · [[02-自动包扫描]] · [[03-自动配置是怎么实现的]]

---

## 0. 先记住三句话

1. **`@SpringBootApplication` 这个注解本身，就住在 `spring-boot-autoconfigure.jar` 里。**
   它的全限定名是 `org.springframework.boot.autoconfigure.SpringBootApplication`。
   —— 所以它俩不是"两个东西的关系"，是「**注解**」和「**它的家**」的关系。

2. `@SpringBootApplication` 是个**三合一**（源码里的真实注解，只有 3 个）：

   ```java
   @SpringBootConfiguration              // = 你是配置类
   @EnableAutoConfiguration              // ★ 自动配置的开关
   @ComponentScan(excludeFilters = {...}) // 扫你自己写的类
   public @interface SpringBootApplication { ... }
   ```

3. `spring-boot-autoconfigure` 里装的是「**152 个 XXXAutoConfiguration 配置类** + **1 份清单** + **2 份元数据** + **几个注解和选择器**」。

**一句话**：`@SpringBootApplication` 是**开关**，`spring-boot-autoconfigure` 是**货仓**；
开关按下之后，货仓里的东西**不是靠扫描进去的，是靠读清单进去的**。

---

## 1. 关系图

```
       你的启动类  @SpringBootApplication          ← 你写的
                        │
                        │ 这个注解的 class 文件实际躺在 ↓
                        ▼
   ┌─────────────────────────────────────────────────────────┐
   │  spring-boot-autoconfigure-3.3.5.jar    （1.9 MB）      │
   │                                                         │
   │  ① 当事人（注解 + 选择器）                              │
   │     SpringBootApplication.class          ← 就是这个注解 │
   │     EnableAutoConfiguration.class                       │
   │     AutoConfiguration.class                             │
   │     AutoConfigurationImportSelector.class ← 干活的      │
   │                                                         │
   │  ② 货：152 个 XXXAutoConfiguration 配置类               │
   │     web/servlet/WebMvcAutoConfiguration                 │
   │     jdbc/DataSourceAutoConfiguration                    │
   │     jackson/JacksonAutoConfiguration                    │
   │     ... 覆盖 60+ 个技术领域子包                          │
   │                                                         │
   │  ③ 清单：META-INF/spring/                               │
   │       org.springframework.boot.autoconfigure            │
   │       .AutoConfiguration.imports      （12,633 B / 152 行）│
   │                                                         │
   │  ④ 元数据：spring-autoconfigure-metadata.properties     │
   │           spring-configuration-metadata.json            │
   └─────────────────────────────────────────────────────────┘
```

---

## 2. `spring-boot-autoconfigure` 内部到底存了什么

按大小和重要性排，一共 5 类东西（都在 3.3.5 里实测）：

| # | 存的东西 | 实测大小 | 干什么用的 |
|---|---|---|---|
| 1 | **152 个 `XXXAutoConfiguration` 配置类** | 1397 个 `.class` 里的主体 | 真正的"自动配置内容"，每个都是 `@Configuration(proxyBeanMethods=false)` + 一堆 `@ConditionalOnXxx` |
| 2 | **`.imports` 清单** | 12,633 B / 152 行 | **纯文本，只有类名**。告诉 Boot「货仓里有这些，自己去挑」 |
| 3 | `spring-configuration-metadata.json` | **564 KB** | 你在 `application.yml` 里敲 `spring.` 时的**IDE 提示和文档**来源 |
| 4 | `spring-autoconfigure-metadata.properties` | 133 KB / 872 行 | **预计算的条件**。让 Boot 不用把 152 个类全加载进来才判断条件，直接看这个文件就能筛掉一大半 |
| 5 | `spring.factories` | 3,297 B | ⚠️ **不是自动配置清单**！里面装的是监听器、失败分析器、`EnvironmentPostProcessor`、模板可用性提供者等 |

### 5 个坑点澄清

- **坑 1**：`spring.factories` 在 Boot 3 里**已经不装自动配置类了**（2.7 之前装）。它现在只装杂项。
  网上老博客说「自动配置类在 spring.factories 里」——那是 **Boot 2.7 之前**的事。
- **坑 2**：清单文件名特别长，是因为它是**模板拼出来的**：
  `META-INF/spring/%s.imports`，`%s` = 注解全限定名。
- **坑 3**：152 个**不是全部**。第三方 starter 也往同一个清单里塞：
  实测 `mybatis-spring-boot-autoconfigure-4.0.0.jar` 里也有一份同名的 `.imports`。
  `ImportCandidates.load()` 会把 **classpath 上所有 jar 的同名文件汇总**成一份总名单。
- **坑 4**：这 152 个类**不是都会生效**，要过条件检查（`@ConditionalOnClass` / `@ConditionalOnMissingBean` …）。
- **坑 5**：只带 `spring-boot-autoconfigure` 是跑不起来的，它需要 classpath 上有它要配的东西（比如 `spring-webmvc`），否则条件全不过。

---

## 2.5 ★ 第三类东西：84 个 `XXXProperties` —— `application.yml` 的另一半

§2 说 sba 里是"配方"，但配方上还有**旋钮**。`XXXProperties` 就是旋钮的定义表。

### 它长什么样

`@ConfigurationProperties` 是个**纯标注型**注解（源码全文就 4 个属性，没有任何逻辑）：

```java
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME) @Documented @Indexed
public @interface ConfigurationProperties {
    @AliasFor("prefix") String value() default "";
    @AliasFor("value")  String prefix() default "";
    boolean ignoreInvalidFields() default false;
    boolean ignoreUnknownFields() default true;   // ★ 默认 true：key 写错不报错，这点最坑
}
```

真实实例（sba 3.3.5 源码原文）：

```java
@ConfigurationProperties(prefix = "server", ignoreUnknownFields = true)
public class ServerProperties {
    private Integer port;                                                  // → server.port
    private InetAddress address;                                           // → server.address
    private DataSize maxHttpRequestHeaderSize = DataSize.ofKilobytes(8);   // → server.max-http-request-header-size
    private Shutdown shutdown = Shutdown.IMMEDIATE;                         // → server.shutdown（枚举，有值提示）

    @NestedConfigurationProperty
    private final ErrorProperties error = new ErrorProperties();            // → server.error.*
    @NestedConfigurationProperty
    private final Compression compression = new Compression();              // → server.compression.*
    private final Tomcat tomcat = new Tomcat();                             // → server.tomcat.*（final + new 也能被识别）
    public static class Tomcat { ... }
}
```

### 五条对应规律

| Java 侧 | yml 侧 |
|---|---|
| `prefix = "server"` + 字段 `port` | `server.port` |
| 驼峰 `maxHttpRequestHeaderSize` | `server.max-http-request-header-size`（**松散绑定**，`maxHttpRequestHeaderSize` / `max_http_request_header_size` 也认） |
| 静态内部类再加一层 | `server.compression.min-response-size` |
| 字段上的 **Javadoc** | IDE 里那行提示文字 |
| 字段初始化值 / 手写元数据 | IDE 里显示的 default value |

### 属性类怎么和配置类"接线"

自动配置类不自己 new 属性类，而是**声明一句"我要用它"**：

```java
@AutoConfiguration
@EnableConfigurationProperties(ServerProperties.class)      // ★ 接线
public class ServletWebServerFactoryAutoConfiguration { ... }
```

实测三个真实接线：

| 自动配置类 | 声明用到的属性类 |
|---|---|
| `ServletWebServerFactoryAutoConfiguration` | `@EnableConfigurationProperties(ServerProperties.class)` |
| `DispatcherServletAutoConfiguration` | `@EnableConfigurationProperties(WebMvcProperties.class)` |
| `WebMvcAutoConfiguration` | `@EnableConfigurationProperties({ WebMvcProperties.class, WebProperties.class })` |

### 属性类是怎么"活"起来的（4 步）

```
① 谁把属性类注册成 Bean？
   @EnableConfigurationProperties(XxxProperties.class)
      → EnableConfigurationPropertiesRegistrar.registerBeanDefinitions()
         ├─ registerInfrastructureBeans(registry)   ← 注册"绑定器"基础设施
         │     ConfigurationPropertiesBindingPostProcessor.register(registry)
         │     BoundConfigurationProperties.register(registry)
         └─ ConfigurationPropertiesBeanRegistrar     ← 把 XxxProperties 变成 BeanDefinition

② 谁把 yml 的值塞进字段？
   ConfigurationPropertiesBindingPostProcessor（一个 BeanPostProcessor）源码 L77~96：
       public Object postProcessBeforeInitialization(Object bean, String beanName) {
           bind(ConfigurationPropertiesBean.get(this.applicationContext, bean, beanName));  // ← 就在这绑
       }
       private void bind(...) { this.binder.bind(bean); }    // ConfigurationPropertiesBinder → Binder

③ 全局开关在哪？
   ConfigurationPropertiesAutoConfiguration（★ 也在 .imports 清单里，3.x / 4.x 都有）
       @AutoConfiguration
       @EnableConfigurationProperties          ← 注意是空的，只注册基础设施
       public class ConfigurationPropertiesAutoConfiguration { }
   → 这就是为什么你自己写 @Component + @ConfigurationProperties 也能绑上值

④ 属性类怎么被"用"？
   它就是个普通 Bean → 构造器注入进配置类
   ServerProperties.getPort()  →  ServletWebServerFactoryCustomizer  →  Tomcat 端口
```

### ⚠️ 三个易错点

1. **只写 `@ConfigurationProperties` 不会进容器。** 它没有 `@Component` 语义，只是标注。
   必须靠四种方式之一注册：① `@EnableConfigurationProperties` ② `@ConfigurationPropertiesScan`（扫你自己包）
   ③ `@Component` ④ `@Bean` 方法上。而且 `@ConfigurationPropertiesScan` 官方明确说：
   **带 `@Component` 的类它不会扫**（防止重复注册）。
2. **`ignoreUnknownFields` 默认 `true`** → yml 里 key 拼错**不报错、静默忽略**。
   写成 `srever.port` 就是毫无提示地不生效。想让它报错得显式写 `ignoreUnknownFields = false`。
3. **属性类不在"你的包"里，但出现在你的 IDE 提示里** —— 靠的就是下面这份元数据。

### ★ 闭环：§2 那 564 KB 的元数据，就是这些属性类生成的

```
你写 @ConfigurationProperties(prefix="server") + 字段 + 字段上的 Javadoc
        │
        ▼  注解处理器 spring-boot-configuration-processor 在**编译 sba 时**跑
        │
        ├─ 生成 spring-configuration-metadata.json
        │     实测：281 groups / 1657 properties / 37 hints
        │     一条长这样：
        │     { "name": "server.port", "type": "java.lang.Integer",
        │       "description": "Server HTTP port.",
        │       "sourceType": "...ServerProperties", "defaultValue": 8080 }
        │
        └─ 手写的 additional-spring-configuration-metadata.json（434 条，其中 164 条带 defaultValue）
              补注解处理器**推不出来**的东西：比如 port 字段没写初始化值，
              却要在 IDE 里显示默认 8080 → 就靠手写 {"name":"server.port","defaultValue":8080}

两份合并 → 打进 jar 的 spring-configuration-metadata.json（564 KB）
        │
        ▼
yml 里敲 server.  →  IDE 弹出 281 组 / 1657 个 key + 提示文字 + 默认值
```

> **"IDE 里 application.yml 有提示"不是 IDE 聪明，是 sba 提前把说明书编译进 jar 了。**

### 数字总览（sba 3.3.5 实测）

| 东西 | 数量 |
|---|---|
| `XXXAutoConfiguration` 配置类 | 152 个 |
| `XXXProperties` 属性类 | **84 个** |
| 元数据 group | 281 个 |
| 元数据 property（= 你能配的 key） | **1657 个** |
| 其中带 defaultValue 的 | 629 个 |
| hints（枚举/类引用的值提示） | 37 个 |

---

## 2.6 ★★ 方向别搞反：谁给谁注入（最容易说错的一句）

**错误说法**：「属性类是给 sba 内部的配置类**注入属性**的」。

**正确方向**：

```
application.yml / 环境变量 / 命令行参数
        │
        │  ① Binder 绑定（ConfigurationPropertiesBinder → new Binder(ConfigurationPropertySources...)）
        │     值来自 Environment，不是来自配置类
        ▼
   ServerProperties 对象的字段        ← 属性类是"值的容器"，是个普通 Bean
        │
        │  ② 配置类把属性类当依赖注入进来（构造器参数 / @Bean 方法参数）
        ▼
   ServletWebServerFactoryCustomizer   ← 消费者，从属性类身上"读"值
        │
        │  ③ 把读出来的值写到目标组件上
        ▼
   Tomcat 真的监听 8080
```

**一句话**：属性类是**值的容器**，配置类是**消费者**。不是"属性类给配置类注入属性"，而是
**「Environment 给属性类注入值 → 配置类读属性类」**。

### 铁证一：属性类被当成依赖"持有"

`ServletWebServerFactoryCustomizer` 源码：

```java
public class ServletWebServerFactoryCustomizer {
    private final ServerProperties serverProperties;              // ★ 持有属性类
    public ServletWebServerFactoryCustomizer(ServerProperties serverProperties, ...) {
        this.serverProperties = serverProperties;                 // ★ 构造器注入
    }
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        map.from(this.serverProperties::getPort).to(factory::setPort);          // ★★ 一句话说清方向
        map.from(this.serverProperties::getAddress).to(factory::setAddress);
        map.from(this.serverProperties::getCompression).to(factory::setCompression);
        map.from(this.serverProperties::getShutdown).to(factory::setShutdown);
        ...
    }
}
```

> `map.from(属性类::getXxx).to(目标::setXxx)` —— **左边是属性类，右边是目标组件。**
> 属性类是**数据源**，Tomcat 是**接收方**。

### 铁证二：一个属性类被 **27 个类**共用

实测 sba 3.3.5 的 804 个 `.java` 里：

| 属性类 | 被多少个类引用 |
|---|---|
| `ServerProperties` | **27 个**（Tomcat / Jetty / Netty / Undertow 四套 web 容器的 customizer 全都读它） |
| `WebProperties` | 10 个 |
| `WebMvcProperties` | 3 个 |
| `JacksonProperties` | 1 个 |

**一个属性类被 27 个组件共享读取，这才正常**；反过来"属性类给配置类注入属性"就说不通了 —— 27 个消费者，属性类到底"注入"给谁？

### 铁证三：属性类的值来自 Environment，和配置类无关

`ConfigurationPropertiesBinder` 源码：

```java
private Binder getBinder() {
    this.binder = new Binder(getConfigurationPropertySources(), getPropertySourcesPlaceholdersResolver(), ...);
}
private Iterable<ConfigurationPropertySource> getConfigurationPropertySources() {
    return ConfigurationPropertySources.from(this.propertySources);   // ← Environment 的 PropertySource
}
```

**属性类完全不知道配置类的存在**，它只认 Environment。

---

## 2.7 `@EnableConfigurationProperties` vs `@ConfigurationProperties`：位置分工

这两个名字像，位置完全不同，`@Target` 一句话说清：

```java
@Target(ElementType.TYPE)                    // ★ 只能放【类】上
public @interface EnableConfigurationProperties { Class<?>[] value() default {}; }

@Target({ ElementType.TYPE, ElementType.METHOD })   // ★ 类 和 @Bean 方法 都能放
public @interface ConfigurationProperties { String prefix() default ""; }
```

| | `@EnableConfigurationProperties(X.class)` | `@ConfigurationProperties(prefix="x")` |
|---|---|---|
| 放哪 | **类**上（配置类 / 启动类 / 任何 `@Configuration`） | **类**上（属性类自己）或 **`@Bean` 方法**上 |
| 出处 | `spring-boot.jar` | `spring-boot.jar` |
| 干什么 | ①把 `X` 注册成 Bean ②注册绑定器基础设施 | 只是标注"我的前缀是什么"，**不注册 Bean** |
| 谁需要它 | 用**别人写的**属性类时（框架配置类的做法） | 写**自己的**属性类时 |

**两种典型写法：**

```java
// 写法 A：属性类是框架的 → 配置类上 @EnableConfigurationProperties 接线
@AutoConfiguration
@EnableConfigurationProperties(ServerProperties.class)
public class ServletWebServerFactoryAutoConfiguration {
    @Bean
    public ServletWebServerFactoryCustomizer customizer(ServerProperties serverProperties) { ... }
}

// 写法 B：属性类是你自己的 → 属性类上直接标 @ConfigurationProperties + 靠扫描/组件注册
@ConfigurationProperties(prefix = "my.app")
public class MyAppProperties {
    private String name;
    private int timeout = 3000;
}
// 然后用 @ConfigurationPropertiesScan 或 @EnableConfigurationProperties(MyAppProperties.class) 启用
```

⚠️ **`@ConfigurationProperties` 单独写不会进容器**（它没有 `@Component` 语义），必须配合注册方式之一。

---

## 2.8 第三个独立入口：`@ConditionalOnProperty` 不读属性类

条件注解读配置，走的是**另一条路** —— 直接查 Environment，用**原始 key 字符串**：

```java
// ServletWebServerFactoryAutoConfiguration 里真实存在的一行
@ConditionalOnProperty(value = "server.forward-headers-strategy", havingValue = "framework")
```

`OnPropertyCondition` 源码：

```java
ConditionOutcome outcome = determineOutcome(annotationAttributes, context.getEnvironment());  // ★ 拿 Environment
private ConditionOutcome determineOutcome(AnnotationAttributes a, PropertyResolver resolver) { ... }
    if (!isMatch(resolver.getProperty(key), this.havingValue)) { ... }                        // ★ 直接按 key 查
```

**所以同一个 `server.*` 前缀，有三条互不相干的路：**

| 路 | 机制 | 读什么 | 给谁用 |
|---|---|---|---|
| ① `@ConditionalOnProperty` | `context.getEnvironment().getProperty("server.x")` | key 字符串 | **条件判断**（要不要生效） |
| ② `@EnableConfigurationProperties(X)` | `ConfigurationPropertiesBinder` → `Binder` | 整个前缀批量绑 | **Java 代码**（`getPort()`） |
| ③ `@Value("${server.port}")` | `PropertySourcesPlaceholderResolver` | 单个 key | 你的业务代码 |

> ①和②**都从 Environment 读**，但 ① 只拿去做开关判断，② 才绑成对象。别把 ① 当成"属性类在起作用"。

---

## 2.9 ★ `@AutoConfiguration`：是"身份证"，不是"通行证"

### 先看实测数据

| 指标 | 数量 |
|---|---|
| `.imports` 清单条数 | **152** |
| sba 源码里顶层类标了 `@AutoConfiguration` 的 | **151** |
| 嵌套类标了 `@AutoConfiguration` 的 | 0 |
| **在清单里、但没标 `@AutoConfiguration`** | **1 个**（`ReactorAutoConfiguration`） |
| **标了 `@AutoConfiguration`、但没进清单** | **0 个** |
| `*AutoConfiguration.class` 文件总数 | 155 = 152 个配置类 + 3 个注解本体（`AutoConfiguration` / `EnableAutoConfiguration` / `ImportAutoConfiguration`） |

**结论：清单和注解几乎重合，但——清单才是权威。**

### `@AutoConfiguration` 是什么（源码）

```java
@Target(ElementType.TYPE) @Retention(RetentionPolicy.RUNTIME) @Documented
@Configuration(proxyBeanMethods = false)     // ★ 它就是 @Configuration 的"定制版"
@AutoConfigureBefore
@AutoConfigureAfter
public @interface AutoConfiguration {
    @AliasFor(annotation = Configuration.class) String value() default "";
    Class<?>[] before() default {};   String[] beforeName() default {};
    Class<?>[] after()  default {};   String[] afterName()  default {};
}
```

`@since 2.7.0` —— **Boot 2.7 才有的注解**。它的三个真实作用：

| 作用 | 说明 |
|---|---|
| **① 关掉 CGLIB 代理** | `proxyBeanMethods = false`。152 个配置类如果每个都生成 CGLIB 子类，启动会明显变慢。代价：自动配置类里**不能靠"直接调用 `@Bean` 方法"拿 Bean** |
| **② 提供排序信息** | `before` / `after`，配合 `@AutoConfigureOrder` |
| **③ 当"身份标记"** | 让 `AutoConfigurationExcludeFilter` 认得它（见 §3 原因 2） |

### ★★ 关键：注解**不**负责"发现"

`AutoConfigurationImportSelector` 源码 L179~180：

```java
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
    List<String> configurations = ImportCandidates.load(AutoConfiguration.class, getBeanClassLoader())...
    //                                                  ↑ 这里只是拿去【拼文件名】
}
```

`AutoConfiguration.class` 传进去的唯一用途是**拼出清单文件名**：

```
"META-INF/spring/%s.imports"  ←  %s = org.springframework.boot.autoconfigure.AutoConfiguration
```

**它根本不是"扫描所有标了 `@AutoConfiguration` 的类"。** 四个环节各管一摊：

| 环节 | 靠什么 | 看注解吗 |
|---|---|---|
| **发现**（哪些类是自动配置类） | **`.imports` 清单** | **❌ 不看** |
| **排序** | `@AutoConfiguration(before/after)` + `@AutoConfigureOrder` | ✅ 看，但读的是 `spring-autoconfigure-metadata.properties`（**不加载类**就能排） |
| **条件** | `@ConditionalOnXxx` | ✅ 看 |
| **注册** | `ConfigurationClassPostProcessor` | — |

> `AutoConfigurationSorter` 的 javadoc 原话：reading `@AutoConfigureOrder` / `@AutoConfigureBefore` /
> `@AutoConfigureAfter` annotations **(without loading classes)** —— 这就是 §2 里那份 133 KB 元数据的用途之一。

### ⚠️ 推论（自己写 starter 必踩的坑）

> **你写一个类标上 `@AutoConfiguration`，如果不放进 `.imports`，它完全不生效，而且不会报错。**

这就是"自写 starter 必须在 `src/main/resources/META-INF/spring/` 下建
`org.springframework.boot.autoconfigure.AutoConfiguration.imports` 文件"的根本原因。
你写错文件名或放错目录 → 静默失效，最难查的一类 bug。

### 那个"异类" `ReactorAutoConfiguration` 说明了什么

它是**老式写法**（清单里有它，但它没标 `@AutoConfiguration`）：

```java
@Configuration(proxyBeanMethods = false)          // ← 手写 @Configuration 顶上
@ConditionalOnClass(Hooks.class)
@EnableConfigurationProperties(ReactorProperties.class)
public class ReactorAutoConfiguration { ... }
```

**照样生效。** 证明 `@AutoConfiguration` 只是"可选的身份证明"，**生效的必要条件是在清单里**。

> 三方 starter 如果兼容 Boot 2.x 老版本，就常用这种写法 —— 因为 `@AutoConfiguration` 在 2.7 之前不存在。

---

## 3. ★ 为什么"默认扫描"永远扫不到 sba 内部的配置类

三个原因，**缺一不可**，按重要性排：

### 原因 1：包路径根本不在一个根上（最根本）

`@ComponentScan` 不带参数时，**扫描起点 = 被标注类所在的那个包**。
Spring 源码 `ComponentScanAnnotationParser` 第 118~119 行：

```java
if (basePackages.isEmpty()) {
    basePackages.add(ClassUtils.getPackageName(declaringClass));
}
```

于是：

```
你的启动类   com.atguigu.boot.MainApplication
             └─ @ComponentScan 的扫描范围 = com.atguigu.boot.**

自动配置类   org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
             └─ 包路径是 org.springframework.boot.autoconfigure，不是 com.atguigu.boot

结论：com.atguigu.boot.** 里根本不存在 org.springframework... 这个包 → 扫不到
```

> 类比：`@ComponentScan` 是「在你自己家楼上楼下找人」，而自动配置类住在另一个小区。
> **包扫描只能扫"包路径"，跨不了 jar 的命名空间。**

### 原因 2：`@SpringBootApplication` 还**主动挂了过滤器**把它们排除掉

源码里那一行 `excludeFilters`：

```java
@ComponentScan(excludeFilters = {
    @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
    @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class)  // ★
})
```

`AutoConfigurationExcludeFilter` 的 `match()` 逻辑（源码原文）：

```java
return isConfiguration(metadataReader) && isAutoConfiguration(metadataReader);
//      ↑ 是 @Configuration        &&   ↑ 在自动配置清单里 / 带 @AutoConfiguration
```

**它挡的是"你已经手动调大扫描范围"这种情况**：
就算你写 `scanBasePackages = "org.springframework.boot"` 把包扩进来，这个过滤器也会把清单里的类踢掉，
因为它们是**走清单进来的**，不能既走扫描又走清单（否则同一个配置类注册两次）。

### 原因 3：`@ComponentScan` 按「包路径」找，`.imports` 按「清单文件」找 —— 是两条独立的路

| | 自动包扫描 | 自动配置 |
|---|---|---|
| 触发注解 | `@ComponentScan` | `@EnableAutoConfiguration` |
| 目标 | **你自己写的**类 | **框架/第三方**写好的配置类 |
| 发现方式 | 按**包路径**扫 `.class` 文件 | 按**清单文件**读类名 |
| 范围 | 主程序所在包及其子包 | 整个 classpath 上**所有 jar** |
| 典型产物 | 你的 `@Service`、`@Controller` | `DispatcherServlet`、`ObjectMapper`、`Tomcat` |
| 执行者 | Spring Framework 的 `ClassPathScanningCandidateComponentProvider` | `AutoConfigurationImportSelector` |

**为什么必须另搞一套？** 因为 `@ComponentScan` 的视野天生被"包"锁死，
想让**隔着 jar** 的类主动进容器，就必须有「我在某个约定位置放一份名单，你照着名单来配」的机制。

---

## 4. 它们到底是怎么进来的（完整链路）

```
@SpringBootApplication
   ├─ @ComponentScan  ──→ 扫 com.atguigu.boot.**  →  你的 @Service / @Controller
   │
   └─ @EnableAutoConfiguration
         └─ @Import(AutoConfigurationImportSelector.class)   ★ 秘密全在这一行
               │  它是 DeferredImportSelector（延迟导入）
               │  → 保证「你的 Bean 先注册完，我才动手」
               │    （这才是 @ConditionalOnMissingBean 能生效的前提）
               ▼
         ImportCandidates.load()
               │  扫 classpath 上所有 jar 的
               │  META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
               │  → 汇总 + 去重 得到 152+ 个类名
               ▼
         逐个过条件（先看 spring-autoconfigure-metadata.properties 预筛）
               @ConditionalOnClass(DispatcherServlet.class)   ← 这个类在不在 classpath
               @ConditionalOnWebApplication(type = SERVLET)   ← 是不是 web 环境
               @ConditionalOnMissingBean                      ← 你自己没定义过我才给默认的
               ▼
         交给 Spring Framework 的 ConfigurationClassPostProcessor
         （住在 spring-context.jar，是 Spring 的老本行，不是 Boot 的）
               │  执行配置类里的 @Bean 方法
               ▼
         DispatcherServlet / ObjectMapper / Tomcat … 进容器
               ▼
         你能写 @GetMapping 了 —— 一行配置都没写
```

> **关键认知**：Spring Boot 只做「**发现该配什么**」，Spring Framework 做「**配**」。
> 所以 Spring Boot 不是在 Spring 之外另搞了个容器。

---

## 5. 那加上 `@EnableAutoConfiguration` 有什么用？

### 5.1 在 `@SpringBootApplication` 之上再加 → **完全没用**

官方 javadoc 原话（`EnableAutoConfiguration.java`）：

> When using `@SpringBootApplication`, the auto-configuration of the context is
> automatically enabled and **adding this annotation has therefore no additional effect**.

原因在 Spring 源码里，`ConfigurationClassParser` 第 453 行：

```java
private Set<SourceClass> getImports(SourceClass sourceClass) throws IOException {
    Set<SourceClass> imports = new LinkedHashSet<>();   // ★ 是 Set
    Set<SourceClass> visited = new LinkedHashSet<>();
    collectImports(sourceClass, imports, visited);      // 递归收集所有注解上的 @Import
    return imports;
}
```

- 它递归地把**所有注解（含元注解）**上的 `@Import` 都收进来
- 收进的是 **`Set`**，`AutoConfigurationImportSelector` 出现两次也只会留一个
- 所以 **不会重复注册，也不会有任何额外效果**

### 5.2 它真正的用处（4 个场景）

| 场景 | 说明 |
|---|---|
| **不用 `@SpringBootApplication` 的时候** | 比如你手写 `@Configuration + @ComponentScan` 起一个轻量上下文，想保留自动配置就必须显式加 |
| **想排除某些自动配置** | `@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})`；`@SpringBootApplication` 的 `exclude` 属性其实就是 `@AliasFor` 过去的 |
| **第三方/自定义 starter 的作者** | 在自己的配置类上用它，让别人的项目"引了依赖就生效" |
| **测试切片** | `@ImportAutoConfiguration` 系列，只激活指定的几个自动配置 |

> ⚠️ **别把它当成"必须写的注解"**。你写 `@SpringBootApplication` 时它已经在里面了，
> 再抄一遍只会让面试官看出你没看过源码。

---

## 6. ⚠️ 版本大坑：Boot 3 vs Boot 4（你笔记里两种说法打架的原因）

**Boot 4 把自动配置类从 `spring-boot-autoconfigure` 里搬出去了。**

实测对比同一台机器上的两个 jar：

| | **3.3.5**（尚硅谷课、生产主流） | **4.1.1**（最新） |
|---|---|---|
| jar 体积 | 1,919 KB | **364 KB**（缩到 19%） |
| `.class` 总数 | 1,397 | 258 |
| `*AutoConfiguration` 配置类 | **152 个** | **12 个** |
| `.imports` 清单 | 12,633 B / **152 行** | 921 B / **12 行** |
| `WebMvcAutoConfiguration` 在哪 | `spring-boot-autoconfigure` | **不在了**，搬去 `spring-boot-webmvc-4.1.1.jar` |
| `DataSourceAutoConfiguration` 在哪 | `spring-boot-autoconfigure` | **不在了**，搬去 `spring-boot-jdbc-4.1.1.jar` |
| 留在 sba 里的 12 个 | — | 只剩 `AopAutoConfiguration`、`JmxAutoConfiguration`、`TaskExecutionAutoConfiguration`、`SslAutoConfiguration`、`MessageSourceAutoConfiguration` 这类**不依赖具体技术栈**的 |

**Boot 4 的做法**：每个技术领域一个"模块 jar"，各自带自己的 `.imports`：

```
spring-boot-webmvc.jar     →  WebMvcAutoConfiguration / DispatcherServletAutoConfiguration …
spring-boot-tomcat.jar     →  ServletWebServerFactoryAutoConfiguration …
spring-boot-jdbc.jar       →  DataSourceAutoConfiguration …
spring-boot-jackson.jar    →  JacksonAutoConfiguration …
```

> 所以：
> - 如果你跟着**尚硅谷 SB3** 学 → 按本笔记正文（3.x）理解，**`spring-boot-autoconfigure` 就是那个大货仓**。
> - 如果你哪天升级到 **Boot 4** → 打开 sba 只会看到 12 个类，别以为"自动配置没了"，
>   登录 [Spring Boot 4 迁移文档](https://github.com/spring-projects/spring-boot/wiki) 看模块拆分表。
> - 你另一篇 [[03-自动配置是怎么实现的]] 里那张表是按 **4.1.1** 写的，
>   所以那篇说"元数据在 `spring-boot-webmvc.jar`"——**两篇都对，只是版本不同**。

---

## 7. 自己验证一遍（命令可直接抄）

```powershell
# 拆开 jar，看里面到底有什么（jar 就是 zip）
Add-Type -AssemblyName System.IO.Compression.FileSystem
$jar = "$env:USERPROFILE\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.3.5\spring-boot-autoconfigure-3.3.5.jar"
$z = [System.IO.Compression.ZipFile]::OpenRead($jar)

# ① 数配置类有几个
($z.Entries | Where-Object { $_.FullName -like '*AutoConfiguration.class' -and $_.FullName -notlike '*$*' }).Count

# ② 看 META-INF 下有什么（清单 + 两份元数据）
$z.Entries | Where-Object { $_.FullName -like 'META-INF/*' } | ForEach-Object { "$($_.FullName)  ($($_.Length) B)" }

# ③ 读清单
$e = $z.Entries | Where-Object { $_.FullName -like 'META-INF/spring/*.imports' }
(New-Object System.IO.StreamReader($e.Open())).ReadToEnd()
$z.Dispose()

# ④ 看注解的真身（javap 在 JDK 的 bin 下）
javap -v -cp $jar org.springframework.boot.autoconfigure.EnableAutoConfiguration

# ⑤ 运行时问它"谁生效了"
#    启动加 --debug  → 打印条件评估报告
#    或 application.yml: logging.level.org.springframework.boot.autoconfigure=DEBUG
```

---

## 8.5 ⚠️ 自测纠错：我自己复述时踩的三个坑

### 坑 A：「sba 里有很多配置类，servlet 相关的类就在其中一个配置类中」——两层错

**错层 1：sba 里只有"配方"，没有"原料"。**
实测 `spring-boot-autoconfigure-3.3.5.jar` 里 **非 `org.springframework.boot.autoconfigure` 开头的 class = 0 个**。

```
DispatcherServlet   的真正 class 文件 → spring-webmvc.jar
Tomcat              的真正 class 文件 → tomcat-embed-core.jar
HandlerMapping      的真正 class 文件 → spring-webmvc.jar
sba 里的类                          → 只写"怎么把它们 new 出来、按什么顺序装配"
```

**错层 2：web/servlet 不是"一个"配置类，是一组 5 个，而且有先后顺序。**

```
org/springframework/boot/autoconfigure/web/servlet/
    ServletWebServerFactoryAutoConfiguration   造 Tomcat（最先生效）
    DispatcherServletAutoConfiguration         造 DispatcherServlet
    WebMvcAutoConfiguration                   造 HandlerMapping / HandlerAdapter / 视图解析器
    HttpEncodingAutoConfiguration              造 CharacterEncodingFilter
    MultipartAutoConfiguration                 造 MultipartResolver
```

顺序靠注解声明，不是靠运气 —— `DispatcherServletAutoConfiguration` 第 66 行：

```java
@AutoConfiguration(after = ServletWebServerFactoryAutoConfiguration.class)
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass(DispatcherServlet.class)
public class DispatcherServletAutoConfiguration {
    @Bean(name = DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet(WebMvcProperties webMvcProperties) { ... }
}
```

> **正确说法**：sba 里的配置类是**配方**，它用 `@Bean` 方法把 classpath 上（`spring-webmvc.jar` 等）的类
> **new 成 Bean** 注册进容器。原料不在 sba 里，配方才在。

### 坑 B：「这个好像是用 SPI 实现的」——思想对，机制错

**对的部分**：确实是 SPI 思想 —— 约定一个固定位置的文件、扫描整个 classpath、实现类与调用方解耦。

**错的部分**：**不是 `spring.factories` + `SpringFactoriesLoader`，也不是 Java 原生 `ServiceLoader`。**

三个机制的实盘对比（全部源码验证）：

| | `ServiceLoader`（Java 原生） | `SpringFactoriesLoader` | **`ImportCandidates`**（自动配置真用的） |
|---|---|---|---|
| 文件位置 | `META-INF/services/<接口全限定名>` | `META-INF/spring.factories` | `META-INF/spring/<注解全限定名>.imports` |
| 文件格式 | 一行一个类名 | **Properties**（key = 接口，value = 逗号分隔实现） | **一行一个类名，支持 `#` 注释** |
| 住在哪 | JDK | `spring-core.jar` | **`spring-boot.jar`**（Boot 自研） |
| 用途 | 通用 SPI | 监听器 / 失败分析器 / `EnvironmentPostProcessor` | **自动配置清单** |
| 是否实例化 | 是 | **是**（`instantiateFactory`） | **否，只要类名字符串**，真假由后面的条件注解决定 |

源码铁证 —— `ImportCandidates` 里既没有 `SpringFactoriesLoader` 也没有 `ServiceLoader`：

```java
private static final String LOCATION = "META-INF/spring/%s.imports";
private static final String COMMENT_START = "#";
...
private static Enumeration<URL> findUrlsInClasspath(ClassLoader classLoader, String location) {
    return classLoader.getResources(location);      // ← 就是最朴素的 ClassLoader 资源查找
}
```

**为什么不用 Java 原生 `ServiceLoader`？** 三条硬伤：
1. `ServiceLoader` 一个接口只能对应一个文件，**没法按注解分类**（Boot 需要按 `@AutoConfiguration` / `@ManagementContextConfiguration` / `@AutoConfigureWebServer` 分好几份清单）；
2. `ServiceLoader` **必须实例化**才能拿到实现，而自动配置需要的是**先拿类名做条件判断，条件不过就不加载类**（省内存、省启动时间）；
3. `ServiceLoader` 文件里放不了「排除/排序」这类元数据。

### 坑 C：「`@SpringBootConfiguration` 负责标注这是配置类，也就是标记启动类呗」—— 对，但漏了它最实用的作用

它**不是** `@Configuration` 的纯别名，多了两样：

```java
@Target(ElementType.TYPE) @Retention(RUNTIME) @Documented
@Configuration      // 这层是"我是配置类"
@Indexed            // ★ 这层让 spring-context-indexer 能编译期生成索引
public @interface SpringBootConfiguration { ... }
```

**它是测试切片的"锚点"。** 你写 `@SpringBootTest` 不指定 `classes` 时，Boot 就是靠**找 `@SpringBootConfiguration`** 来定位启动类的 ——
`SpringBootTestContextBootstrapper` 第 245 行：

```java
Class<?> found = new AnnotatedClassFinder(SpringBootConfiguration.class).findFromClass(testClass);
Assert.state(found != null, "Unable to find a @SpringBootConfiguration, you need to use "
        + "@ContextConfiguration or @SpringBootTest(classes=...) with your test");
```

> 那句报错 **"Unable to find a @SpringBootConfiguration"** 就是它抛的 —— 这也是为什么
> **一个应用只能有一个 `@SpringBootConfiguration`**（javadoc 原话：Application should only ever include *one*）。
>
> 另外："启动类"是**约定**（带 `main()` 的那个类习惯上标 `@SpringBootApplication`），
> 不是 `@SpringBootConfiguration` 强制的 —— 它只是"配置类"，是不是启动类取决于你有没有写 `main()`。

---

## 8. 一页速记

```
@SpringBootApplication  =  @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
                            （注释本身住在 spring-boot-autoconfigure.jar 里）

spring-boot-autoconfigure 里装的：
    152 个 XXXAutoConfiguration 配置类   ← 货
    1 份 .imports 纯文本清单             ← 货运单
    2 份元数据（IDE 提示 / 条件预筛）
    spring.factories（只装监听器杂项，不装自动配置类）

扫描不到的原因：
    ① 包路径不同（com.atguigu.boot ≠ org.springframework.boot.autoconfigure）← 根本原因
    ② @SpringBootApplication 主动挂了 AutoConfigurationExcludeFilter
    ③ 包扫描按路径找 / 自动配置按清单找，两条独立的路

@EnableAutoConfiguration 的作用：
    在 @SpringBootApplication 上再加 = 零效果（@Import 收集用 Set 去重，官方 javadoc 明说）
    有用 = 不用 @SpringBootApplication 时 / 要 exclude / 写 starter / 测试切片
```
