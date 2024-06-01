package com.ani.backend.repositories;

import com.ani.backend.dao.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO anidb.user_login (email_address, otp, expiry_time) VALUES (:email_address,:otp, :creationTime )", nativeQuery = true)
    public boolean saveOtp(@Param("email_address") String email_address, @Param("otp") String otp, @Param("otp") Timestamp creationTime);

}
