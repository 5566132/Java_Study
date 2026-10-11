package com.atguigu.date;

public class User {
    private int id;
    private String name;
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String toStirng(){
        StringBuilder sb = new StringBuilder();
        sb.append("id = " + id + "  name = " + name + "  money = " + money);
        return sb.toString();
    }

}
