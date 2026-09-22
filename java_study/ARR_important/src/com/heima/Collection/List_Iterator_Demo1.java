package com.heima.Collection;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class List_Iterator_Demo1 {
    public static void main(){
        BigInteger bi1 = BigInteger.valueOf(1);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("bbb");
        System.out.println(list);
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            String temp = it.next();
            if("bbb".equals(temp)){
                it.remove();
            }
            if("ccc".equals(temp)){
                it.add("666666");
            }
        }
        System.out.println(list);



        int i;
        for(i=0;i<list.size();i++){
            String temp = list.get(i);
            list.set(i, list.get((i+1)%list.size()));
            list.set((i+1)%list.size(), temp);
        }
        for(String s : list){
            System.out.print(s + " ");
        }








    }
}
