```
<select id="getEmployeeById" resultType = "com.atguigu.bean.Employee">  
	select * from Employee where id = #{id}
</select>
```
这个很简单, 就三个部分
1.id = "" 这部分指定本条语句( 从\<select> 到 \</select> )是针对接口中的哪个方法的, 也就是
映射的这个id指定的那个方法, 所以 id 里面要写接口中的方法名
2.resultType = "" 这个用来指定返回值的类型, 要指定全类名, 其实最好看一下这个
名称resultType -> 结果类型 , 是指定结果是什么类型的, 因为之后会有别的返回结果, 死记硬背忘得快
3.#{id} 这个东西是取值用的 , 把id指定的这个方法的参数拿来使用, 用的是Param("id")指定的

### 注意点
理论上, 只写一个select语句底层是自动根据类名和表中的字段名匹配的, 
也就是 Employee中成员名要与表中字段名完全一样才能把字段的值赋值给Employee, 
否则就是null


好了, 这是最基础的用法, 之后还有更麻烦的等着我呢## 🙄
