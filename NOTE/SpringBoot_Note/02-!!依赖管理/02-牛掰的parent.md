```
<parent>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-parent</artifactId>  
    <version>4.1.1</version>  
    <relativePath/> <!-- lookup parent from repository -->  
</parent>
```
这个是模块的pom.xml自带的一个标签
这个标签中, 主要是这里`<artifactId>spring-boot-starter-parent</artifactId>`
存放了所有依赖的默认信息(比如版本信息), 当然还有别的信息, 这里就只说依赖的
那么这就能实现一个功能就是, **只需要导入依赖的名称, 就可以成功导入这个依赖**
当然, 有的依赖是没写在里面的, 所以需要你自己导入版本