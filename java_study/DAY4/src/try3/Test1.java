package try3;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {













        Manager all = new Manager();
        int se = 1;
        Scanner sc = new Scanner(System.in);
        int id;
        String name;
        while (se != 0) {
            all.show();
            se = sc.nextInt();
            if (se == 1) {
                Stu add = new Stu();
                System.out.print("id: ");
                id = sc.nextInt();
                System.out.print("name: ");
                name = sc.next();
                add.setid(id);
                add.setname(name);
                all.add(add);
            } else if (se == 0) {
                break;
            } else if (se == 3) {
                all.showStu();
            } else if (se == 2) {
                System.out.println("输入你要删除的学生的id: ");
                id = sc.nextInt();
                all.del(id);

            }
        }


    }
}
