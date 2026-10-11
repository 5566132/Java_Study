package Interface2;

public interface Work {
    public void work1();
    default void work2(){}
    //protected void work3();
    private void work4(){

    }
    static void work55(){
        System.out.println("调用work55静态方法");
    }



}
