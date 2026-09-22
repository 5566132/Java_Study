import java.util.Arrays;
import java.util.Random;

public class Try1 {
    static void main() {
        Random r = new Random();
        int n = r.nextInt(1, 20);
        int[] V = new int[n];
        int i;
        for(i=0;i<n;i++){
            V[i] = r.nextInt(0, 20);
        }
        Arrays.sort(V);

        for(i=0;i<n;i++){
            System.out.print(V[i] + " ");
        }
        System.out.println();
        int left = 0;
        int right = n - 1;
        int mid = (left + right)/2;
        int goal = r.nextInt(V[0], V[n - 1] + 1);
        System.out.println("goal = " + goal);
        int cnt = 0;
        while(left < right){
            cnt++;
            System.out.println("left = " + left + "       right = " + right);
            if(V[mid] >= goal){
                right = mid;
            }else if(V[mid] < goal){
                left = mid + 1;
            }
            mid = (left + right) / 2;
            if(cnt > 30){
                break;
            }
        }
        System.out.println("sign = " + left + "       value = " + V[left]);
    }
}
