package Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Remove_ extends JFrame implements KeyListener{
    JButton jbt = new JButton(" 鸡你太美 ");

    public Remove_() {

        initJFrame();
        this.addKeyListener(this);
        jbt.addKeyListener(this);

        this.setVisible(true);
    }

    private void initJFrame() {
        this.setTitle(" 尝试能不能remove按钮  ");
        this.setSize(800, 800);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        jbt.setBounds(0, 0, 400, 400);
        this.getContentPane().add(jbt);
        System.out.println("-------9999   ");
        //this.getContentPane().validate();

        this.getContentPane().repaint();
    }
    private void initJButton(){
        jbt.setBounds(0, 0, 400, 400);
        this.getContentPane().add(jbt);
        jbt.addKeyListener(this);

        //this.getContentPane().validate();
        this.getContentPane().repaint();

    }

    private void Remove_jbt(){
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下");
        Remove_jbt();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("释放");
        initJButton();
        //initJFrame();

    }


}
