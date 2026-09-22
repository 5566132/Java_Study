package try4;
import java.util.Scanner;
import java.util.Random;
public class T6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder s1 = new StringBuilder(sc.next());
        Random r = new Random();
        int i;
        for(i=0;i<s1.length();i++){
            char temp = s1.charAt(i);
            int se = r.nextInt(0, s1.length());
            s1.setCharAt(i, s1.charAt(se));
            s1.setCharAt(se, temp);
        }
        System.out.println(s1);





    }
}
