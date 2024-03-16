package com.ani.backend.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long UserId;
    private String email;
    private String phoneNumber;
    private String sessionId;
    private String userRole;
}