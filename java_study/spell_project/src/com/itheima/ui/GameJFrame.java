package com.itheima.ui;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //这里面存图片编号
    private int[][] DataArr;
    private int x;
    private int y;
    private int step;


    //这些是给菜单添加的内容
    JMenuItem changePhoto = new JMenuItem("更换图片");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    GameJFrame(){


        initJFrame();
        initJMenuBar();


        RandomData();
        initImage();

        //窗口默认是不可见的, 设置为可见, 但是这个可见的设置有执行的先后顺序,
        //你懂什么意思吗, 就是它本质是一条指令语句, 它只会把它之前的对界面的设置给呈现,
        //所以这个语句要写在最后
        this.setVisible(true);
    }

    //主界面设置
    private void initJFrame(){
        //这里不要new一个新的界面, 因为当前类是JFrame的子类, JFrame类构造时有默认的界面被创建
        //也就可以直接用this访问,
        //JFrame gameJFrame = new JFrame();

        //设置图形化界面的窗口
        this.setSize(205*4 + 200, 205*4 + 200);

        //设置标题
        this.setTitle("拼图游戏 1.0.0");

        //窗口默认是可以被其他界面覆盖的, 这个设置会改变窗口的
        //可覆盖性, 也就是不可被其他界面覆盖
        this.setAlwaysOnTop(true);

        //设置窗口的关闭和进程的联动, 也就是窗口关闭了进程也会同步关闭
        this.setDefaultCloseOperation(3);

        //主界面里面有一个隐藏界面, 这个隐藏界面有默认机制是把添加的图片都放在正中央
        //所以要取消这个机制
        this.setLayout(null);



        //添加键盘监听, 给当前界面(也就是从JFrame继承下来的主界面)
        this.addKeyListener(this);


    }

    //初始化 菜单栏
    private  void initJMenuBar() {
        //从这里开始去构建主界面的细节

        //创建一个菜单栏类, 下面的过程都是优化这个界面然后把这个东西添加到主界面
        JMenuBar jmb = new JMenuBar();
        //创建菜单界面, 这个是添加到菜单栏的东西
        JMenu jm1 = new JMenu("功能");
        JMenu jm2 = new JMenu("关于游戏");
        //添加监听
        changePhoto.addActionListener(this);
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);

        //这些步骤给内容添加到菜单
        jm1.add(changePhoto);
        jm1.add(replayItem);
        jm1.add(reloginItem);
        jm1.add(closeItem);
        //把菜单添加到菜单栏
        jmb.add(jm1);
        jmb.add(jm2);
        //把菜单栏添加到主界面
        this.setJMenuBar(jmb);
    }



    //添加背景
    private void addBackGround(){
        ImageIcon icon = new ImageIcon("D:\\A_java\\java_study\\spell_project\\Photo\\BackGround\\5.png");
        JLabel jl = new JLabel(icon);
        jl.setBounds(20, 20,1000, 1000);
        this.getContentPane().add(jl);
    }


    //再优化, 把二维数组的打乱抽离成一个方法
    private void RandomData(){
        step = 0;
        ArrayList<Integer> sign = new ArrayList<>();
        int i;
        for(i=0;i<16;i++) {
            sign.add(i);
        }
        Random r = new Random();
        for(i=0;i<sign.size();i++){
            int se = r.nextInt(1, sign.size());
            int temp = sign.get(i);
            sign.set(i, sign.get(se));
            sign.set(se, temp);
        }
        //初始化成员二维数组, 然后将打乱的顺序给成员二维数组赋值
        DataArr = new int[4][4];
        for(i=0;i<4;i++){
            int j;
            for(j=0;j<4;j++){
                DataArr[i][j] = sign.get(i*4+j);
                if(DataArr[i][j] == 0){
                    x = i;
                    y = j;
                }
            }
        }
    }


    //初始化图片, 我改了一下, 这个当作随机初始化的方法, 根据成员DataArr去初始化
    private void initImage(){
        this.getContentPane().removeAll();
        if(victory()){
            System.out.println("加载胜利图片");
            WinPhoto();
        }
        int i;
        ImageIcon icon;
        JLabel jl;
        System.out.println("  step = " + step);
        //icon = new ImageIcon("总步数: " + step);
        jl = new JLabel("总步数: " + step);
        jl.setBounds(10,0, 100, 50);
        this.getContentPane().add(jl);


        StringBuilder sb = new StringBuilder("D:\\A_java\\java_study\\spell_project\\Photo\\BeautifulGirl\\1\\");
        String s1 = ".jpeg";
        int x,y;
        for(i=0;i<4;i++){
            int j;
            for(j=0;j<4;j++){
                StringBuilder temp = new StringBuilder(sb);
                temp.append(DataArr[i][j]);
                temp.append(s1);
                icon = new ImageIcon(temp.toString());
                jl = new JLabel(icon);
                jl.setBorder(new BevelBorder(1));
                jl.setBounds(205*i +100, 205*j + 100, 205, 205);
                this.getContentPane().add(jl);
            }
        }
        addBackGround();
        this.getContentPane().repaint();
    }



    //这个是把图片初始化成正确的顺序
    private void initALL(){
        this.getContentPane().removeAll();
        ImageIcon icon = new ImageIcon("Photo/BeautifulGirl/1/all.jpeg");
        JLabel jl = new JLabel(icon);
        jl.setBounds(100,100,820, 820);
        this.getContentPane().add(jl);
        addBackGround();
        this.getContentPane().repaint();
    }

    //将数组初始化成正确顺序
    private void right_arr(){
        int i;
        int num = 1;
        for(i=0;i<4;i++){
            int j;
            for(j=0;j<4;j++){
                DataArr[j][i] = num++;
            }
        }
        DataArr[3][3] = 0;
    }

    //判断是否胜利
    private boolean victory(){
        int i;
        int num = 1;
        boolean ret = true;
        for(i=0;i<4;i++){
            int j;
            for(j=0;j<4;j++){
                if(i == 3 && j == 3){
                    num = 0;
                }
                if(DataArr[j][i] == num){
                    num++;
                }else{
                    ret = false;
                }
            }
        }
        return ret;
    }

    //加载胜利图片
    private void WinPhoto(){
        JLabel jl = new JLabel(new ImageIcon("Photo/WIN/1.png"));
        jl.setBounds(300, 300, 400, 400);
        this.getContentPane().add(jl);
        //this.getContentPane().repaint();
    }










    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        if(victory()){
            return;
        }
        System.out.println("按下开始");
        int se = e.getKeyCode();
        if(se == 'P'){
            initALL();
        }
        System.out.println("按下结束");
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(victory()){
            return;
        }

        int se = e.getKeyCode();

        if(se == 37 || se == (int)('A')){
            //左
            if(x - 1 >= 0){
                DataArr[x][y] = DataArr[x - 1][y];
                DataArr[x - 1][y] = 0;
                x = x - 1;
                step += 1;
            }
        }else if(se == 38 || se == (int)('W')){
            //上
            if(y - 1 >= 0){
                DataArr[x][y] = DataArr[x][y - 1];
                DataArr[x][y - 1] = 0;
                y = y - 1;
                step += 1;
            }
        }else if(se == 39 || se == ('D')){
            //右
            if(x + 1 <4){
                DataArr[x][y] = DataArr[x + 1][y];
                DataArr[x + 1][y] = 0;
                x = x + 1;
                step += 1;
            }
        }else if(se == 40 || se == ('S')){
            //下
            if((y + 1) < 4){
                DataArr[x][y] = DataArr[x][y+1];
                DataArr[x][y+1] = 0;
                y = y + 1;
                step += 1;
            }
        }else if(se == 'M'){
            right_arr();
        }
        initImage();
    }


    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj == changePhoto){
            System.out.println("更换图片");

        }else if(obj == reloginItem){


        }else if(obj == replayItem){
            System.out.println("重新开始");
            RandomData();
            initImage();


        }else if(obj == closeItem){


        }




    }










}
