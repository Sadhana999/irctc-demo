package com.org.irctc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String userName;
    private String password;
    private String emailId;
    private String phoneNumber;
    private String roleName;
}
