package extend3;

public class Manager extends Employee{
    public double bouns;
    Manager(){
        super();
    }
    Manager(String name, int age, double salary, double bouns){
        super(name, age, salary);
        this.bouns = bouns;
    }
}
