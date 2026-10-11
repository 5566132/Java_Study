import Emp1.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


@SpringJUnitConfig(locations = "classpath:bean-jdbc.xml")
public class Test1{

    @Autowired
    @Qualifier("jt")
    public JdbcTemplate jt;

    @Test
    public void run(){
        String sql = "insert into app(name, age) values(?, ?)";
        String sql2 = "update app set name = \"新改的名字\" where id = 2";
        //int row = jt.update(sql, "你叫什么名字", 100);
        int row = jt.update(sql, "鸡你太美", 9000);

        System.out.println(row);



        Deque<Integer> de = new ArrayDeque<>();
        de.add(1);
        de.pop();


    }
    @Test
    public void select(){
        String sql = "select * from app";
        List<App> list = jt.query(sql, new BeanPropertyRowMapper<>(App.class));
        String sql2 = "select count(*) from app";
        Integer count = jt.queryForObject(sql2, Integer.class);
        System.out.println("有: " + count + " 条数据");
        String sql3 = "select sum(age) from app";
        Integer sum = jt.queryForObject(sql3, Integer.class);
        System.out.println("求和是: " + sum);
        for(App temp : list){
            System.out.println(temp.toString());
        }
    }


}
