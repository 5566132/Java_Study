package Interface1;

public class PingPangCoach extends Coach implements English{
    @Override
    public void teach(){
        System.out.println("教乒乓球");
    }

    @Override
    public void sayEnglish(){
        System.out.println("说英语");
    }
}
