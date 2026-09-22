package extend5;

public class Dog extends Animal{
    public Dog(){
        super();
    }
    public Dog(String color, int age){
        super(color, age);
    }
    @Override
    public void eat(String some){
        System.out.println(getage() + " 岁的 " + this.getcolor() + " 的狗吃 " + some);
    }
    public void lookhome(){
        System.out.println("狗看家");
    }





}
