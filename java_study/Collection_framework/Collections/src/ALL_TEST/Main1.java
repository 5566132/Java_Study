package ALL_TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Main1 {
    public static void main(String[] args){
        Collection<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        b.add(0,"ddd");
        b.add(0, "7777");
        System.out.println(Arrays.toString(b.toArray(new String[0])));

        LinkedList<String> l = new LinkedList<>();


        a.add("aaa");
        a.add("bbb");
        a.add("ccc");
        a.add("ddd");
        Object[] o1 = a.toArray();
        System.out.println(Arrays.toString(o1));
        String[] o2 = a.toArray(new String[0]);
        System.out.println(Arrays.toString(o2));
        Stu s1 = new Stu("aa", 10);
        Stu s2 = new Stu("aa", 10);
        if(s1.equals(s2)){
            System.out.println("YES   " + s1.toString() + "        " + s2.toString());
        }else{
            System.out.println("NO   " + s1.toString() + "        " + s2.toString());
        }





    }
}
