package ALL_TEST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main2 {
    static void main() {
        HashMap<Integer, Integer> M = new HashMap<>();
        M.put(1,1);

        HashSet<String> h1 = new HashSet<>();
        h1.add("111");
        h1.add("222");
        h1.add("999");
        h1.add("333");
        h1.add("111");
        System.out.println(Arrays.toString(h1.toArray(new String[0])));



        HashSet<Stu> h2 = new HashSet<>();
        h2.add(new Stu("aaa", 10));
        h2.add(new Stu("bb", 1));
        h2.add(new Stu("aaa", 10));
        System.out.println(Arrays.toString(h2.toArray(new Stu[0])));




    }
}
