一共有5个, 现在先说2个
指定bean的作用域要在创建bean的时候用 scope 关键字去指定
就是和id  class写在一起就行
\<bean id = "" class = ""  scope = "">\</bean>

## singleton 单例
这个会在容器创建的时候new一个对象, 而且只会new这一次, 之后针对这个bean的操作都是针对这一个对象, 比如每次容器调用getBean()都是获得这个对象, 不会new一个新的


## prototype 多例
每次需要用到这个bean的时候都会new一个, 比如容器调用getBean()的时候都会新new而不是复用

