package arraylist;
import java.util.Scanner;
import java.util.ArrayList;
public class T3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,n;
        n = 3;
        Manage m = new Manage();
        int price;
        String name;
        for(i=0;i<n;i++){
            Ph add = new Ph();
            name = sc.next();
            price = sc.nextInt();
            add.setname(name);
            add.setprice(price);
            m.add(add);
        }

        ArrayList<Ph> MAX;
        MAX = m.max_price();

        System.out.println("MAX.size() = " + MAX.size());
        for(i=0;i<MAX.size();i++){
            System.out.println("name = " + MAX.get(i).getname() + "          price = " + MAX.get(i).getprice());


        }






    }
}
