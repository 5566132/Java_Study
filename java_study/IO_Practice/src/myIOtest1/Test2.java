package myIOtest1;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.*;
import java.util.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //把学生信息写入all_name

        String getXING = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String getMINGboy = "https://qiming.hao86.com/view/79802/";
        String getMINGgirl = "https://qiming.hao86.com/view/79557//";

        String src1 = HttpUtil.get(getXING);
        String src2 = HttpUtil.get(getMINGboy);
        String src3 = HttpUtil.get(getMINGgirl);

        ArrayList<String> arr1 = (ArrayList<String>)ReUtil.findAll("([一-龥]{4})(，|。)", src1, 1);
        ArrayList<String> arr2 = (ArrayList<String>)ReUtil.findAll("\\([0-9]{2}\\)([一-龥]{2})",src2, 1);
        ArrayList<String> arr3 = (ArrayList<String>)ReUtil.findAll("(([一-龥]{2}、){6})([一-龥]{2})", src3, 0);

        ArrayList<String> fname = new ArrayList<>();
        ArrayList<String> boy = new ArrayList<>();
        ArrayList<String> girl = new ArrayList<>();

        //把读取到的数据分割
        //姓氏
        for(String n1 : arr1){
            for(int i = 0;i<n1.length();i++){
                fname.add(n1.charAt(i) + "");
            }
        }
        //男名
        for(String b1 : arr2){
            if(!boy.contains(b1)){
                boy.add(b1);
            }
            if(boy.size() > 100){
                break;
            }
        }
        //女名
        for(String g1 : arr3){
            String[] temp = g1.split("、");
            for(int i = 0;i<temp.length;i++){
                girl.add(temp[i]);
            }
            if(girl.size() > 100){
                break;
            }
        }
        //System.out.println(fname);
        //System.out.println(boy);
        //System.out.println(girl);
        //创建最终数组
        ArrayList<String> BOY = Combine(fname, boy, true);
        ArrayList<String> GIRL = Combine(fname, girl, false);
        //System.out.println(BOY);
        //System.out.println(GIRL);




        /*
        //写入文件
        File f = new File("D:\\A_java\\java_study\\IO_Practice\\ALL_NAME\\all_name");
        //用转换流写入
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f));
        //使用字符缓冲流, 顺便还能用newLine
        BufferedWriter osw = new BufferedWriter(new FileWriter(f));
        Random r = new Random();
        int se;
        int sign;
        while(!BOY.isEmpty() || !GIRL.isEmpty()){
            se = r.nextInt(0, 2);
            if(BOY.isEmpty()){
                se = 0;
            }else if(GIRL.isEmpty()){
                se = 1;
            }
            if(se == 0){
                sign = r.nextInt(0, GIRL.size());
                osw.write(GIRL.get(sign));
                osw.newLine();
                GIRL.remove(sign);
            }else{
                sign = r.nextInt(0, BOY.size());
                osw.write(BOY.get(sign));
                osw.newLine();
                BOY.remove(sign);
            }
        }
        osw.close();
        */
        ArrayList<String> ALL_name = new ArrayList<>();
        ALL_name.addAll(BOY);
        ALL_name.addAll(GIRL);
        System.out.println(BOY.get(1));

        Collections.shuffle(ALL_name);
        FileUtil.writeLines(ALL_name, "D:\\A_java\\java_study\\IO_Practice\\ALL_NAME\\all_name", "UTF-8");



    }
    public static ArrayList<String> Combine(ArrayList<String> surname, ArrayList<String> name, boolean isboy){
        HashSet<String> all_name = new HashSet<>();
        int i;
        Random r = new Random();
        int se1, se2;
        int size1 = surname.size(), size2 = name.size();
        String APPEND;
        if(isboy){
            APPEND = "男";
        }else{
            APPEND = "女";
        }
        while(all_name.size() < 100){
            se1 = r.nextInt(0, size1);
            se2 = r.nextInt(0, size2);
            all_name.add(surname.get(se1) + name.get(se2) + "-" + APPEND + "-");
        }
        ArrayList<String> ret = new ArrayList<>();
        for(String s : all_name){
            se1 = r.nextInt(1,30);
            ret.add(s + "" + se1 + "-1");
        }


        return ret;
    }




}
