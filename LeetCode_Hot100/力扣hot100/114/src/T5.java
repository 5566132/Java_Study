import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String name = "18782";
        Integer dd = 2222;

        Collections.addAll(list, "张三, 23", "里斯, 24", "王五, 25");
        Map<String , Integer> map = list.stream()
                .filter(str -> Integer.parseInt(str.split(", ")[1]) >= 24? true:false)
                .collect(Collectors.toMap(str -> str.split(", ")[0], str -> Integer.parseInt(str.split(", ")[1]) ));

        System.out.println(map);

    }
}
