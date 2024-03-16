package com.ani.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class User {
  @Id
  @Column
  private String email;
  @Column
  private Long UserId;
  @Column
  private String phoneNumber;
  @Column
  private String otp;
  @Column
  private LocalDateTime otpExpiry;
  @Column
  private String sessionId;
  @Column
  private String userRole;
}
