package com.hello.mybatis.service.interf;

import com.hello.mybatis.service.message.BaseResp;
import com.hello.mybatis.service.message.CreateUserReq;
import com.hello.mybatis.service.message.GetUserResp;

/**
 * Created by ligaozhao on 19/03/17.
 */
public interface UserService {

    GetUserResp getUserById(int id);

    BaseResp createUser(CreateUserReq req);
}
