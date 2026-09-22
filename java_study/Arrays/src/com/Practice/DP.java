package com.Practice;
import java.util.Scanner;
public class DP {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] arr = new int[3][n+1];
        int[] dp = new int[n+1];
        int i;
        dp[0] = 1;
        dp[1] = 1;
        for(i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i - 2];
        }
        for(i=1;i<=n;i++){
            System.out.println("i = " + i + "    dp = " + dp[i]);
        }




    }
}
/*

1 2 1
2 1 1
1 1 2
2 2
1 1 1 1
















 */
