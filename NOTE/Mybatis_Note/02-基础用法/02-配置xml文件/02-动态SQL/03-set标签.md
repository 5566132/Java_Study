这个很明显了, 是作用于update语句的
所以你可以根据update语句的特性推测出 这个玩意可以去掉 逗号 ,
update t_emp set name = "", age = "" where 条件
使用方法跟where没啥区别
