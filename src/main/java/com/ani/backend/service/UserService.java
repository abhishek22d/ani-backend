package com.ani.backend.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ani.backend.dto.UserDto;
import com.ani.backend.model.User;
import com.ani.backend.repo.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User validateOtp(String email, String otp) {
    @SuppressWarnings("null")
    User user = userRepository.findById(email).orElse(null);
    if (user != null && user.getOtp().equals(otp)) {
      if (isOtpValid(user.getOtpExpiry())) {
        return user;
      } else {
        return null;
      }
    }
    return null;
  }
  public UserDto validateOtpWithDetails(String email, String otp) {
  User user = validateOtp(email, otp); 
  if (user != null) {
    UserDto userDto = new UserDto();
    userDto.setUserId(user.getUserId());
    userDto.setEmail(user.getEmail());
    userDto.setPhoneNumber(user.getPhoneNumber());
    userDto.setSessionId(user.getSessionId());
    userDto.setUserRole(user.getUserRole());
 
    return userDto;
  }
  return null;
}
  private boolean isOtpValid(LocalDateTime otpExpiry) {
    if (otpExpiry != null) {
      return otpExpiry.plusSeconds(120).isAfter(LocalDateTime.now());
    } else {
      return false; 
    }
  }
}