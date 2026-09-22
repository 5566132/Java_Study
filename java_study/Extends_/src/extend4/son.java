package extend4;

public class son extends father{
    public int salary;
    son(){
        this(null,0,0);
        //super();
        this.salary = salary;
    }
    son(String name, int age, int salary){
        super(name, age);
        this.salary = salary;
    }
}
