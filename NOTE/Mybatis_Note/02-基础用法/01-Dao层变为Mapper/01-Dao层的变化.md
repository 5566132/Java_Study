之前, 要把sql和返回结果啥的在Dao层的实现类中实现, 现在只需要创建Dao层的接口无需创建实现类, 用xml文件配置就能达到相同的效果
当然, 这个是依靠代理实现的
对了, 现在我们就不叫Dao层了, 改名叫Mapper了

具体流程就是创建一个接口跟之前那个Dao层一样, 规定好内部方法的职责和参数和返回值, 最重要的是用@Mapper注解这个接口, 无需创建这个接口的实现类对象了

```
@Mapper  
public interface OrderMapper {  
    Order getOrderById(@Param("id") Long id);  
}
```
大概就是这样
对了, 参数最好都要用Param("主要名称")去指定, 方便xml配置的时候使用
