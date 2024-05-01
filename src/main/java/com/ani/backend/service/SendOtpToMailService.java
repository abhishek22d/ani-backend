package com.ani.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
@Service
public class SendOtpToMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtpService(String email) {
        String otp = generateOtp();

        try {
            sendOtpToMail(email, otp);
        }catch (MessagingException e){
            throw new RuntimeException("Unable to send otp.");
        }

    }

    private String generateOtp() {

        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(9000000);
        return String.valueOf(otp);
    }
    private void sendOtpToMail(String email,String otp) throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("your otp is :");
        mimeMessageHelper.setText(otp);
        javaMailSender.send(mimeMessage);
    }
}