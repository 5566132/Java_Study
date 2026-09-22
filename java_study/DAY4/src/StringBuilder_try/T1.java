package StringBuilder_try;

public class T1 {
    public static void main(String[] args){
        String s1 = "abcd";
        char[] c1 = new char[]{'a', 'b', 'c', 'd'};
        String s2 = new String(c1);
        String s4 = new String(c1);
        if(s2 == s4){
            System.out.println("s1 == s2");
        }

        StringBuilder sb = new StringBuilder(s1);
        sb.append(s2);
        sb.reverse();
        String add = s1 + s2;
        System.out.println(add);

        System.out.println(sb);
        int i;
        s2.replace("a", "A");

        System.out.println(s2);




    }
}
