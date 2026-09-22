package com.heima.inter1;

public interface Interface_show {
    final  int age = 9;
    public void show();
    default void t1(){
        t4();
        System.out.println("ddd");
    }

    static void t2(){

        int a = 99;
    }
    static  void t3(){

    }
    private void t4(){
        System.out.println("害得我厚度为");
    }


}
