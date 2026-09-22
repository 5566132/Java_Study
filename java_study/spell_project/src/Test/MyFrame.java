package Test;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame{
    public MyFrame() {
        initJFrame();
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(205 * 4, 205 * 4);
        this.setTitle("测试事件监听 1.0.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setJButton();


    }

    private void setJButton() {
        JButton jbt1 = new JButton("测试按钮 1");
        jbt1.setBounds(0, 0, 205, 205);
        jbt1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random r = new Random();
                        jbt1.setSize(r.nextInt(400), r.nextInt(400));
                        System.out.println("按了按钮");
                    }
                }
        );
        this.getContentPane().add(jbt1);

        JButton jbt2 = new JButton(new ImageIcon("D:\\A_java\\java_study\\spell_project\\Photo\\BeautifulGirl\\1\\all.jpeg"));
        jbt2.setBounds(205, 205, 205, 205);
        jbt2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random r =  new Random();
                        jbt2.setSize(r.nextInt(800), r.nextInt(800));
                        jbt2.setLocation(r.nextInt(500), r.nextInt(500));

                        //System.out.println("点击图片的效果 ");
                    }
                }
        );
        this.getContentPane().add(jbt2);
    }
    //


    //练习监听鼠标动作
    private void tryClick(){

        JButton jbt = new JButton("测试按钮: 鼠标监听");





    }






}
