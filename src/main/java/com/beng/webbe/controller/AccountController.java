package com.beng.webbe.controller;


import com.beng.webbe.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;
    class AccountInfo {
        Integer userId;
        String userName;
        String tel;
        List<String> addressList;
    }



}
