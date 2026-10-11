依旧跟上面那两个一样
四个获取Method对象的方法

## Method的方法
其实对于反射这个知识, 你只要知道你操作的是什么比如现在操作的就是成员方法, 那你就能获得成员方法的任何东西, 做到成员方法能做的任何行为
比如 一个成员方法
private String eat( String name , int age ) throws IOException{
	内容
	return "666";
}
但看整体框架, 有 权限修饰符 返回值类型 方法名 形参 抛出的异常 
可以做到 执行内容 返回返回值
所以, 通过反射也都可以获得/做到 这些内容

依旧Method要依靠Class对象获取
Method m1 = Stu.class.getDeclaredMethod( "方法名", 形参...(要写全, 且是 .class 类型的) )

获取权限修饰符, 记得吗, 二进制表示, 每一位代表一个权限
int modifier1 = m1.getModifiers();

获取返回值类型, 一般返回的都是Class\<?>类型, 而非具体的某个类型
Class\<?> c1 = m1.getReturnType();

获取方法名
String name1  = m1.getName();

形参(Parameter), 
Parameter`[]` p1 = m1.getParameters();

异常返回的是Class对象
Class\<?>`[]` exc = m1.getExceptions();

**用Method对象调用方法**
m1.invoke( Stu对象名 , 方法形参... );
这个方法会返回Object对象
invoke会调用参数对象内部的这个m1对应的方法, 



