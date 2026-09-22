package extend3;

public class Employee {
    public String name;
    public int age;
    public double salary;
    Employee(){

    }
    Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public void work(){
        System.out.println("工作");
    }



}
