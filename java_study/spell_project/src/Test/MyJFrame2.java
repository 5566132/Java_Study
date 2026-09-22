package Test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MyJFrame2 extends JFrame implements MouseListener {
    JButton jbt = new JButton("鼠标按键");

    public MyJFrame2() {
        initJFrame();
        initMouse();

        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(820, 820);
        this.setTitle("鼠标监听的测试");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
    }

    private void initMouse() {
        //JButton jbt = new JButton("鼠标按键");
        jbt.setBounds(0, 0, 200, 200);
        jbt.addMouseListener(this);
        this.getContentPane().add(jbt);

    }

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
