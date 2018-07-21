package com.beng.webbe.controller;


import com.beng.webbe.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BankShowController {
    @Autowired
    private AccountRepo accountRepo;

    @RequestMapping(value = "/bankShow", method = RequestMethod.GET)
    public String bankShow(
    ) {
        return "BankInfo";
    }

    





}
