package com.heima;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameJFrame extends JFrame {
    JButton jb1;
    JButton jb2;
    int now_x, now_y;
    boolean left;
    GameJFrame(){
        initJFrame();
        initJButton();
        Move();
        this.setVisible(true);
    }
    private void initJFrame(){
        //this.setSize(700, 700);
        this.setBounds(400,100, 800, 800);
        this.setAlwaysOnTop(true);
        this.setTitle("动作监听, 移动按钮 V 1.0.0");
        this.setDefaultCloseOperation(3);
        now_x = 0;
        now_y = 0;
        left = true;
        this.setLayout(null);
    }
    private void initJButton(){
        this.getContentPane().removeAll();
        jb1 = new JButton("随便乱动的按钮");
        jb1.setBounds(now_x,now_y, 200, 200);
        jb2 = new JButton(" 按这个按钮能动 ");
        jb2.setBounds(200, 500, 200, 200);
        Move();
        this.add(jb1);
        this.add(jb2);
        this.getContentPane().repaint();
    }

    private void Move(){

        jb2.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
            }
            @Override
            public void keyPressed(KeyEvent e){
                System.out.println(" 按下 ");
                //证明要向左走
                if(left == true){
                    now_x -= 100;
                    //initJButton();
                    if(now_x <= 0){
                        left = !left;
                    }
                }else{
                    now_x += 100;
                    //initJButton();
                    if(now_x >= 700){
                        left = !left;
                    }
                }
                jb1.setBounds(now_x, now_y, 200, 200);

            }
            @Override
            public void keyReleased(KeyEvent e){

            }


        });



    }





}
