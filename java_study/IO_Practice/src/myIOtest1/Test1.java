package myIOtest1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String X1 = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String M1 = "https://qiming.hao86.com/view/138662/";
        String a1 = WebCrawler(X1);
        String a2 = WebCrawler(M1);
        ArrayList<String> arr1 = getDate(a1, "([一-龥]{4})(，|。)", 1);
        ArrayList<String> arr2 = getDate(a2, "([0-9]+)(、)([一-龥]{1,3})", 3);

        int i;
        for(i=0;i<arr1.size();i++){
            System.out.println(arr1.get(i));
        }
        for(i=0;i<arr2.size();i++){
            System.out.println(arr2.get(i));
        }
    }

    static ArrayList<String> getDate(String src, String regex, int n){
        ArrayList<String> arr = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(src);
        while((match.find())){
            String group = match.group(n);
            arr.add(group);
            //System.out.println(group);
        }

        return arr;
    }

    //把网路上的信息转成字符串的形式, 方便爬取
    static String WebCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        //创建网络对象
        URL url = new URL(net);
        URLConnection con = url.openConnection();
        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        int len;
        while((len = isr.read()) != -1){
            sb.append((char)len);
        }
        return sb.toString();
    }





}
