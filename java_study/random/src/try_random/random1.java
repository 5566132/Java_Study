package try_random;
import java.util.Scanner;
import java.util.Random;
public class random1 {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(1,3);

        int se = 0;
        Scanner sc = new Scanner(System.in);

        while((se = sc.nextInt()) != n){
            if(se > n){
                System.out.println("有点大");
            }else{
                System.out.println("有点小");
            }
        }
        System.out.println("猜对了");


    }
}
