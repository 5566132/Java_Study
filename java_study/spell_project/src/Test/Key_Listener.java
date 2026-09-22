package Test;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Key_Listener extends JFrame{
    JButton jbt = new JButton();
    public Key_Listener(){
        initJFrame();
        this.setVisible(true);
    }
    private void initJFrame(){
        this.setTitle(" 键盘监听重写  ");
        this.setSize(800, 800);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.addKeyListener(
                new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e){

                    }
                    @Override
                    public void keyPressed(KeyEvent e){
                            System.out.println("按下");
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                            System.out.println("释放");
                    }
                }
        );

    }



}
