package com.ani.backend.service;

import com.ani.backend.dao.Test;
import com.ani.backend.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    public void saveTest(Test test){
        testRepository.save(test);
    }
}
