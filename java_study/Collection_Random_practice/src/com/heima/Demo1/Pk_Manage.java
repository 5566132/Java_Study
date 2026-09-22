package com.heima.Demo1;

import java.util.*;

public class Pk_Manage {
    static Per p1, p2, p3;

    static ArrayList<String>[] begin1(){


        Pk.init();

        Pk.initpai();

        ArrayList<String>[] arr = new ArrayList[4];
        int i;
        for(i=0;i<4;i++){
            arr[i] = new ArrayList<String>();
        }
        for(i=0;i<3;i++){
            arr[0].add(Pk.pai.getFirst());
            Pk.pai.removeFirst();
        }
        for(i=0;i<3;i++){
            int j;
            for(j=0;j<17;j++){
                arr[i + 1].add(Pk.pai.getFirst());
                Pk.pai.removeFirst();
            }
        }
        return arr;
    }

    static TreeSet<String>[] begin2(){
        Pk.init();

        Pk.initpai();

        TreeSet<String>[] arr = new TreeSet[4];

        int i;
        for(i=0;i<4;i++){
            arr[i] = new TreeSet<String>(new Comparator<String>(){
                @Override
                public int compare(String a, String b){
                    return Pk.m.get(b) - Pk.m.get(a);
                }
            });
        }

        for(i=0;i<3;i++){
            arr[0].add(Pk.pai.getFirst());
            Pk.pai.removeFirst();
        }

        for(i=0;i<3;i++){
            int j;
            for(j=0;j<17;j++){
                arr[i + 1].add(Pk.pai.getFirst());
                Pk.pai.removeFirst();
            }
        }
        return arr;
    }
    public static void Game(int a){
        int i;
        Random r = new Random();
        Per p1 = new Per("1号");
        Per p2 = new Per("2号");
        Per p3 = new Per("3号");
        Per[] p = new Per[]{p1, p2, p3};
        int n = r.nextInt(1, 4);
        p[n - 1].name = p[n - 1].name.concat(" 地主");

        System.out.println("  11");
        if(a == 1){
            ArrayList<String>[] arr = begin1();
            arr[n].addAll(arr[0]);
            for(i=0;i<3;i++){
                p[i].pai = arr[i + 1];
            }

            for (i = 1; i <= 3; i++) {
                Collections.sort(arr[i], new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        return Pk.m.get(b) - Pk.m.get(a);
                    }
                });
            }
            String temp;
            for (i = 0; i < 3; i++) {
                System.out.print(p[i].name + " :  ");
                int j;
                for (j = 0; j < p[i].pai.size(); j++) {
                    temp = p[i].pai.get(j);
                    System.out.print(temp + " ");
                }
                System.out.println();
            }

        }else if(a == 2){

            TreeSet<String>[] arr = begin2();
            arr[n].addAll(arr[0]);
            for(i=0;i<3;i++){
                p[i].pai2 = arr[i+1];
            }
            for(i=0;i<3;i++){
                int j;
                System.out.print(p[i].name + " :  ");
                for(String temp : p[i].pai2){
                    System.out.print(temp + " ");
                }


                System.out.println();

            }


        }

    }



}
