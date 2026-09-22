package Thread2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        T1();



    }
    static void T1() throws InterruptedException {
        ArrayList<Integer> arr = new ArrayList<>();
        Random r = new Random();
        int i;
        for(i=0;i<14;i++){
            arr.add(r.nextInt(1, 100));
            //System.out.print(arr.get(i) + " ");
        }
        Collections.sort(arr);
        for(i=0;i<14;i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        myThread.arr = arr;
        myThread t1 = new myThread("线程1");
        myThread t2 = new myThread("线程22");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.addAll(t1.a1);
        arr2.addAll(t2.a1);
        Collections.sort(arr);
        Collections.sort(arr2);


        for(i=0;i<arr2.size();i++){
            System.out.print(arr2.get(i) + " ");
        }





    }
}
