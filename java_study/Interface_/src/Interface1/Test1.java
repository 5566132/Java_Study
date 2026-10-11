package Interface1;

public class Test1 {

    public static void main(String[] args){
        PingPangSporter pps = new PingPangSporter("小八", 999);
        PingPangSporter pps2 = new PingPangSporter();
        System.out.println(pps.getname() + "     " + pps.getage() + "   " );
        pps.study();
        pps.sayEnglish();
        //Sporter.eat();
        pps.eat();
        pps.find();








    }




}
