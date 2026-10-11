## bean的生命周期
1.调用无参构造创建实例
2.调用set方法注入属性
3.调用**后置处理器(前置处理)**
4.调用initMethod初始化bean
5.调用**后置处理器(后置处理)**
6.调用destoryMethod销毁bean
7.容器销毁

对于单例Bean, 在容器中就已经创建好了这个Bean的对象了, 你看第一步, 调用无参构造就能看出来, set注入, init初始话也是针对这个对象的, 然后后置处理器部分如果需要被增强会创建一个新的代理类, 代理类内部需要调用原类中的方法, 最后容器中存在的是代理类的对象, getBean也是返回代理类的对象

## 后置处理器 BeanPostProcessor
这个是用来对bean做一些微调, 扩展的, 应该挺常用的
这是一个接口内部有两个方法, 分别作用于对bean的初始化之前和之后
用之前要先创建类实现接口
// 实现 BeanPostProcessor 接口
public class MyPostProcessor implements BeanPostProcessor {
    // init之前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==== 初始化前置：" + beanName);
        return bean; // 可以直接返回原对象，也可以替换成新对象
    }
    // init之后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==== 初始化后置：" + beanName);
        return bean;
    }
}
**后置处理器用之前要在spring里面创建这个对象的bean, 之后所有的bean被创建时都会自动用上这个后置处理器**

## initMethod 和 destoryMethod
**这两个方法是写在类内部的**, 可以回忆一下, 一般类都要有初始化方法去配置一下里面的内容的, 比如管理类, 要把初始化界面啥的方法都写在初始化方法里面而非空参构造
依旧要写在bean的标签部分
init-method = "初始化的方法名"
destory-method = "销毁方法名"
