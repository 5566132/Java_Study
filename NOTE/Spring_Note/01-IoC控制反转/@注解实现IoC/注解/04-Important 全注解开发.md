就是为了不写xml配置文件, 把扫描和bean配置功能写在一个类里面
现在只学了配置扫描的功能

创建一个**配置类**(其实就是一个类)

**@Configuration**
**@ComponentScan("com.atguigu.spring6")**
public class SpringConfig{
}

@Configuration就是指定该类是个配置类
@ComponentScan()是用来指定要扫描的包的
指定包有以下几个写法
先说明一点, 指定包的时候基本都是指定的这个包及其所有子包的内容

1.只扫描一个包
@ComponentScan("com.atguigu")

2.扫描多个包
@ComponentScan(basePackages = { "包1" , "包2" , "包3" })

3.类文件扫描包
@ComponentScan(basePackages = { 类1.class , 类2.class })
你记得吗, 一般类都会在第一行声明自己属于哪个包, 这个方式就是把这个声明作为包去扫描


我说一下一般业务配置类都长什么样子

@Configuration
@ComponentScan("包")
**可以导入外部文件@PropertySource( "classpath:db.properties" )**
**可以选择开启代理@EnableAspectAutoProxy要结合扫描保证@Aspent注解被扫描到**
可以指定内部bean的作用域@Scope
还有别的之后再说
public class config{
	内部可以用@Bean配置bean
}


