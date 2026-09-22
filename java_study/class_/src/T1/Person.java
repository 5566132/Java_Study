package T1;

public class Person {
    private String m_name;
    private int m_age;
    private String m_gender;
    public int bb;
    public void setname(String name){
        m_name = name;
    }
    public static void Setname(Person per, String name){
       // per = new Person();
       // per.m_name = name;
      //  Person.Setname(per, name);
        per.m_name = name;

    }
    public void SetName(Person per, String name){
        //per = new Person();
       // per.SetName(per,name);
        per.m_name = name;
    }

    public String getname(){
        return m_name;
    }


}
