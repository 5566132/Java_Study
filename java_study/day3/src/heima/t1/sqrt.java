package heima.t1;
import java.util.Scanner;

public class sqrt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i;
        int n;
        n = sc.nextInt();
        sqrt temp = new sqrt();
        for(i=1;i<=n;i++){
            if(temp.is(i)){
                System.out.println(i + "是质数");
            }
        }


    }
    boolean is(int x){
        int i;
        boolean ret = true;
        for(i=2;i*i<=x;i++){
            if(x%i==0){
                ret = false;
                break;
            }
        }
        return ret;
    }



}
