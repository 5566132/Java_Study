其实注解就是通过@+关键字的形式把类变成bean
所以有几个关键字可以把类变成bean, 或者说让类可以被扫描为bean
@Component
@Repository
@Service
@Controller
这几个关键字一点区别都没有, 这么分类的原因是
java为了业务方便 , 把各个类型的代码分了几个模块 , 好像有什么控制层Controller
服务层Service , 数据层 Dao 分块的重要目的是让特定职责的代码写在特定模块, 方便管理, 但实际上这些都是java代码, 这些划分只是在逻辑上的, 这几个关键字也是为了方便这个分层思想的使用去划分的

@Component
public class Controller{
	内容
}
这么写这个类就被创建成了一个bean, 当然, 如果需要的话可以在注解后面写上这个类的id @Component("controller")
