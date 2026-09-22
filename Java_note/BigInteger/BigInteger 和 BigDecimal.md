这两个类就类似高精度的实现, 相当于把高精度给封装成了类
**特性和字符串一样, 依旧不可变**
创建变量有两种方法, 
一般小数在long范围内, 用静态方法 BigInteger.valueOf(999999L);
如果输入就是一个大数就直接 new BigInteger(标准输入);  就可以

这两个类的内部有 加减乘除取余 的方法, 调用都会返回调用者类型的对象, 因为这个类的对象是不可修改的, 所以, 都要用对象接收返回值
BigInteger b1 = BigInteger.valueOf(1);
b1 = b1.add(b1);   -> b1 变成2
b1 = b1.multiply(b1);  ->  b1 变成4
b1.subtract(b1); 减法
b1.divide(b1); 除法
b1.mod(b1); 取余
b1.pow( int ) 求幂
以上方法除了pow都需要传递 BigInteger 类的对象, 


