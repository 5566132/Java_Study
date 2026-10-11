**首先要明确一点, @Autowired是按照Type注入属性的, 也就是要注入Service的时候会去spring里面找Service类型的bean然后注入, 当然, 按照类型就必然有问题就是多个该类型就会报错**
如果被注解为组件的类Controller有个Service成员
我想要给Service注入属性有如下几个方式

属性注入, 直接写在成员类上面
@Autowired
private Service se;

set方法注入
@Autowired
public void setSe( Service se ){
	this.se = se;
}

构造方法(构造器)注入

形参注入就是把注解写在有参构造的形参上

类内部只有一个构造而且是有参构造, 不写注解会自动用这个构造给Service注入

@Autowired 和 @Qualifier()
@Qualifier()就是为了指定一下注入的bean的id
因为只有@Autowired是按照类型注入的, 但是如果有多个这个类型的bean就会报错, 所以Qualifier就解决了这个问题, 

