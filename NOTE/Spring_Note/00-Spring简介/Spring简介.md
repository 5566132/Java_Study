Spring就是个java的开发框架, 目的就是为了简化对对象的管理和控制, 也就是IOC
和在不修改源代码的基础上添加新的业务 AOP

Spring也被叫做容器, 对对象的管理都是通过这个容器的
形式上 
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
这就算创建了一个容器, 一个容器里面可以放多个xml  扫描注解 导入外部文件啥的, 
这些东西本身是不互通的, 但是导入到容器之间就互通了, 之后要注入啥东西, 比如@AutoWired, 都是去容器里面找