package arraylist;
import java.util.ArrayList;
public class T2 {
    public static void main(String[] args){
       ArrayList<Stu> V = new ArrayList<>();
       int i;
       for(i=0;i<3;i++){
           Stu add = new Stu("aaa", i+19);
           Stu abb = new Stu();

           V.add(add);
       }
       System.out.println(V);



    }
}
