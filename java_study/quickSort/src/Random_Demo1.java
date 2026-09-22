import java.util.Random;
public class Random_Demo1 {
    public static void main(String[] args){
        Random r = new Random();
        int n = r.nextInt(1,20);
        System.out.println(n);
        int i;
        for(i=0;i<n;i++){
            int a = r.nextInt(1,100);
            System.out.print(a + " ");
        }


    }
}
