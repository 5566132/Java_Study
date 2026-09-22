package try1;
import java.util.Random;
public class Per {
    private String name;
    private int boold;
    public Per(){
        name = null;
        boold = 0;
    }
    public Per(String name, int boold){
        this.name = name;
        this.boold = boold;
    }
    public String Getname(){
        return this.name;
    }
    public int Getboold(){
        return this.boold;
    }
    public void Kill(int hurt){
        this.boold -= hurt;
    }

    public void Role(Per a){
        Random r = new Random();
        int hurt = r.nextInt(0,21);
        if(hurt > a.Getboold()){
            hurt = a.Getboold();
        }
        a.Kill(hurt);
        System.out.println(this.name + " 对 " + a.Getname() + " 造成了 " + hurt + " 点伤害");
        if(a.Getboold() == 0){
            System.out.println(a.Getname() + " 死掉了");
        }

    }





}
