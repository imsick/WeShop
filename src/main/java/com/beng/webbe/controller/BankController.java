package com.beng.webbe.controller;


import com.beng.webbe.model.Bank;
import com.beng.webbe.repository.AccountRepo;
import com.beng.webbe.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class BankController {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private BankRepo bankRepo;


    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public Map<String,Object> bankShow(HttpSession session
    ) {
        List<Bank> bankList=bankRepo.findAll();
        Map<String,Object> account= new HashMap<String,Object>();
        for(Bank bank:bankList)
        {
            account.put(bank.getUserId().toString(),bank.getMoney());
        }

        return account;
    }







}
