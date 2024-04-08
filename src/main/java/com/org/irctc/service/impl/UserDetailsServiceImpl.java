package com.org.irctc.service.impl;

import com.org.irctc.tables.pojos.User;
import com.org.irctc.constants.LoggedInStatusConstants;
import com.org.irctc.model.UserModel;
import com.org.irctc.repository.UserRepository;
import com.org.irctc.service.UserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel loadUserByUsername(String userName) {
        Optional<User> existingUser = userRepository.getUserByUserName(userName);
        if(existingUser.isPresent()){
            UserModel userModel = UserModel.builder()
                    .userName(existingUser.get().getUserName())
                    .password(existingUser.get().getPassword())
                    .id(existingUser.get().getUserId())
                    .roleName(existingUser.get().getRole())
                    .status(existingUser.get().getStatus())
                    .isLoggedIn(existingUser.get().getIsloggedin())
                    .build();
            return userModel;
        }
        throw new UsernameNotFoundException("User not found with userName:" +userName);
    }

    @Override
    public void logout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String userName = jwtAuthenticationToken.getToken().getSubject();
        userRepository.updatedLoginStatus(userName, LoggedInStatusConstants.LOGGED_OUT);
    }

}
