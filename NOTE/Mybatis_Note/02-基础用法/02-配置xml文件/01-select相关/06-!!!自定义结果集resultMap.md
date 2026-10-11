这个作用很多 , 
## 1.字段映射
表中字段名和类中成员名不相同, 无法直接赋值, 需要用到字段映射
\<id column="" property="'>
\<result column="" property="">
因为自定义结果集都是作为\<select 的 resultMap的参数的, 所以column指的是select中查询出来的字段名, property指的是java中类的成员字段名

## 2.映射处理成员中的 类/集合
##### (1)类成员
这里说用 join 查询的时候
用left join合并两个表会有几个字段是属于 Customer类中的Order成员的内部的
所以没法直接用\<id column映射到Order内部, 所以需要\<association
\<association property="order(这个是Customer类中的Order成员名)" 
javaType="com.atgui.......Order">
	然后把对Order类的字段映射写到这里面就行
\</association>
##### (2)集合成员
\<collection property="list(这个是Customer类中的集合成员的名称)" 
ofType="集合内部变量的全类名">
	然后把对Order类的字段映射写到这里面就行
\</collection>

## 3.嵌套select处理成员中的 类/集合
总的来说, 依旧是利用association和collection关键字, 但是需要写的内容有所不同
之前是针对 left join语句建立字段的映射关系
这个是针对单一select语句, 在 结果集中用association再次调用select获取结果

场景, 上层的select已经获取到了Custormer的所有字段, 其中id字段是和t_order表中customer_id建立联系的关键, 也就是一个顾客会有多个订单, 一个订单只会根据它的customer_id字段唯一关联一个顾客
```
<collection property="orders"  
            ofType="com.atguigu.mybatis.bean.cus_order.Order"  
            select="com.atguigu.mybatis.mapper.cus_order.OrderMapper.getOrderByCustomerId"  
            column="id">  
</collection>
```
1.property指定成员名
2.ofType指定集合中元素的类型
3.select指定用用接口中的