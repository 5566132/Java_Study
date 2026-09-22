package heima.t1;
import java.util.Scanner;
public class T1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int i;
        int n = str.length();
        boolean ret = true;
        for(i=0;i<n;i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                ret = false;
            }
        }
        System.out.println(ret);



    }

}
