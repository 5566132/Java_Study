package Interface1;

public abstract class Coach extends Person {
    Coach(){
        this(null, 0);
    }
    Coach(String name, int age) {
        super(name, age);
    }
    public abstract void teach();
}
