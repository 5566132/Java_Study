package try4;
import java.util.Scanner;
public class T3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        int i;
        for(i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(i=0;i<n;i++){
            if(i != 0){
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append(']');
        String str = new String(sb.toString());
        System.out.println(str);







    }
}
