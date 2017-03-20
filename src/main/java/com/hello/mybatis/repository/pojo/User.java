package com.hello.mybatis.repository.pojo;

import java.sql.Timestamp;

/**
 * Created by ligaozhao on 19/03/17.
 */
public class User {

    private Integer id;

    private String name;

    private int gender;

    private Timestamp birthday;

    private String email;

    private String phone;

    public User() {
    }

    public User(String name, int gender, Timestamp birthday, String email, String phone) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
