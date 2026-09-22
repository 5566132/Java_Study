package try4;
import java.util.Scanner;
public class T4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = new String();
        s1 = sc.next();
        String[] st = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder out = new StringBuilder();
        int i;
        for(i=0;i<s1.length();i++){
            if(i != 0){
                out.append(" - ");
            }
            out.append(st[s1.charAt(i) - '0']);

        }
        String OUT = new String(out.toString());
        System.out.println(OUT);



    }
}
