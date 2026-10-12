
首先你需要知道这个东西只能在UserServiceImpl这个类的方法中使用, 
其次, 你要知道这是个方法
```
比如我要查询, 我传进来个条件类叫做p1,有name, minSalary两个字段
name = p1.getName();
minSalary = p2.getMinSalary();

lambdaQuery()
	.select(User::getId, User::getName)
	.like(name != null, User::getName , name)
	.ge(minSalary != null , User::getSalary , minSalary)
	.list();
```
这个方法一般都是链式的, 要不就构造成一个条件然后传递给本层的UserMapper成员
要不就直接调用list() one() 方法直接触发查询返回结果

### 条件部分
sql语法中的条件用这些方法基本都能实现, 这里只说两个例子
select()可以指定需要查询哪几个字段, 用方法引用传递字段

like()有三个参数, 
第一个要接收boolean值, 返回true这个条件才生效, 反之这个条件就无效了
第二个参数是方法引用, 作用是传递这个条件是针对哪个字段的, 根据这个方法引用会找的这个方法对应的是哪个成员字段(name成员), 然后找到这个成员的注解(@TableField("t_name"))才能构造出
t_name like ? 这部分
最后一个参数就是填值用的, 填到?处就行了

## 总结
综上所述, 使用lambdaQuery()基本就是可以完全自己构造sql去查询
