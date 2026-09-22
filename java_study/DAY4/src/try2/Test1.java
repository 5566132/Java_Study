package try2;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args){







        Scanner sc = new Scanner(System.in);
        Good[] a = new Good[3];
        int i;
        int id;
        String name;
        for(i=0;i<a.length;i++){
            Good add = new Good();
            System.out.println("请输入第 " + (i+1) + " 个商品的id");
            id = sc.nextInt();
            System.out.println("name:");
            name = sc.next();
            add.Set(id, name);
            a[i] = add;
        }
        for(i=0;i<a.length;i++){
            System.out.println("第 " + (i + 1) + " 个商品的信息:");
            System.out.println("id = " + a[i].Getid());
            System.out.println("name = " + a[i].Getname());


        }

    }

}
