这个标签是更自由的标签, 可以说是set和where的完全升级版
内部可以指定前缀添加什么, 前缀忽略什么, 后缀添加什么, 后缀忽略什么
基本规则就是标签内部的sql被理解为拼接sql, 忽略的时候指的是内部sql, 
而拼接则是独立于内部的这个sql, 在这个sql的两侧(也就是前后)添加

所以要根据特性去匹配场景使用这个标签
```
<!--    根据集合中的id查询Emp-->  
<select id="getEmpByList" resultType="com.atguigu.mybatis.bean.emp.Emp">  
    select * from t_emp  
        <trim prefix="where " prefixOverrides="or" suffix="" suffixOverrides="or">  
            <foreach collection="list" item="id">  
                 id = #{id} or  
            </foreach>  
        </trim>  
</select>
```
内部是个循环读取集合中的元素, 也就是:
select `*` from t_emp where id = ? or id = ? (or) -> 这个or会被删除, 

### 四个字段说明
1.prefix前缀添加
2.prefixOverrides前缀覆盖, 也就是忽略内部sql的指定前缀
3.suffix
4.suffixOverrides

# 重点
你记得我说的where标签那个特性吗(set也有) 如果无内部sql, where标签也不会起作用, 意思就是不会凭空给你加个where = 导致sql错误
没错, trim也有同样的特性, 内部无sql这个trim标签直接不生效了 , 前缀后缀啥的都没用了, 但是这个是建立在集合存在但是内部无元素的基础上, 要是集合为空传进去就错了

