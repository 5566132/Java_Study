import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main() {
        //Random r = new Random();
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int[] V = new int[n];
        int i;
        for(i=0;i<n;i++){
            V[i] = r.nextInt();
        }
        Arrays.sort(V);
        int target = r.nextInt();
        int se = r.nextInt();
        int[] nums = new int[n];
        System.out.println(" target = " + target);
        for(i=0;i<n;i++){
            nums[i] = V[(se + i) % n];
            System.out.print(nums[i] + " ");
        }
        System.out.println();



        int sign = search(nums, target);
        System.out.println("sign = " + sign);
    }
/*
6
1 2 3 4 5 6
3
0



     */




    public static int search(int[] nums, int target) {

        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = (left + right) / 2;
        int cnt = 0;
        //System.out.println("left = " + left + "          right = " + right);

        while(left < right){
            System.out.println("left = " + left + "          right = " + right);
            cnt++;
            //处于有序区间了
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]){
                if(nums[mid] >= target){
                    right = mid;
                }else{
                    left = mid + 1;
                }
                //left到mid 是有序的
            }else if(nums[mid] >= nums[left]){
                //System.out.println("-------");
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }else{
                    left = mid + 1;
                }


                //mid 到 right 有序
            }else{
                System.out.println("---3333");
                //证明target 恰好在后面这个区间mid right
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }else{
                    right = mid - 1;
                }

                //left = mid;
            }
            mid = (left + right) / 2;
            if(cnt > 30){
                break;
            }
        }
        if(nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }
}
/*
2
1 3
3
1


 */