package Try_Lock;

public class Make extends Thread{
    @Override
    public void run(){
        while(true){
            synchronized(Desk.lock){
                if(Desk.food == 0){
                    break;
                }else{
                    if(Desk.foodflag == true){
                        try{
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }else{
                        Desk.foodflag = true;
                        System.out.println("厨师做了一碗面");
                        Desk.lock.notifyAll();
                    }
                }
            }

        }
    }

}
