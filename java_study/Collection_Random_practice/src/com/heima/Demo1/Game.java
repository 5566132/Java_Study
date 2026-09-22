package com.heima.Demo1;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        int i;
        Random r = new Random();
        int n = r.nextInt(1, 3);
        System.out.println("   n = " + n);
        Pk_Manage.Game(n);



    }
}
