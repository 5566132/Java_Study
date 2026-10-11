其实条件构造器很像是创造了一个sql语句, 创造完成之后还需要Mapper接口的实现类对象去调用相关方法把条件构造器传递进去
## QueryWapper
这个负责查询数据, 内置有与select语句相关联的所有条件啥的
```
QueryWapper<User> qw = new QueryWapper<User>()
		.select("id", "t_name", "t_age")
		.like("t_name", "张")
		.ge("t_age", 30);
```
我逐一解析这都什么意思
0.注意右值也需要用\<User>泛型不然就会返回\<Object>的泛型, 跟左值不匹配
1.new出来一个条件构造器, 类似创建了一个sql但是sql是空的
2.select限定字段, 也就是要使用select语句同时要select这几个字段
3.like利用模糊匹配, 要模糊匹配t_name字段为 %张%
4.ge意思是greater&equals 大于等于 , 也就是限定t_age字段要大于等于30
拼起来就是
select id, t_name, t_age from t_user