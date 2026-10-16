这个东西是核心场景启动器中的一部分, 
这个东西是一个包含了很多个配置类的jar包, 很多场景需要的组件就是内部的配置类放入spring容器的
内部的自动配置类,真的就是配置类用@AutoConfiguration注解去标注的, 

但是spring-boot-autoconfigure中的自动配置类是无法被自动扫描到的, 所以需要
@EnableAutoConfiguration去实现导入, 
