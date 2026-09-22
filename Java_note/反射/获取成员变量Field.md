Class c1 = Stu.class;
这个获取的方法跟Constructor一摸一样, 都是四个 分别是
获取单一public成员变量 获取单一任意变量 获取所有public  获取所有
Field f1 = c1.getDeclaredField(成员变量名);
