package com.org.irctc.repository;

import com.org.irctc.tables.pojos.User;

import java.util.Optional;

public interface UserRepository {
    public void addUser(User user);

    public Optional<User> getUserById(String userId);

    public User getUserByUserId(String userId);

    public Optional<User> getUserByUserName(String userName);

    public void updateUser(User user);

    public void deleteUser(String userId);

    public void updatedLoginStatus(String userName, Byte isLoggedIn);
}
