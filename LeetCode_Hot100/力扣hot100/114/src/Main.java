import java.util.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {


        String a = "dd";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(99);
        list.add(-2837);
        list.stream().forEach(e -> System.out.println(e));
        list.stream().distinct().distinct();

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"abc");
        map.put(2, "bbb");
        map.put(4, "ooo");

        map.entrySet().stream().forEach(e -> System.out.println(e));
        map.keySet().stream().forEach(key -> System.out.println(key));

        Integer[] arr = list.toArray(new Integer[0]);
        Arrays.stream(arr).forEach(e-> System.out.println(e));



        int[] ar = new int[]{3, 4, 9,1};
        Arrays.stream(ar).forEach(abb -> System.out.println(abb));





    }

}