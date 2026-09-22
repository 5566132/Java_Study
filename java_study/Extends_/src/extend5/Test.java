package extend5;

public class Test {
    public static void main(String[] args){
        Person p = new Person("张三", 99);
        Animal a;
        a = new Dog("粉色", 99999);
        p.keepPet(a," 答辩 ");
        Cat c = new Cat(" 屎黄色", 18);
        p.keepPet(c," 猫屎咖啡 ");





    }
}
