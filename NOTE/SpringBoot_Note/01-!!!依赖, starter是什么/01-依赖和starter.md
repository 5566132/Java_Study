哈哈哈哈哈哈哈哈!!!!
我知道了
## 依赖
```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>
```
依赖就是用\<dependency>标签引入的jar包, 这个东西就是依赖, 
注意看, 这个东西内部没有starter

## starter
```
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-web</artifactId>  
</dependency>
```
这个东西理论上不是starter, 这也是一个依赖
`spring-boot-starter-web`这个才是starter

## starter是什么
starter就是一个聚合依赖(一个pom.xml文件), 但是这个东西的存在是为了服务一些特定的场景的, 比如这个web相关的, 所以, 一个starter内部就配备这个场景所需的依赖以及自动配置的