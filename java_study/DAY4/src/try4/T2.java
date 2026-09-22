package try4;
import java.util.Scanner;
public class T2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = new String();
        str = sc.next();
        String st = "元十百千万十百";
        int i, top;
        top = 0;
        String out = "";

        for(i=str.length() - 1;i>=0;i--){
            System.out.println("i = " + i);
            out += st.charAt(top++);
            out += str.charAt(i);
        }
        for(i=out.length() - 1;i>=0;i--){
            //System.out.println("i = " + i);
            System.out.print(out.charAt(i));
        }
        System.out.println();




    }
    public void reverse(String a){
        int i;
        for(i=0;i<a.length()/2;i++){
            char temp = a.charAt(i);

        }
    }


}
