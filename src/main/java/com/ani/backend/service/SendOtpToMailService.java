package com.ani.backend.service;

import com.ani.backend.repositories.UserLoginRepository;
import com.ani.backend.response.ServiceResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class SendOtpToMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserLoginRepository userLoginRepository;

    public ServiceResponse<Boolean> sendOtpService(String email) {
        String otp = generateOtp();
        try {
            sendOtpToMail(email, otp);
            boolean isSaved = userLoginRepository.saveOtp(email, otp, Timestamp.valueOf(LocalDateTime.now()));

            if(!isSaved){
                throw new Exception("Otp save failed");
            }

        }catch (MessagingException e){
            return ServiceResponse.<Boolean>builder()
                    .status(HttpStatus.OK.value()).payload(false).message("OTP Sent Failed :"+ e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.<Boolean>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).payload(false).message("Failed to save OTP for email :" + email ).build();
        }
        return ServiceResponse.<Boolean>builder()
                .status(HttpStatus.OK.value()).payload(true).message("OTP Successfully Sent for " + email ).build();
    }

    private String generateOtp() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(9000000);
        return String.valueOf(otp);
    }

    private void sendOtpToMail(String email, String otp) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("OTP For Logging In ANI");
        mimeMessageHelper.setText("<p>Your OTP is :</p><h1>" + otp + "</h1>", true);
        javaMailSender.send(mimeMessage);
    }
}