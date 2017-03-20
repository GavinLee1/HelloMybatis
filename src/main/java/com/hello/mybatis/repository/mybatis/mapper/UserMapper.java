package com.hello.mybatis.repository.mybatis.mapper;

import com.hello.mybatis.repository.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by ligaozhao on 19/03/17.
 */
public interface UserMapper {

    int createUser(final User user);

    User selectUserById(final int id);

    List<User> listUserByIdList(final Collection<Integer> idList);
}
