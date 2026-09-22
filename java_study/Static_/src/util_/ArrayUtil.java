package util_;

public class ArrayUtil {
    private ArrayUtil(){};

    public static String show(int[] a){
        StringBuilder sb = new StringBuilder();

        int i;
        //System.out.print("[");
        sb.append("[");
        for(i=0;i<a.length;i++){
            if(i != 0){
                sb.append(", ");
            }

            sb.append(a[i]);
            //System.out.print(a[i] + "  ");
        }
        //System.out.println("]");
        sb.append("]");
        return sb.toString();
    }
    private static void abb(){}

    public static double avg(double[] a){
        ArrayUtil.abb();
        ArrayUtil temp = new ArrayUtil();
        temp.abb();


        double sum = 0;
        int i;
        for(i=0;i<a.length;i++){
            sum+=a[i];
        }
        return sum/a.length;
    }

    public static void main(String[] args){
        ArrayUtil temp = new ArrayUtil();
        temp.abb();
    }






}
