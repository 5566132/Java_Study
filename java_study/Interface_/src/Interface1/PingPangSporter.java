package Interface1;

public class PingPangSporter extends Sporter implements English {

    PingPangSporter() {
        super(null, 0);
    }
    PingPangSporter(String name, int age) {
        super(name, age);
    }
    @Override
    public void eat(){

    }

    @Override
    public void study() {
        System.out.println("学习乒乓球");
    }

    @Override
    public void sayEnglish() {
        System.out.println("说英语");
    }


}
