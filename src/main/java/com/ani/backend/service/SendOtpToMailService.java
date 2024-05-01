package com.ani.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class SendOtpToMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send-otp")
    public String sendOTP(@RequestBody String email) {
        // Generate OTP
        String otp = generateOTP();

        // Send email with OTP
        try {
            sendEmail(email, otp);
            return "OTP sent successfully!";
        } catch (MessagingException e) {
            return "Failed to send OTP. Please try again later.";
        }
    }

    private String generateOTP() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    private void sendEmail(String email, String otp) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject("Your OTP for verification");
        helper.setText("Your OTP is: " + otp);
        javaMailSender.send(message);
    }
}


