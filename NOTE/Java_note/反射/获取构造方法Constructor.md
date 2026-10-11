## 认识Constructor类, 以及获取Constructor类
Constructor就是构造方法的意思, 与获取构造方法相关的方法靠英文很好记忆

Constructor 对象里面就是存放指定的构造方法的全部信息(包括参数, 权限修饰符等), 通过特定方法可以获取, 其实就是可以理解成把这个类的class文件中的构造方法部分获取了
Class c1 = Stu.class;

c1.getConstructor(参数); 返回与指定参数对应, 且是public修饰的构造方法的信息, 参数必须是 .class形式
比如参数是 String.class 就返回Stu类的有一个参数, public修饰, 且是String的那个构造方法的信息

c1.getDeclaredConstructor(参数); 相较于上面可以获得所有权限的构造方法

c1.getConstructors();  -> 多了一个 s 这个会返回一个Constructor数组, 但是只能是public修饰的方法

c1.getDeclareConstructors(); -> 这个就可以返回全部构造方法

## 利用Constructor类获取构造方法的信息
Constructor con = c1.getDeclaredConstructor( String.class , int.class ); 假设这个构造方法是private的

int modifiers = con.getModifiers(); 获取该构造方法的**修饰符**信息,java把这个所有修饰符都用二进制中的某一位表示, 所以很好表达构造方法被什么修饰符修饰了
![[Pasted image 20260920001431.png]]

con1.getParameters(); 把这个构造方法的**参数**包装成数组返回, 返回的是Parameter对象

创建类对象
如果我有一个构造方法类 的对象
那我可以 Stu s1 = (Stu)con1.newInstance(参数); 去创建一个类的对象
但是如果con1这个对象存储的构造方法是私有的要 con1.setAccessible(true);取消权限限制
