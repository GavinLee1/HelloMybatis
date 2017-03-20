package com.hello.mybatis.repository.mybatis.interf;

import com.hello.mybatis.exception.DatabaseException;
import com.hello.mybatis.repository.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by ligaozhao on 19/03/17.
 */
public interface UserMabatisRepository {

    int createUser(final User user);

    User getUserById(final int id) throws DatabaseException;

    List<User> listUserByIdList(final Collection<Integer> idList);
}
