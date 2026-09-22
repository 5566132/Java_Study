package extend5;

public class Cat extends Animal{
    public Cat(){
        super();
    }
    public Cat(String color, int age){
        super(color, age);
    }
    @Override
    public void eat(String some){
        System.out.println(getage() + " 岁的 " + this.getcolor() + " 的猫吃 " + some);
    }

    public void catchmouse(){
        System.out.println("猫抓老鼠");
    }


}
