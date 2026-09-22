package try3;

public class  Manager {
    Stu[] arr;
    int len;
    public Manager(){
        arr = null;
        len = 0;
    }
    public Manager(int len){
        this.len = len;
        arr = new Stu[len];
    }
    public int getlen(){
        return len;
    }
    private boolean check(int id){
        int i;
        boolean ret = true;
        for(i=0;i<len;i++){
            if(arr[i].getid() == id){
                ret = false;
                break;
            }
        }
        return ret;
    }
    //展示选择
    public void show(){
        System.out.println("0.结束");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.展示所有学生信息");

    }

    //添加学生
    public void add(Stu ad){
        if(check(ad.getid()) == false){
            System.out.println("这个id重复了, 无法添加");
            return;
        }
        Stu[] replace = new Stu[len + 1];
        int i;
        for(i=0;i<len;i++){
            //Stu temp = new Stu;
            replace[i] = arr[i];
        }
        replace[i] = ad;
        arr = replace;
        len++;
        System.out.println("添加成功");
    }
    //删除学生
    public void del(int id){
        int i;
        boolean have = false;
        for(i=0;i<len;i++){
            if(arr[i].getid() == id){
                have = true;
                break;
            }
        }
        if(have == false){
            System.out.println("不存在id为 " + id + "的学生");
            return;
        }
        Stu[] replace = new Stu[len - 1];
        int t1 = 0;
        for(i=0;i<len;i++){
            if(arr[i].getid() != id){
                replace[t1++] = arr[i];
            }
        }
        len--;
        arr = replace;
        System.out.println("删除成功");
    }
    public void showStu(){
        System.out.println("一共有 " + (len) + " 个学生");

        int i;
        for(i=0;i<len;i++){
            System.out.println("第 " + (i+1) + " 个学生的id = " + arr[i].getid() + "   name = " + arr[i].getname());
        }
    }



}
