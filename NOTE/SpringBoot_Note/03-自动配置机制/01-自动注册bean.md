SpringBoot引入依赖之后就会自动把这个依赖场景所需的组件自动注册到spring中, 
我说个例子, 
controller层的那些 @GetMapping注解就是靠底层的一堆组件去自动实现的, 但是我根本看不到, 因为已经封装好了, 就封装成了这个注解, 但是底层的那些对象是实打实存在于spring中的

---

## 补：这个"自动"其实分了 5 步

上面的结论是对的, 但中间缺了最关键的一环 —— **SpringBoot 怎么知道"该注册谁"**。
详细证据见 [[03-自动配置是怎么实现的]], 这里只记链条:

```
1. @SpringBootApplication 里的 @EnableAutoConfiguration
2.     → @Import(AutoConfigurationImportSelector.class)
3.     → ImportCandidates.load() 汇总 classpath 上所有 jar 的
             META-INF/spring/*.imports   (纯文本清单, 只是类名)
4.     → 逐个类做条件检查: @ConditionalOnClass / @ConditionalOnMissingBean
5.     → 通过的交给 Spring 自己的 ConfigurationClassPostProcessor 注册成 Bean
```

**两个纠正**:

1. 第 5 步不是 SpringBoot 干的, 是 **Spring Framework** 的
   `ConfigurationClassPostProcessor`(住在 `spring-context.jar`)。
   SpringBoot 只负责"发现该配什么", "配"这个动作一直是 Spring 的老本行。

2. `@GetMapping` 底下那些组件(`RequestMappingHandlerMapping` 等),
   是**自动配置**造出来的, **不是包扫描**扫出来的 —— 见下一节。

## 补充: 它和"自动包扫描"是两条独立的路

|  | 自动包扫描 | 自动配置 |
|---|---|---|
| 触发 | `@ComponentScan` | `@EnableAutoConfiguration` |
| 目标 | **你自己写的**类 | **框架/第三方**写好的配置类 |
| 发现方式 | 按**包路径**扫 `.class` 文件 | 按**清单文件**读类名 |
| 范围 | 主程序所在包及子包 | 整个 classpath 上所有 jar |
| 产物 | 你的 `@Service`、`@Controller` | `DispatcherServlet`、`ObjectMapper` |

两者都在 `@SpringBootApplication` 这一个注解里, 但走的是完全不同的机制。
**包扫描永远扫不到框架 jar 里的类**, 这就是必须要有 `.imports` 清单的原因。
