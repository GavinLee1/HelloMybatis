package com.hello.mybatis.service.impl;

import com.hello.mybatis.exception.DatabaseException;
import com.hello.mybatis.repository.mybatis.interf.UserMabatisRepository;
import com.hello.mybatis.repository.pojo.User;
import com.hello.mybatis.service.interf.UserService;
import com.hello.mybatis.service.message.BaseResp;
import com.hello.mybatis.service.message.CreateUserReq;
import com.hello.mybatis.service.message.GetUserResp;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by ligaozhao on 19/03/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserMabatisRepository userMabatisRepository;

    @Override
    public GetUserResp getUserById(int id) {

        User user = null;
        try {
            user = userMabatisRepository.getUserById(id);
        } catch (DatabaseException e) {
            return new GetUserResp(false, e.toString());
        }

        if (user == null) {
            return new GetUserResp(true, "User[id:" + id + "] Not Found!");
        }

        return new GetUserResp(user);
    }

    @Override
    public BaseResp createUser(CreateUserReq req) {
        if (req == null) {
            return new BaseResp(false, "Null Request!");
        }
        User user = new User(req.getName(), req.getGender(), req.getBirthday(), req.getEmail(), req.getPhone());

        try {
            userMabatisRepository.createUser(user);
        } catch (DatabaseException e) {
            return new BaseResp(false, e.toString());
        }


        return new BaseResp(true, "OK");
    }
}
