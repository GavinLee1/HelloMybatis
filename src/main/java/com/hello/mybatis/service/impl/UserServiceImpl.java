package com.hello.mybatis.service.impl;

import com.hello.mybatis.exception.DatabaseException;
import com.hello.mybatis.repository.mybatis.interf.UserMabatisRepository;
import com.hello.mybatis.repository.pojo.User;
import com.hello.mybatis.service.interf.UserService;
import com.hello.mybatis.service.message.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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

    @Override
    public ListUserResp listUserByIdList(ListUserReq req) {
        if (req == null) {
            return new ListUserResp(false, "Null Request!");
        }

        if (req.getIdList() == null || req.getIdList().isEmpty()) {
            return new ListUserResp(false, "Id list is empty!");
        }

        List<User> userList = null;
        try {
            userList = userMabatisRepository.listUserByIdList(req.getIdList());
        } catch (DatabaseException e) {
            return new ListUserResp(false, e.toString());
        }

        if (userList == null || userList.isEmpty()) {
            return new ListUserResp(true, "No User Found in this id list!");
        }

        return new ListUserResp(userList);
    }


}
