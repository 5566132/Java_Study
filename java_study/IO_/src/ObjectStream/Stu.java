package ObjectStream;

import java.io.Serializable;

public class Stu implements Serializable {
    public String name;
    public int age;
    Stu(){
        this(null,0);
    }
    Stu(String name, int age){
        this.name = name;
        this.age = age;
    }




}
