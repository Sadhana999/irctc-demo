package com.org.irctc.service;

import com.org.irctc.model.UserModel;

public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {
    public UserModel loadUserByUsername(String userName);
    public void logout();
}
