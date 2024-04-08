package com.org.irctc.repository.impl;

import com.org.irctc.Tables;
import com.org.irctc.tables.daos.UserDao;
import com.org.irctc.tables.pojos.User;
import com.org.irctc.constants.StatusConstants;
import com.org.irctc.repository.UserRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final DSLContext dslContext;
    private final UserDao userDao;
    @Autowired
    public UserRepositoryImpl(DSLContext dslContext, UserDao userDao) {
        this.dslContext = dslContext;
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user){
        userDao.insert(user);
    }

    @Override
    public  Optional<User> getUserById(String userId){
        return userDao.fetchOptionalByUserId(userId);
    }

    public User getUserByUserId(String userId){
        return userDao.fetchOneByUserId(userId);
    }

    @Override
    public Optional<User> getUserByUserName(String userName){
        return userDao.fetchOptionalByUserName(userName);
    }

    @Override
    public void updateUser(User user){
        userDao.update(user);
    }

    @Override
    public void deleteUser(String userId){
        dslContext.update(Tables.USER).set(Tables.USER.STATUS, StatusConstants.DELETED)
                        .where(Tables.USER.USER_ID.eq(userId)).execute();
    }

    @Override
    public void updatedLoginStatus(String userName, Byte isLoggedIn){
        dslContext.update(Tables.USER).set(Tables.USER.ISLOGGEDIN, isLoggedIn)
                .where(Tables.USER.USER_NAME.eq(userName)).execute();
    }
}
