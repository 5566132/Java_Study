package com.itheima;

import static java.lang.Math.*;

public class Test2 {
    public static void main(String[] args){
        Per[] A = new Per[3];
        int i;
        for(i=0;i<A.length;i++){
            A[i] = new Per();

            A[i].a = i;
        }
        for(i=0;i<A.length;i++){
            System.out.println(A[i].a + " ");
        }


        int n = 200000;
        double out1, out2;
        double now = System.currentTimeMillis();
        prime1(n);
        double now1 = System.currentTimeMillis();
        out1 = now1 - now;
        prime2(n);
        now = System.currentTimeMillis();
        out2 = now - now1;
        System.out.println(out1 + "   " + out2);



    }
    public static int prime1(int n){
        int i;
        int cnt = 0;
        for(i=2;i<=n;i++){
            int j;
            boolean ret = true;
            for(j=2;j<n;j++){
                if(i%j == 0){
                    ret = false;
                    break;
                }
            }
            if(ret){
                cnt++;
            }
        }
        return cnt;
    }
    public static int prime2(int n){
        int i;
        int cnt = 0;
        for(i=2;i<=n;i++){
            int j;
            boolean ret = true;
            for(j=2;j<= sqrt(n);j++){
                if(i%j == 0){
                    ret = false;
                    break;
                }
            }
            if(ret){
                cnt++;
            }
        }
        return cnt;
    }
}
