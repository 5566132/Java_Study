package extend5;

public class Person {
    private String name;
    private int age;
    Person(){
        name = "";
        age = 0;
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setage(int age){
        this.age = age;
    }
    public String getname(){
        return this.name;
    }
    public int getage(){
        return this.age;
    }
    public void keepPet(Animal a, String some){

        if(a instanceof Dog d){
            System.out.println("这要输出狗");
        }else if(a instanceof Cat c){
            System.out.println("这里要输出猫");
        }

        System.out.println("年龄为 " + this.getage() + " 的 " + this.getname() + " 养了一个 " + a.getcolor() + "   " + a.getage()  +  " 的动物");
        a.eat(some);
    }






}



























