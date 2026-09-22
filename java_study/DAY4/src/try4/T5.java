package try4;
import java.util.Scanner;
public class T5 {
    public static void main(String[] args){
        String a = new String();
        Scanner sc = new Scanner(System.in);

        String b = new String();
        b = sc.next();
        a = sc.next();
        int i;
        boolean ret = false;
        for(i=0;i<a.length();i++){
            if(a.charAt(i) == b.charAt(0)){
                int j;
                boolean yes = true;
                for(j=i;j<i + a.length();j++){
                    if(a.charAt( (j%a.length()) ) != b.charAt(j - i) ){
                        yes = false;
                        break;
                    }
                }
                if(yes == true){
                    ret = true;
                    break;
                }
            }

        }
        if(ret == true){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }





    }
}
