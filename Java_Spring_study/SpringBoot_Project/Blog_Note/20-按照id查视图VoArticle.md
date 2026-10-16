1.先按照id查文章, 信息保留, 获得user_id
2.然后用UserMapper对象去获得user的数据库对象, 
3.然后用user数据库对象去获得user的简单视图


4.用文章的id去结合comment的article_id字段去查询这个文章的所有comment,
5.然后再利用这个comment对象去构造comment的简单视图进行返回

6.还要用查到的comment对象中的user_id字段去查询这评论的作者, 然后记录到comment的简单视图

ok, 解决了

