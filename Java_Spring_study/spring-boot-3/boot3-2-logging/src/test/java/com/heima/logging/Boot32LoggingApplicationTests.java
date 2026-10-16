package com.heima.logging;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Boot32LoggingApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void t1(){
        Map<Integer, Integer> map = new HashMap<>();
        Integer it = map.get(1);
        System.out.println(it);

    }

}
