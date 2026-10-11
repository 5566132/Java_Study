`<?xml version="1.0" encoding="UTF-8"?>`  
`<beans xmlns="http://www.springframework.org/schema/beans"`   
       `xmlns:util="http://www.springframework.org/schema/util"`  
       `xmlns:p="http://www.springframework.org/schema/p"` 
       
       `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`
       `xsi:schemaLocation="http://www.springframework.org/schema/util`  
       `http://www.springframework.org/schema/util/spring-util.xsd       http://www.springframework.org/schema/beans       http://www.springframework.org/schema/beans/spring-beans.xsd">`  
`</beans>`

这个xmlns是xml文件的最基本部分
这个东西就是用来导入 命名空间 的
命名空间就是存放一些关键字的地方, 导入才能用

导入默认命名空间bean的时候之直接
xmlns=`"http://www.springframework.org/schema/beans"`即可

但是别的命名空间都要求
xmlns:命名空间="地址"
理论上这一步的作用只是给这个地址的这个命名空间关键字起个别名
xmlns:util=`"http://www.springframework.org/schema/util"`
官方的说这个链接是命名空间URL, 理论上这个东西是为了给命名空间提供一个特殊标识, 而且必须要写, 基本是强制要求写成这个链接的形式

所以只写了这个还是用不了一些命名空间, 比如这个 bean util 就用不了
这个时候xsi就发挥作用了
先写一个xmlns:xsi="xsi的URL" 依旧是给xsi一个特殊标识
然后写xsi:schemaLocation="
命名空间的URL + xsd网址
"
xsd网址里面才写了这个命名空间的使用规则


## 总结
对于一个命名空间
首先要给它规定URL唯一标识
然后在xsi:schemaLocation里面把这个URL唯一标识和这个命名空间的xsd网址成对书写即可
这些命名空间完成所有导入步骤才能用这个关键字