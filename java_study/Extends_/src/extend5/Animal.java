package extend5;

public class Animal {
    private String color;
    private int age;
    Animal(){
        color = "无色";
        age = 0;
    }
    Animal(String color, int age){
        this.color = color;
        this.age = age;
    }
    public void setcolor(String color){
        this.color = color;
    }
    public void setage(int age){
        this.age = age;
    }
    public String getcolor(){
        return this.color;
    }
    public int getage(){
        return this.age;
    }

    public void eat(String some){
        System.out.println("动物吃 " + some);
    }

}
