package com.org.irctc.service;

import com.org.irctc.dto.UserRequestDto;

public interface UserService {
    public String registerUser(UserRequestDto userRequestDto);
    public String updateUserDetails(String userId,UserRequestDto userRequestDto);
}
