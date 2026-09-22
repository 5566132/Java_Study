package try1;

public class Stu {
    private String name;
    private int age;
    static String teachername;
    public static void get(){
        System.out.println("输出 static 的函数");
        //Stu.show_static();
        //Stu.age = 99;
       // age = 99;
        Stu.teachername = "dd";
    }
    public void show_static(){
        //可以调用静态的方法
        get();
        //也可以使用静态的成员变量
        Stu.teachername = "rrr";

    }


    public void show(){
        System.out.println(name + "    " + age + "     " + teachername);
    }


}
