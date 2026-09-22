package extend2;

public class Hsk extends Dog{
    public void spe(){
        System.out.println("拆家");
    }
    @Override
    public void eat(){
        System.out.println("吃狗粮, 吃骨头");
    }

}
