import java.util.Scanner;
public class T1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n;
        n = sc.nextLong();
        long i;
        while(n > 0){
            long t;
            t = n%10;
            n/=10;
            System.out.println(t);
        }

    }
}
