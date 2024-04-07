package com.org.irctc.controller;

import com.java.generated.jooq.tables.pojos.User;
import com.org.irctc.constants.LoggedInStatusConstants;
import com.org.irctc.dto.UserRequestDto;
import com.org.irctc.helper.ResponseObject;
import com.org.irctc.model.UserModel;
import com.org.irctc.repository.UserRepository;
import com.org.irctc.service.UserDetailsService;
import com.org.irctc.service.UserService;
import com.org.irctc.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RestController
@RequestMapping("/v1/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/log-in")
    public ResponseEntity<UserModel> authenticate(@RequestBody UserRequestDto userRequestDto){
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userRequestDto.getUserName(), userRequestDto.getPassword());
            var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            var user = (UserModel) authentication.getPrincipal();

            String jwtToken = jwtUtil.generateToken(user.getUsername());
            Optional<User> existingUser = userRepository.getUserByUserName(user.getUsername());
            userRepository.updatedLoginStatus(user.getUsername(), LoggedInStatusConstants.LOGGED_IN);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .body(UserModel.builder()
                            .userName(user.getUsername())
                            .id(user.getId())
                            .roleName(user.getRoleName())
                            .status(user.getStatus())
                            .build());

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/log-out")
    public ResponseEntity<?> logout(){
        userDetailsService.logout();
        return ResponseEntity.noContent().build();
    }

}
