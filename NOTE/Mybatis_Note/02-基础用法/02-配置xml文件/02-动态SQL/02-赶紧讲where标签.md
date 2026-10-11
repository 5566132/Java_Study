```
<select id="getEmpByNameAndSalary" resultMap="com.atguigu.mybatis.mapper.dynamicSql.EmpDynamicSqlMapper.EmpMP">  
    select * from t_emp  
    <where>  
        <if test="name != null">  
            and emp_name = #{name}  
        </if>  
        <if test="salary != null">  
            and emp_salary = #{salary}  
        </if>  
    </where>  
</select>
```
where就是为了解决刚才的情况, 这个标签可以删除它范围内sql的开头的and, 刚好解决and可能开头的情况
而且如果内部没有拼接内容它就不会给原sql中拼接一个where, 相当于直接无条件查询
