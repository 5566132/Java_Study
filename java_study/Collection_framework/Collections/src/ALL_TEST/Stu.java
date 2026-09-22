package ALL_TEST;

import java.util.Objects;

public class Stu {
    public String name;
    public int age;
    Stu(){
        this(null, 0);
    }
    Stu(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object e){
        if(this == e){
            return true;
        }
        if(e == null || getClass() != e.getClass()){
            return false;
        }

        Stu temp = (Stu)e;
        if(name.equals(temp.name) && age == temp.age){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ("  name=" + name + " age=" + age + "  ");
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }


}
