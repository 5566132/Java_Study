JdbcTemplate jt;
回忆一下, 这个东西只是为了方便在java代码里面操作的, 大概流程如下
JdbcTemplate → 找 DataSource 要 Connection → 用 Connection 创建 PreparedStatement 执行 SQL → 处理结果 → 归还 Connection
这个东西在springboot里面会被自动注册成bean, 不需要自己配置, 直接用@Autowired注入即可

先说一下, 这个类的方法都要传递一个字符串spl语句去描述行为, 关键部分用?以便后序操作
## 增, 删, 改
用改举个例子
一般都不能把语句写死, 因为不可能每次修改都是固定的
public void updateEmp(Employee e){
	String sql = "update emp set name = '?' where id = ?";
	jt.update(sql, e.getName() , e.getId() );
}
这三类语句除了sql不同, 基本都是这样, 不能把条件啥的写死了

## 查询
把这个单独拉出来说是因为这个涉及到 BeanPropertyRowMapper\<>这个类
**BeanPropertyRowMapper\<>(class)的作用是把数据库查询的一行结果自动转成实体对象 , 括号中要传递类的class对象, 就是Emp.class之类的** 
所以你就知道为什么要把查询单独说了
查询可以查单条, 也可以查多条, 用到的方法不同
Employee e = jt.queryForObject(sql, new BeanPropertyRowMapper\<>( Employee.class ));
List\<Employee> e = jt.query(sql, new BeanPropertyRowMapper\<>( Employee.class ));

