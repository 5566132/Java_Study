package try1;

public class Test1 {
    public static void main(String[] args){
        Per a = new Per("1号", 100);
        Per b = new Per("2号", 100);
        int cnt = 0;
        while(true){
            if(cnt %2==0){
                a.Role(b);
                if(b.Getboold() == 0){
                    break;
                }
            }else{
                b.Role(a);
                if(a.Getboold() == 0){
                    break;
                }
            }
            //System.out.println("pause");
            cnt++;
        }

    }
}
