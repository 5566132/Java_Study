在Mybatis中就已经出现了Mapper层, 那里是把Dao层替换成Mapper层, 没有其他变化了, 语义上就是为了体现**映射**这个关键词, 因为xml的配置都是与Mapper接口相映射的
在MP中Mapper层依旧是接口, 而MP的增强体现在BaseMapper\<>这个接口上,
这个接口中有Mapper层中大部分常用的简单sql方法, Mapper接口继承了这个接口后就无需对简单sql进行实现了, 对象可以直接调用相关方法(当然, MP会对mapper包下面的接口自动扫描, 你甚至不需要主动配置扫描Mapper接口会被自动代理然后放入spring容器)

