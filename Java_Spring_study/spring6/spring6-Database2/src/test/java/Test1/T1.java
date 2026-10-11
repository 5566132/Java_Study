package Test1;

import com.atguigu.controller.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;

@SpringJUnitConfig(classes = com.atguigu.config.Config.class)
public class T1 {

    @Autowired
    private Controller con;

    @Test
    public void run1(){
        con.show_alluser();
        System.out.println();
        con.show_allbook();
        System.out.println();

    }

    @Test
    public void run2(){
        con.buybook(1,1,20);

    }

}
