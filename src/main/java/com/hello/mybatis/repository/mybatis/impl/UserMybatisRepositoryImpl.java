package com.hello.mybatis.repository.mybatis.impl;

import com.hello.mybatis.exception.DatabaseException;
import com.hello.mybatis.repository.mybatis.interf.UserMabatisRepository;
import com.hello.mybatis.repository.mybatis.mapper.UserMapper;
import com.hello.mybatis.repository.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * Created by ligaozhao on 19/03/17.
 */
@Repository
public class UserMybatisRepositoryImpl implements UserMabatisRepository {

    @Inject
    private SqlSession sqlSession;

    private final static Logger log = LoggerFactory.getLogger(UserMybatisRepositoryImpl.class);

    private UserMapper getMapper() {
        return this.sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public int createUser(User user) throws DatabaseException {

        int result = getMapper().createUser(user);

        if (result <= 0) {
            log.error("[createUser] - Fail to create user[{}]", user.toString());
            throw new DatabaseException("[createUser] - Fail to create user: " + user.toString());
        }

        return 0;
    }

    @Override
    public User getUserById(int id) throws DatabaseException {

        User user = null;

        try {
            user = getMapper().selectUserById(id);
        } catch (DataAccessException e) {
            log.error("[getUserById] - Fail to access DB with id[{}]", id, e);
            throw new DatabaseException("[getUserById] - Fail to access DB with id[" + id + "]", e);
        }

        return user;
    }

    @Override
    public List<User> listUserByIdList(Collection<Integer> idList) throws DatabaseException {
        List<User> userList = null;

        try {
            userList = getMapper().listUserByIdList(idList);
        } catch (DataAccessException e) {
            log.error("[listUserByIdList] - Fail to access DB with list[{}]", idList.toString(), e);
            throw new DatabaseException("[listUserByIdList] - Fail to access DB", e);
        }

        return userList;
    }
}
