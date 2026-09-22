package String_;
import java.util.Scanner;
import java.util.ArrayList;
public class T1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = "abc";
        String s2 = "abc";
        char[] c1 = new char[]{'a', 'b', 'c'};
        String s3 = new String(c1);
        //s3 = sc.next();
        if(s1 == s3){
            System.out.println("YES");
        }

        if(s1.equals(s3)){
            System.out.println("equals   YES");
        }
        String s4 = "ddAbcddd";
        s3 = s4.substring(2,5);
        System.out.println(s3);
        if(s1.equalsIgnoreCase(s3)){
            System.out.println("stb      equals    YES");
        }
        StringBuilder sb = new StringBuilder(s4);
        String re = sb.reverse().toString();
        System.out.println(re);
        StringBuilder rep = sb.replace(0, sb.length(), "bb");
        System.out.println(rep);
        String bb = re.replace("d", "eo");
        System.out.println(bb);

ArrayList<Integer> V = new ArrayList<>();









    }
}
