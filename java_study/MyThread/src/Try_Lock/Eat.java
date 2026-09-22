package Try_Lock;

public class Eat extends Thread{
    @Override
    public void run(){
        while(true){
            synchronized(Desk.lock){
                if(Desk.food == 0){
                    break;
                }else{
                    if(Desk.foodflag == false){

                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }else{
                        Desk.food--;
                        Desk.foodflag = false;
                        System.out.println("吃了一碗现在还剩: " + Desk.food);
                        //唤醒厨师
                        Desk.lock.notifyAll();
                    }
                }
            }
        }

    }


}
