package com.itheima;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JFrameGame extends JFrame implements ActionListener {
    JButton jbt1 = new JButton("帅");
    JButton jbt2 = new JButton("还行");
    JButton jbt3 = new JButton("不帅");
    JButton jbt4 = new JButton("错了");
    boolean ret = false;

    JFrameGame(){
        initJFrame();
        initJButton();

        this.setVisible(true);
    }
    private void initJFrame(){
        this.setSize(700, 700);
        this.setTitle("整蛊界面");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        ret = false;
    }

    private void initJButton(){
        jbt1.setBounds(300, 100, 100, 60);
        jbt2.setBounds(300, 200, 100, 60);
        jbt3.setBounds(300, 300, 100, 60);
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);
        jbt3.addActionListener(this);

        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);
        this.getContentPane().add(jbt3);
    }
    public void initjbt4(){
        jbt4.setBounds(200, 0, 300, 60);
        jbt4.addActionListener(this);
        this.getContentPane().add(jbt4);
        this.getContentPane().repaint();
    }
    private void shutDown(int n){
        if(n == 0){
            try{
                Runtime.getRuntime().exec("shutdown -a");
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
            return;
        }

        try{
            Runtime.getRuntime().exec("shutdown -s -t " + n);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj == jbt1){
            System.out.println("你太自信了, ");
            shutDown(3600);
        }else if(obj == jbt2){
            System.out.println("7200s的");
            shutDown(7200);

        }else if(obj == jbt3){
            shutDown(14400);
            System.out.println("14400s的");
        }else if(obj == jbt4){
            System.out.println("不错不错, 知道错了");
            shutDown(0);
        }

        if(ret == false){
            ret = true;
            initjbt4();
        }

    }




}
