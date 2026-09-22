package Lock_;

public class MyThread extends Thread{
    static int SUM = 0;
    MyThread(String name){
        super(name);
    }
    @Override
    public synchronized void run(){
        int i;
        System.out.println("---");
        for(i=0;i<10000;i++) {
            SUM++;
        }
    }

}
