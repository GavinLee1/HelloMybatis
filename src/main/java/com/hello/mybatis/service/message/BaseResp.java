package com.hello.mybatis.service.message;

import java.io.Serializable;

/**
 * Created by ligaozhao on 20/03/17.
 */
public class BaseResp implements Serializable {

    private static final long serialVersionUID = -4339499441900749560L;

    private boolean success;

    private String message;

    public BaseResp(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
