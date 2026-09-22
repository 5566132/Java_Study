import java.util.Scanner;
public class Str {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        boolean ret = true;
        String st = "abc";
        System.out.println(st + ret);
        System.out.println('a' + 'b');
        double a = 1.1, b = 2.2;
        System.out.println(a + b);
        double c = 3.3;
        System.out.println("请输入c, 进而判别跟a + b 的关系");
        c = sc.nextDouble();

        int temp = 10000;
        temp += a;

        System.out.println("temp = " + temp);


        if(c == a + b & temp == 9999999999L){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }
        if((a + b - c) <= 1e-7){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }


        st = sc.next();
        int i;
        String yy = "个十百千万";
        for(i=st.length()-1;i>=0;i--){
            System.out.println(yy.charAt(st.length() - i - 1) + "位是: " + st.charAt(i));
        }



    }

}
