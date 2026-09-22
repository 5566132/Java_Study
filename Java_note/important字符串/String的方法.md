String类可以直接赋值, 也能用new去赋值
String s1 = "abc";
String s2 = new String();
char`[]` temp = new char`[]`{'a', 'b', 'c'};
String s3 = new String(temp);

因为这个String是类, 它的实例都是引用数据类型, 没法比较, 所以有了一个方法
s1.equals(s2)这个就是逐字符比较两个字符串
s1.equalsIgnoreCase(s2)忽略大小写

字符串截取
s1.substring(0, 3) 截取下标0到2的字符串,这个返回的是一个字符串,

字符串替换
s1.replace("a", "AA") 把a替换成AA, 返回一个新的字符串, 

其实这些方法你结合字符串不可被改变的特性就能知道返回的是一个新的字符串实例, 
所以你要用一个字符串去接收这些返回值才能保留他们

**String`[]` split( 正则表达式, 分割成的数量 )**
**这个方法就是你指定根据正则表达式的规则去给一个字符串分割成多个部分, 不指定数量就全分割, 指定就按指定的数量分割**
