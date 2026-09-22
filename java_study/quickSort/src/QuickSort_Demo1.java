import java.util.Scanner;
public class QuickSort_Demo1 {
    public static void main(String[] args){
        boolean f = true;
        System.out.println(f);
        f = !f;
        System.out.println(f);
        f = !f;
        System.out.println(f);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i;
        for(i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0, n-1);
        for(i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }






    }
    static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int st = arr[left];
        int l = left;
        int r = right;
        System.out.println("l = " + l + "      r = " + r);
        //true代表l下标为空, false代表r下标为空
        boolean flag = true;
        while(l != r){
           if(flag){
               //l下标是空,所以要判断r下标能不能动
               if(arr[r] <= st){
                   arr[l] = arr[r];
                   l++;
                   flag = !flag;
               }else{
                   r--;
               }


           }else{
               if(arr[l] > st){
                   arr[r] = arr[l];
                   r--;
                   flag = !flag;
               }else{
                   l++;
               }
           }
        }
        arr[l] = st;
        show(arr);
        quickSort(arr,left, l-1);
        quickSort(arr,l+1,right);
    }
    static void show(int[] arr){
        int i;
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
