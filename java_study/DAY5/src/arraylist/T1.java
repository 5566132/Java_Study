package arraylist;
import java.util.Scanner;
import java.util.ArrayList;
public class T1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> V = new ArrayList<String>();
        V.add("aaa");
        V.add("bbb");
        V.add("aaa");
        V.add("bbb");
        V.add("ccc");
        V.add("ddd");
        //V.remove("aaa");
        //V.remove(1);
        V.set(0, "ndwuihwudhd");
        String temp = V.get(2);
        System.out.println(temp);



        System.out.println(V);





    }
}
