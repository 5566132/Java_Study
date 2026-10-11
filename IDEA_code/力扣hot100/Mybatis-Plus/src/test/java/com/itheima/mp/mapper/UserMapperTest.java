package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    //测试Mybatis-Plus
    void t1(){
        userMapper.selectById(1);


        List<User> list =userMapper.selectAllUser();
        list.stream().forEach(u -> System.out.println(u));
    }


    @Test
    //测试QueryWrapper
    void t2(){
        QueryWrapper<User> qw = new QueryWrapper<User>()
                .select("id", "t_name", "address", "age")
                .like("t_name", "张")
                .ge("age", 25);

        List<User> list = userMapper.selectList(qw);
        list.stream().forEach(s-> System.out.println(s));



    }


    @Test
    //测试UpdateWrapper
    void t3(){
        User user = new User();
        user.setName("张八");

        UpdateWrapper<User> uw = new UpdateWrapper<User>()
                .eq("id", 2);


        userMapper.update(user, uw);
    }


    @Test
        //测试UpdateWrapper
    void t31(){
        User user = new User();
        user.setName("张八");
        UpdateWrapper<User> uw = new UpdateWrapper<User>()
                .setSql("age = age - 1")
                .like("t_name", "张");

        userMapper.update(uw);
    }


    @Test
        //测试LambdaQueryWrapper
    void t4(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId, User::getName, User::getAge,User::getAddress)
                .like(User::getName, "张")
                .ge(User::getAge, 20);
        userMapper.selectList(wrapper).stream().forEach(s -> System.out.println(s));
    }

    @Test
    //测试set语句可以处理set age = age + 10吗
    //不可以
    void t5(){
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<User>();
    }
    @Test
    //测试Wrapper作为条件传递
    void t6(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .like(User::getName, "王")
                .or()
                .ge(User::getAge, 49);

        List<User> list = userMapper.selectUserByWrapper(wrapper);
        list.stream().forEach(a -> System.out.println(a));


    }




    @Test
    void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println("user = " + user);
    }


    @Test
    void testQueryByIds() {
        List<User> users = userMapper.selectBatchIds(List.of(1L, 2L, 3L, 4L));
        users.forEach(System.out::println);
    }




    @Test
    void testDeleteUser() {
        userMapper.deleteById(5L);
    }

    @Test
    void testQueryWrapper() {
        // 1.构建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id", "username", "info", "balance")
                .like("username", "o")
                .ge("balance", 1000);
        // 2.查询
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }





    @Test
    void testUpdateWrapper() {
        List<Long> ids = List.of(1L, 2L, 4L);
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>()
                .setSql("balance = balance - 200")
                .in("id", ids);
        userMapper.update(null, wrapper);
    }


}