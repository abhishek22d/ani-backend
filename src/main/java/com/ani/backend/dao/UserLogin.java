package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "USER_LOGIN")
@Data
public class UserLogin {

    @Id
    @Column(name="email_address")
    private String emailAddress;

    @Column(name="otp")
    private String otp;

    @Column(name="creation_time")
    private Timestamp creationTime;
}
