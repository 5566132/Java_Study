package com.heima.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args){
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("bbb");
        coll.add("eee");
        Iterator<String> it = coll.iterator();
        while(it.hasNext()){
            //
            String temp = it.next();
            if(temp.equals("bbb")){
                it.remove();
            }
        }
        for(String s: coll){
            System.out.println(s);
        }
        show(coll);

    }
    public static void show(Collection<String> coll){
        Iterator<String> it = coll.iterator();
        System.out.println();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
    }
}
