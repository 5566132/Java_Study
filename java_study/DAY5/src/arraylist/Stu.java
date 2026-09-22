package arraylist;

public class Stu {
    private String name;
    private int age;
    //public String name;
    //public int age;
    public Stu(){
        this.name = "";
        this.age = 0;
    }
    public Stu(String name, int age){
        this.name = name;
        this.age = age;
    }



    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }

}
