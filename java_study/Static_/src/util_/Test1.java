package util_;

public class Test1 {
    public static void main(String[] args){
        int[] a = new int[]{1,2,8,1,4,5};
        double[] b = new double[]{1.2, 2.1, 3.4, 4.3};
        String s = ArrayUtil.show(a);
        System.out.println(s);

        double d = ArrayUtil.avg(b);
        System.out.println(d);




    }
}
