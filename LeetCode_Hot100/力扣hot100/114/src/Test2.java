import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"一号-12", "二号-222", "三号-324", "四号-54",  "五号-53");
        String str = list.get(1);
        System.out.println(str.split("-",2)[1]);
        list.stream().map(new Function<String, Object>(){
            @Override
            public Integer apply(String s){
                String s1[] = s.split("-");
                String ss = s1[1];
                int age = Integer.parseInt(ss);
                return age;
            }
        }).forEach(age -> System.out.println(age));

        System.out.println("-----------");

        list.stream().map(s->Integer.parseInt(s.split("-")[1])).forEach(s-> System.out.println(s));
        System.out.println("==================");
        List<Integer> l = new ArrayList<>();
        list.stream().map(per -> Integer.parseInt(per.split("-")[1])).forEach(age -> l.add(age));
        l.add(55555555);
        l.stream().forEach(age-> System.out.println(age));



    }
}
