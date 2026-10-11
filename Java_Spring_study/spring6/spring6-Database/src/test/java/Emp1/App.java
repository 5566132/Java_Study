package Emp1;

public class App {
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("");
        sb.append("id = " + getId() + "\t  name = " + getName() + "  age = " + getAge());
        return sb.toString();
    }


}
