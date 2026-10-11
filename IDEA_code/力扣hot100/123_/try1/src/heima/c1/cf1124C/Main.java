package heima.c1.cf1124C;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String s = "1000-01-01";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldt1 = LocalDate.parse(s , dtf);
        System.out.println(ldt1);
        LocalDateTime ldt2 = LocalDateTime.now();
        String s2 = dtf.format(ldt2);

        System.out.println(s2);
        System.out.println(dtf.toFormat().toString());






















        Map<Integer, Integer> m = new HashMap<>();
        m.get(1);
        for(Map.Entry<Integer, Integer> temp : m.entrySet()){
            temp.getValue();
        }



        Queue<Integer> qu = new LinkedList<>();

        qu.add(1);
        qu.add(2);
        int a = qu.poll();
        int b = qu.poll();
        Integer c = qu.poll();
        System.out.println(a + "  " + b + "    " + c);






        Deque<Integer> de = new ArrayDeque<>();
        de.addFirst(2);
        de.addLast(33);
        de.peek();


        de.clear();
        de.add(1);
        de.add(2);
        de.push(3);
        int te = de.pop();
        //int te = de.peek();
        System.out.println(de.getFirst());
        System.out.println(de.getFirst());
        System.out.println(de.getLast());
        System.out.println("te = " + te);








        int t = sc.nextInt();
        int n,k;
        int l,r;
        int i;
        while(t-->0){
            n = sc.nextInt();
            k = sc.nextInt();
            l = k;
            r = n - k + 1;
            long[] V = new long[n+2];
            for(i=1;i<=n;i++){
                V[i] = sc.nextInt();
            }
            //找一个长度为n-k+1的区间最大值
            if(l < r){
                long ans = 0;
                for(i=l;i<=r;i++){
                    ans += V[i];
                }
                int temp = l;
                l = r + 1;
                r = temp - 1;
               // System.out.println("ans = " + ans);
                while(l <= n){
                    //System.out.println("l = " + l +"         r = " + r);
                    ans += Math.max(V[l], V[r]);
                    l++;
                    r--;
                    //System.out.println("ans  = " + ans);
                }
                System.out.println(ans);




            }else{
                long ans = 0;
                while(l <= n){
                    ans += Math.max(V[l], V[r]);
                    l++;
                    r--;
                }
                System.out.println(ans);




            }








        }


    }
}
