package try_equals_substring;

public class Try_substring {
    public static void main(String[] args){
        String s1 = "abcdefg";
        String s2 = new String();
        s2 = "ABCDEFG";
        System.out.println(s1 + "    " + s2);
        if(s1.equalsIgnoreCase(s2)){
            System.out.println("s1 和 s2 忽略大小写的时候相等");
        }
        String s3 = s2.substring(0, s2.length());
        System.out.println(s3);



    }
}
