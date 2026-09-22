package Test;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MF extends JFrame implements KeyListener {
    JButton jbt = new JButton("键盘监听按钮");
    JButton jbt2 = new JButton("鼠标监听");
    public MF(){
        initJFrame();
        this.setVisible(true);
    }

    private void initJFrame(){
        this.setSize(800, 800);
        this.setTitle("键盘监听测试版 1.0.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        //这里要求参数是监听类型的接口
        jbt.addKeyListener(this);
        jbt.setBounds(0,0, 300, 300);
        this.getContentPane().add(jbt);
        jbt2.addMouseListener(
                new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("点击 1");
                        jbt.setSize(300, 300);
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("按下 2");
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        System.out.println("松开 3");
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        System.out.println("划入 4");
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        System.out.println("离开 5");
                    }

                }
        );
        jbt2.setBounds(400, 400, 300, 300);
        this.getContentPane().add(jbt2);



    }


    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
            System.out.println("按下按键");
    }
    @Override
    public void keyReleased(KeyEvent e){
        //System.out.println("松开按键");
        int code = e.getKeyCode();
        System.out.println("按下的按键是: " + code);

    }



}
