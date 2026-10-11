package com.atguigu.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringMvc01HelloworldApplicationTests {
    private static final CountDownLatch latch = new CountDownLatch(1);
    @Test
    void contextLoads() throws InterruptedException {
        System.out.println("Tomcat 8888启动成功，浏览器访问");
        latch.await(); // 永久阻塞，直到你在IDEA手动终止程序

    }

}
