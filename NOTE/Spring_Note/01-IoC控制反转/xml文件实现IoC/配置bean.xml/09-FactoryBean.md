这个东西就是把一个类的创建写在了实现了FactoryBean这个接口的类的方法里
听起来感觉有点毛病, 我都用bean注入属性了, 还要再创建一个类去new这个对象
这个主要是适用于一些很复杂的类, 内部的初始化, 属性注入可能要写一堆东西,
用java代码的方式可能更简洁, 这个还是比较重要的

public class MyFactoryBean implements FactoryBean\<User>{
	@Override
	public User getObject(){
		手动初始化内容
		return User;
	}
	@Override
	public User getObjectType(){
		return User.class;
	}
}
如果你对Controller使用FactoryBean那spring就不会自动把内部的类创建和注入, 也就是你需要在getObject里面把Controller内部的成员都初始化好然后返回

现在回看这个FactoryBean其实起到的功能和 配置类 差不多, 但是还是有一点业务划分的, FactoryBean更多是将一个Bean独立出来, 放在配置类里面就杂乱些了
