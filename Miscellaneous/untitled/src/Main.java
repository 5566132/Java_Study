import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static void main() {
        int t;
        t = sc.nextInt();
        int i;
        while(t-- > 0){
            int len = sc.nextInt();
            String str = sc.next();
            int[] head = new int[len];
            int[] last = new int[len];
            for(i=0;i<len;i++){
                char temp = str.charAt(i);
                if(i == 0){
                    if(temp == 'v'){
                        head[i] = 1;
                    }else if(temp == 'w'){
                        head[i] = 2;
                    }else{
                        head[i] = 0;
                    }
                }else{
                    if(temp == 'v'){
                        head[i] = 1 + head[i - 1];
                    }else if(temp == 'w'){
                        head[i] = 2 + head[i - 1];
                    }else{
                        head[i] = head[i - 1];
                    }
                }
            }
            for(i=len - 1;i >= 0;i--){
                char temp = str.charAt(i);
                if(i == len - 1){
                    if(temp == 'v'){
                        last[i] = 1;
                    }else if(temp == 'w'){
                        last[i] = 2;
                    }else{
                        last[i] = 0;
                    }
                }else{
                    if(temp == 'v'){
                        last[i] = 1 + last[i + 1];
                    }else if(temp == 'w'){
                        last[i] = 2 + last[i + 1];
                    }else{
                        last[i] = last[i + 1];
                    }
                }
            }
            for(i=0;i<len;i++){


            }





        }
        //String temp = sc.next();




    }
}
