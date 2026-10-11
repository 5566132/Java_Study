[file:/D:/A_java/Java_Spring_study/spring6/spring6-ioc-class/src/main/java/com/class1/Son_map/Student.java](file:///D:/A_java/Java_Spring_study/spring6/spring6-ioc-class/src/main/java/com/class1/Son_map/Student.java)

[file:/D:/A_java/Java_Spring_study/spring6/spring6-ioc-class/src/main/java/com/class1/Son_map/Teacher.java](file:///D:/A_java/Java_Spring_study/spring6/spring6-ioc-class/src/main/java/com/class1/Son_map/Teacher.java)
之后先暂时用这两个类举例子, 方便说明
要配置一个bean最基本的就是
\<bean 内容>\</bean>
内容部分要写 id = "user1" class = "包名.类名"  注: id不能重复
其中id就是对于配置的这个bean的唯一标识, 以后要在当前xml里面用这个bean就要用这个id , 在用spring在main里面创建对象的时候也要用这个id去指明要创建的对象
**bean创建的对象都是先调用无参构造, 再用setName()方法赋值的, 所以要在类内部写好赋值方法**

bean内部属性赋值
大体上, 基本所有的属性赋值都要写
\<property name = "**重点**">

\</property>
**重点部分就是name之后的变量指定**
**首先要知道java类的内部对变量的set方法有个软性要求就是set加成员名且首字母大写**
**也就是setName()**
**这个重点的位置就要写这个set后面的名称的首字母小写, 也就是Name把N小写 name**
只是根据类成员类型的不同会有不同的写法, 比如
基本数据类型用value就行
引用数据类型要用ref(注入) , 但是注入的方式还有区分, 可以用内部bean, 外部bean, 级联属性注入
还有对于数组, 集合这种类型也有特有的注入方式
之后的章节会学

比如对于这个Teacher类, 我就完全可以写
\<bean id = "teacher1" class = "com.class1.Son_map.Teacher">
	\<property name = >
		\<value>值\</value>
	\</property>
\</bean>
对于基本数据类型可以用value赋值, 写的时候是不是字符串都不用写""直接把内容写进去就行
