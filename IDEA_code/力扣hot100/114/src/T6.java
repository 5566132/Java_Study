import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T6 {
    public static void main(String[] args) {
        // 第一个集合：6名男演员
        ArrayList<String> male = new ArrayList<>();
        male.add("张无忌,25");
        male.add("李连杰,60");
        male.add("甄子丹,58");
        male.add("吴京,48");
        male.add("成龙,68");
        male.add("刘德华,62");

        // 第二个集合：6名女演员
        ArrayList<String> female = new ArrayList<>();
        female.add("杨幂,36");
        female.add("杨颖,34");
        female.add("杨紫,30");
        female.add("赵丽颖,36");
        female.add("刘亦菲,35");
        female.add("迪丽热巴,31");

        // ========== 下面你自己写流操作 ==========
        // 1，男演员只要名字为3个字的前两人
        Stream<String> s1 = male.stream()
                .filter(str -> str.split(",")[0].length() == 3? true:false)
                .limit(2);



        // 2，女演员只要姓杨的，并且不要第一个
        System.out.println(female.get(0).charAt(0));
        Stream<String> s2 = female.stream()
                .filter(str -> '杨' == (str.charAt(0))?true:false)
                .skip(1);


        // 3，把过滤后的男演员姓名和女演员姓名合并到一起
        Stream<String> s3 = Stream.concat(s1, s2);

        // 4，将上一步的演员信息封装成Actor对象
        Stream<Actor> s4 = s3.map(mem -> new Actor(mem.split(",")[0], Integer.parseInt(mem.split(",")[1])));


        // 5，将所有的演员对象都保存到List集合中
        List<Actor> list = s4.collect(Collectors.toList());

        for(Actor out : list){
            System.out.println(out);
        }











    }
}
