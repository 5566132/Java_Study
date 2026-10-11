用之前先在xmlns里面导入一下

## util
用之前要利用xmlns的那套规则去
这个东西最常用的场景就是: 解决List Set Map等没法单独创建一个bean去给其他bean注入值, 有了util就可以在xml里面创建这些集合把这些创建的util当作一个bean去使用
\<util:list id = "这个list的唯一标识">
	内容
\</util:list>
内容部分就是之前注入list的时候\<list>\</list>的内容部分, 完全一样


## p
这个东西的主要作用是简化属性注入的书写, 因为一般写法要用property name = ""
value = ""   ref bean = ""这个方式去注入, 还是比较繁琐的
这个就可以简化这个写法
**用这个东西之前要用xmlns导入特殊标识URL, 但是不用写入xsi**
基本数据类型:
p:name = "你好"
p:age = "999"
引用数据类型, 包括集合啥的
p:成员名-ref = "xml里面的bean或者util的id"

