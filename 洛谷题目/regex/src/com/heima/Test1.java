package com.heima;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String hotline = "400-?[1-9]\\d{2}-?[1-9]\\d{3}";
        String idcard = "1\\d{5}(1[89]|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}(?i)[\\dx]";
        String regex1 = "[\\d]{3,99}";
        String s;
        while(true){
            s = sc.next();
            System.out.println(s.matches(regex1));
        }



    }
}

/*

130105180000151234
130105180013151234
130105180099151234

130105180005321234
130105180012401234

130105180102301234
130105190102291234
130105188804311234
130105199906311234
130105190002291234


13010518000101123
13010518000101123Y
130105‑18000101‑1234







 */
