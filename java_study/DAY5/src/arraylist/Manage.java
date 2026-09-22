package arraylist;
import java.util.ArrayList;
public class Manage {
    private ArrayList<Ph> V;
    private int len;
    public Manage(){
        V = new ArrayList<>();
        len = 0;
    }
    public void add(Ph ad){
        //System.out.println("开始");
        V.add(ad);
        //System.out.println("结束");
        len++;
    }
    public Ph get(int index){
        return V.get(index);
    }
    public ArrayList<Ph> max_price(){
        ArrayList<Ph> ret;
        int i;
        int MAX = 0;

        for(i=0;i<len;i++){
            int temp_price = V.get(i).getprice();
            if(MAX < temp_price){
                MAX = temp_price;
            }
        }
        ret = new ArrayList<>();
        for(i=0;i<len;i++){
            int pr = V.get(i).getprice();
            if(pr == MAX){
                ret.add(V.get(i));
            }
        }


        return ret;
    }




}
