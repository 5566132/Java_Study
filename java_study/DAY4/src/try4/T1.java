package try4;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = "abc";
        String b = new String("abc");
        System.out.println(a + "  " + b + "     " + (a == b));
        //System.out.println(a + "  " + b + "     " + (ab));
        String c = new String("ABC");
        System.out.println(b + "  " + c + "     " + (b == c));

        //System.out.println(b.charAt(1));
        char[] re1 = new char[]{'a', 'b', 'c', 'd', 'e'};
        String d = new String(re1);
        System.out.println(a + "  " + b + "     " + a.equals(b));
        System.out.println(b + "  " + a + "     " + b.equals(a));
        System.out.println(a + "  " + c + "     " + a.equalsIgnoreCase(c));
        String h = new String();
        h = sc.next();






    }
}
