因为Mybatis-Plus会用到注解去做类和表之间的映射, 所以底层就有TableInfo这个结构去发挥记录映射关系的作用, 也就是说MP中用在类上的注解都是为了构建出这张表而存在的, 
```
【启动时,一次性,只做一回】
  TableInfo  →  拼出 SQL 模板字符串  →  注册成 MappedStatement 存进 MyBatis 配置
                 │
                 └─ "SELECT id,t_name AS name,age,salary,... FROM tb_user ${ew.customSqlSegment}"
                                                                         ↑ 留了个口子

【运行时,每次调用】
  你的 wrapper → 生成 where 文本 "WHERE (t_name LIKE ? AND salary >= ? ...)"
                      ↓
  把模板里的 ${ew.customSqlSegment} 这个口子替换掉  →  完整 SQL  →  交给数据库
```
其实这个表就是为了根据已有注解去提前创建好部分sql, 以便之后sql调用的时候可以拼接
spring在初始化的时候会有个阶段MP去扫描所有的BaseMapper\<T>的泛型T, 然后反射拿到注解去拼凑sql , 然后放到Tableinfo存起来, 之后用到的时候会拿到专属的sql, 比如