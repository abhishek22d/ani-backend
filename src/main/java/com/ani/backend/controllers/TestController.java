package com.ani.backend.controllers;

import com.ani.backend.dao.Test;
import com.ani.backend.response.ServiceResponse;
import com.ani.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping()
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }

    @PostMapping()
    public ServiceResponse<Boolean> addTest(@RequestBody Test test) {
        try {
            testService.saveTest(test);
        } catch(Exception ex){
            return ServiceResponse.<Boolean>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .error(HttpStatus.INTERNAL_SERVER_ERROR.name()).build();
        }
        return ServiceResponse.<Boolean>builder()
                .status(HttpStatus.OK.value())
                .payload(true)
                .message("Success").build();
    }
}
