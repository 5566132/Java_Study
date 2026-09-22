package pro;

import java.util.Scanner;
import java.util.Random;
public class Ran {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(x);







        String str = "";
        int i;
        Random r = new Random();
        for(i=0;i<4;i++){
            int se = r.nextInt(0,2);
            char add;
            if(se % 2 == 0){
                add = (char)r.nextInt((int)'a', (int)('z' + 1));
            }else{
                add = (char)r.nextInt((int)'A', (int)('Z' + 1));
            }


            //System.out.println(add);
            str += add;
        }
        int add = r.nextInt(0,10);
        str += add;
        System.out.println(str);



    }
}
