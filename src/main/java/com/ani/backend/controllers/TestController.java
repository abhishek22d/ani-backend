package com.ani.backend.controllers;

import com.ani.backend.dao.Test;
import com.ani.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean addUser(@RequestBody Test test) {
        try {
            testService.saveTest(test);
        } catch(Exception ex){
            return false;
        }
        return true;
    }
}
