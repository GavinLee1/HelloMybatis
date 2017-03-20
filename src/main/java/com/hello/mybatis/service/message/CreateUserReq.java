package com.hello.mybatis.service.message;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ligaozhao on 20/03/17.
 */

public class CreateUserReq implements Serializable {

    private static final long serialVersionUID = 8891232214844141676L;

    private String name;

    private int gender;

    private Timestamp birthday;

    private String email;

    private String phone;

    public CreateUserReq() {
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
