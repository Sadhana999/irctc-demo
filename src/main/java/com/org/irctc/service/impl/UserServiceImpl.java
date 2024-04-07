package com.org.irctc.service.impl;

import com.java.generated.jooq.tables.pojos.User;
import com.org.irctc.constants.StatusConstants;
import com.org.irctc.dto.UserRequestDto;
import com.org.irctc.exception.InvalidEntityException;
import com.org.irctc.repository.UserRepository;
import com.org.irctc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String registerUser(UserRequestDto userRequestDto){

        Optional<User> existingUser = userRepository.getUserByUserName(userRequestDto.getUserName());
        if(existingUser.isPresent()){
            throw new InvalidEntityException("Entered Username already exists, please use another Username.");
        }

        User newUser = new User();
        String userId= UUID.randomUUID().toString();
        newUser.setUserId(userId);
        newUser.setUserName(userRequestDto.getUserName());
        newUser.setPassword(userRequestDto.getPassword());
        newUser.setEmail(userRequestDto.getEmailId());
        newUser.setPhoneNumber(userRequestDto.getPhoneNumber());
        newUser.setCreatedBy("USER");
        newUser.setCreatedDate(LocalDateTime.now());
        newUser.setStatus(StatusConstants.ACTIVE);

        userRepository.addUser(newUser);
        return userId;
    }

    @Override
    public String updateUserDetails(String userId, UserRequestDto userRequestDto){
        Optional<User> existingUser = userRepository.getUserById(userId);
        if(existingUser.isEmpty()){
            throw new InvalidEntityException("User not found wit userId:"+userId);
        } else{
            User user = userRepository.getUserByUserId(userId);
            user.setEmail(user.getEmail());
            user.setPhoneNumber(user.getPhoneNumber());
            userRepository.updateUser(user);
        }
        return userId;
    }


}
