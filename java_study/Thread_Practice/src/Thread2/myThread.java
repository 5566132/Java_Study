package Thread2;

import java.util.ArrayList;
import java.util.Collections;

public class myThread extends Thread{
    static ArrayList<Integer> arr;
    ArrayList<Integer> a1 = new ArrayList<>();
    myThread(){
        super();
    }
    myThread(ArrayList<Integer> arr){
        super();
        this.arr = arr;
    }
    myThread(String name){
        super(name);
    }
    @Override
    public void run(){
        //ArrayList<Integer> a1 = new ArrayList<>();
        while(true){
            synchronized(myThread.class){
                if(arr.isEmpty()){
                    System.out.println(Thread.currentThread().getName() + " 的结果如下");
                    for(Integer ou : a1){
                        System.out.print(ou + " ");
                    }
                    System.out.println();
                    break;
                }else {
                    Collections.shuffle(arr);
                    a1.add(arr.remove(0));
                }
            }
        }
    }



}
