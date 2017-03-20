package com.hello.mybatis.service.message;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ligaozhao on 20/03/17.
 */

public class ListUserReq implements Serializable {

    private static final long serialVersionUID = -8062543682038510020L;

    private List<Integer> idList;

    public ListUserReq() {
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
