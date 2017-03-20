package com.hello.mybatis.service.message;

import com.hello.mybatis.repository.pojo.User;

/**
 * Created by ligaozhao on 20/03/17.
 */
public class GetUserResp extends BaseResp {

    private static final long serialVersionUID = -4266879937704792007L;

    private User user;

    public GetUserResp(User user) {
        super(true, "OK");
        this.user = user;
    }

    public GetUserResp(boolean success, String message) {
        super(success, message);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
