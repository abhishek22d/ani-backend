package com.ani.backend.controller;
import com.ani.backend.dto.OtpRequest;
import com.ani.backend.dto.UserDto;
import com.ani.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/validateOtp")
    public ResponseEntity<?> validateOtp(@RequestBody OtpRequest otpRequest) {
      UserDto userDto = userService.validateOtpWithDetails(otpRequest.getEmail(), otpRequest.getOtp());
      if (userDto != null) {
        return ResponseEntity.ok(userDto);
      } else {
        return ResponseEntity.badRequest().body("Invalid OTP or OTP Expired");
      }
    }
}

