这个东西是 IService\<>这个接口中特有的方法,我直接先依据dph的回答描述一下关键部分吧

首先, UserServiceImpl会被spring注册成bean, 这个实现类继承了ServiceImpl\<UserMapper, User> 这个泛型类, 同时实现了UserService这个父接口
##### lambdaQuery()方法如何知道用自己的非条件部分要拼接什么?
1.lambdaQuery()方法是IService\<>接口中的, 一般都是在UserServiceImpl这个实现类中被用来拼接sql的条件部分(其实也只能在这里被调用因为UserService是接口,  
ServiceImpl是\<M, T> 是自带的实现类我改不了), 
2.重点就是ServiceImpl这个接口的泛型, 看一下这个接口的源码就会发现内部有一个 M类型的对象, 而这个M类型的对象, 传递的恰好就是UserMapper, 结合[[02-流程图]]可知, sql模板已经被存储好了, 只需要根据UserMapper的对象就可以得到id然后取出sql模板, 然后和传进来的条件拼接成完整sql
所以, 思考, ServiceImpl中方法已经齐全了, 有UserMapper提供获取模板的id, 有方法可以接收条件构造器拼接sql的条件 , 二者结合就成了完整sql
所以lambdaQuery()的list()方法就是用来实现这个过程的