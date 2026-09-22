package Interface1;

public abstract class Sporter extends Person {
    Sporter() {
        super(null, 0);
    }

    Sporter(String name, int age) {
        super(name, age);
    }

    /*
    public static void eat(){
        System.out.println("抽象类可以创建静态方法, 并且可以调用");
    }

     */
    public abstract void eat();

    public void find(){
        System.out.println("抽象类可以创建普通方法, 并且可以调用");
    }

    public abstract void study();

}
