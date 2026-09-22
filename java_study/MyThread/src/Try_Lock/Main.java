package Try_Lock;

public class Main {
    public static void main(String[] args){
        T1();

    }
    static void T1(){
        Eat e = new Eat();
        e.setName("吃货");
        Make m = new Make();
        m.setName("厨师");
        e.start();
        m.start();


    }
}
