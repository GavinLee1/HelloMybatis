package com.hello.mybatis.service.message;

import com.hello.mybatis.repository.pojo.User;

import java.util.List;

/**
 * Created by ligaozhao on 20/03/17.
 */
public class ListUserResp extends BaseResp {

    private static final long serialVersionUID = -7251386024962511618L;

    private List<User> userList;

    public ListUserResp(List<User> userList) {
        super(true, "OK");
        this.userList = userList;
    }

    public ListUserResp(boolean success, String message) {
        super(success, message);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
