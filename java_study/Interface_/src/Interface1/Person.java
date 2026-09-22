package Interface1;

public abstract class Person {
    private String name;
    private int age;
    Person(){
        this(null, 0);
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
        return name;
    }
    public int getage(){
        return age;
    }

}
