package com.ani.backend.controllers;

import com.ani.backend.response.ServiceResponse;
import com.ani.backend.service.SendOtpToMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OtpController {
    @Autowired
    private SendOtpToMailService sendOtpToMailService;

    @GetMapping("/{email}")
    public ServiceResponse<Boolean> sendOtpToMail (@PathVariable("email") String email) {
        return sendOtpToMailService.sendOtpService(email);
    }
}
