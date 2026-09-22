package com.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameJframe extends JFrame{
    JButton jbt1;
    GameJframe(){
        initJFrame();
        initJButton();
        this.setVisible(true);
    }
    public void initJFrame(){
        this.setSize(700, 700);
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);
        this.setTitle(" 测试版 1.0.0");
    }
    public void initJButton(){
        jbt1 = new JButton("按钮 1 号");
        jbt1.setBounds(200, 200, 400, 200);
        jbt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("111111");
            }
        });
        jbt1.addActionListener(this::method1);


        this.getContentPane().add(jbt1);
    }
    public void method1(ActionEvent e){
        System.out.println("111111111111111111111");
    }


}
