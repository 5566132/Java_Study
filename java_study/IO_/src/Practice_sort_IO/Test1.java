package Practice_sort_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String str = new String("1.2.333.6.999999.10");
        String[] st = str.split("\\.");
        int i;
        Integer[] IN = new Integer[st.length];
        for(i=0;i<st.length;i++){
            IN[i] = Integer.parseInt(st[i]);
            System.out.println(IN[i]);
        }





        File f = new File("D:\\A_java\\java_study\\IO_\\src\\Practice_sort_IO\\abc.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        int len;
        ArrayList<String> arr = new ArrayList<>();
        String temp;
        while(( temp = br.readLine()) != null){
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                int a1 = Integer.parseInt(a.split("\\.", 2)[0]);
                int b1 = Integer.parseInt(b.split("\\.", 2)[0]);
                return a1 - b1;
            }
        });
        String sss = new String("");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for(i=0;i<arr.size();i++){
            bw.write(arr.get(i));
            bw.newLine();
        }
        bw.close();
        br.close();







    }
}
