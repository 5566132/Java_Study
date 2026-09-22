package Lock_;

public class MyThread_Lock extends Thread{
    static int SUM = 0;
    MyThread_Lock(String name){
        super(name);
    }
    @Override
    public void run(){
        int i;
        synchronized(MyThread_Lock.class){
            for(i=0;i<10000;i++){
                SUM++;
            }
        }
    }

}
