package extend2;

public class Test1 {
    public static void main(String[] args){
        Chi c  = new Chi();
        c.launch();


    }
}

class Person{
    public void eat(){
        System.out.println("吃食物");

    }
    public void drink(){
        System.out.println("喝水");
    }
}

class Chi extends Person {
    @Override
    public void eat(){
        System.out.println("吃中国人的食物");
    }
    @Override
    public void drink(){
        System.out.println("和中国人的水");
    }
    public void launch(){
        this.eat();
        this.drink();
        super.eat();
        super.drink();

    }

}