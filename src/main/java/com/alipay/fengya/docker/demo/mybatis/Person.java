package com.alipay.fengya.docker.demo.mybatis;

public class Person {
    private String name;
    private int age;
    private int pid_o;
    private int id;
    private String time;
    private Boolean sex;
    public Person() {
    }

    public int getPid() {
        return pid_o;
    }

    public void setPid(int pid) {
        this.pid_o = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.pid_o = id;

    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pid_o=" + pid_o +
                ", time=" + time +
                ", id=" + id +
                ", sex=" + sex +
                '}'+"\n";
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
