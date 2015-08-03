package com.syl.demo.FinalDB.bean;

import net.tsz.afinal.annotation.sqlite.Table;

/*
 * PROJECT_NAME :Demo
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun 
 * CREATE AT : 7/27/2015 4:03 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE : java bean
 */
@Table(name = "user")
public class User {
    private int id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
