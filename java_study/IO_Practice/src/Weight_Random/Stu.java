package Weight_Random;

public class Stu {
    public String name;
    public String gender;
    public int age;
    public double weight;
    Stu(){
        this(null, null, 0, 0);
    }
    Stu(String name, String gender, int age, double weight){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }
    public String toString(){
        return name + "-" + gender + "-" + age + "-" + weight;
    }

}
