package com.ani.backend.controllers;

import com.ani.backend.service.SendOtpToMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private SendOtpToMailService sendOtpToMailService;
    @PostMapping("sendOtp/{email}")
    public String sendOtpToMail (@PathVariable("email") String email) {
        sendOtpToMailService.sendOtpService(email);
        return "otp sent";
    }

    }

