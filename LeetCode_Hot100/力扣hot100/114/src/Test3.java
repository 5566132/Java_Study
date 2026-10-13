import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15", "张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20","张三丰-男-100", "张翠山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");
        String[] str = list.stream()
                .filter(s -> "男".equals(s.split("-")[1])?true:false)
                .toArray(n -> new String[n]);
        for(String out: str){
            System.out.println(out);
        }

        List<String> newlist = list.stream()
                .filter(s -> "男".equals(s.split("-")[1])?true:false)
                .collect(Collectors.toList());
        for(String out : newlist){
            System.out.println(out);
        }
        System.out.println("----------------");
        Map<String, Integer> map = list.stream()

                .collect(Collectors.toMap(s1->s1.split("-")[0], s2->Integer.parseInt(s2.split("-")[2])) );

        for(Map.Entry<String, Integer> out : map.entrySet()){
            System.out.println(out.getKey() + "   " + out.getValue());
        }

        Map<String, Integer> mapp = list.stream()
                .collect(Collectors.toMap(s1->s1.split("-")[0], s2->Integer.parseInt(s2.split("-")[2])) );




    }



}
