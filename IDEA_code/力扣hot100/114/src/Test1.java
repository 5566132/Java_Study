import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("雄霸");
        list.add("hdwadi");
        list.add("张一");
        list.add("张二");
        list.add("jdwidua");
        list.stream().skip(2).limit(2).forEach(e-> System.out.println(e));

    }

}
