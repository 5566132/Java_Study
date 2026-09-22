package com.heima.Collection;
import java.util.*;
public class Test2 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int i;

        List_table track = new List_table();
        List_table head = new List_table();
        head.next = track;
        for(i=1;i<=n;i++){
            List_table temp = new List_table();
            temp.id = i;
            temp.next = null;
            if(i == 1){
                head = temp;
                track = temp;
            }else{
                track.next = temp;
                track = temp;
            }
        }
        track = head;
        while(track != null){
            System.out.print(track.id + " ");
            track = track.next;
        }
        System.out.println();
        track = head;
        head = null;
        while(track != null){
            List_table temp = track.next;
            track.next = head;
            head = track;
            track = temp;
        }
        track = head;
        while(track != null){
            System.out.print(track.id + " ");
            track = track.next;
        }













    }
}
