package com.class1.Son_map;  
  
import org.springframework.aop.scope.ScopedProxyUtils;  
  
import java.util.List;  
import java.util.Map;  
  
public class Student {  
    private String name;  
    private int age;  
    Map<String, Teacher> M;  
    List\<Teacher> L;  
    
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Map<String, Teacher> getM() {  
        return M;  
    }  
  
    public void setM(Map<String, Teacher> m) {  
        M = m;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public List<Teacher> getL() {  
        System.out.println("调用了对List的get");  
        return L;  
    }  
  
    public void setL(List<Teacher> l) {  
        System.out.println("调用了对List的set");  
        L = l;  
    }  
  
    public void work(){  
        System.out.println("name = " + name + "    age = " + age);  
        System.out.println("展示map");  
        for(Map.Entry<String, Teacher> temp : M.entrySet()){  
            System.out.println("key = " + temp.getKey() + "        name = " + temp.getValue().getName() + "          age = " + temp.getValue().getAge());  
        }  
        System.out.println("展示list");  
        for(int i = 0;i<L.size();i++){  
            System.out.println(L.get(i).getName() + "  " + L.get(i).getAge());  
        }  
        System.out.println();  
    }  
  
  
  
}