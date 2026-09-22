java的类型转换比较特殊
先说数据类型
byte short int long float double
按照这个从小到大的顺序, 所有运算都会被隐式转换成更大的类型
比如一个int 加 一个double 结果就是double
只看这里没啥感觉, 但是java特殊的点在于, 你的数据类型要跟运算的类型一致, 否则会报错, 啥意思, 就是不可以
int a = 10;
double b = 2.22;
int c = a + b;
这是错的, 要写 int c = (int)(a + b); 
也就是a + b实际上是被隐式转换成了double类型, 它的类型就固定了, 必须要用double类型去接收它

还有一点就是byte 和 short 虽然都是小于int的但是运算会被隐式强制转换成int
byte a = 10;
short b = 33;
计算 a + b 的时候会把这个值直接转为 int 类型

**总的来说在运算中会把两个数据类型强制统一成更大的那个类型, 但是byte和short会强制变成int
而且要注意不能直接把大类型赋值给小类型**