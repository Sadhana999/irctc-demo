package com.org.irctc.controller;

import com.org.irctc.dto.UserRequestDto;
import com.org.irctc.helper.ResponseObject;
import com.org.irctc.helper.ResponseUtil;
import com.org.irctc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseObject> registerUser(@RequestBody UserRequestDto requestDto){
        ResponseObject responseObject = ResponseUtil.buildResponse(userService.registerUser(requestDto));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseObject> updateUserDetails(@PathVariable String userId,
                                                            @RequestBody UserRequestDto requestDto){
        ResponseObject responseObject = ResponseUtil.buildResponse(userService.updateUserDetails(userId, requestDto));
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

}
