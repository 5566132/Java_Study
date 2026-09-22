package Weight_Random;

import java.io.*;
import java.util.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\A_java\\java_study\\IO_Practice\\src\\Weight_Random\\name.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        ArrayList<Stu> arr = new ArrayList<>();
        String str;
        while((str = br.readLine()) != null){
            //System.out.println(str);
            String[] temp = str.split("-");
            arr.add(new Stu(temp[0], temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3])));
        }
        show(arr);
        double all_weight = 0;
        //ListIterator<Stu> it = arr.listIterator();
        int n = arr.size();
        double[] V = new double[n];
        int i;
        for(i=0;i<n;i++){
            all_weight += arr.get(i).weight;
        }
        for(i=0;i<n;i++){
            if(i == 0){
                V[i] = arr.get(i).weight/all_weight;
            }else{
                V[i] = V[i - 1] + arr.get(i).weight/all_weight;
            }
            System.out.print(V[i] + " ");
        }
        System.out.println();
        double se = Math.random();

        int sign = Arrays.binarySearch(V, se);
        if(sign < 0){
            sign = -sign - 1;
        }
        System.out.println(" se = " + se + "    " + arr.get(sign).toString());
        arr.get(sign).weight/=2;
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for(i=0;i<arr.size();i++){
            bw.write(arr.get(i).toString());
            bw.newLine();
        }
        bw.close();
        br.close();
    }
    static void show(ArrayList<Stu> arr){
        Iterator<Stu> it = arr.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
