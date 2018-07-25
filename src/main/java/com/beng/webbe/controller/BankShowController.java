package com.beng.webbe.controller;


import com.beng.webbe.model.Bank;
import com.beng.webbe.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class BankShowController {

    @Autowired
    BankRepo bankRepo;
    @RequestMapping(value = "/bankShow", method = RequestMethod.GET)
    public String bankShow(
    ) {
        return "BankInfo";
    }
    @RequestMapping(value = "/addBankAccout", method = RequestMethod.GET)
    public String addBankAccount(@RequestParam(value = "user_id") int user_id,@RequestParam(value = "money")int money
    ) {
        Bank b = bankRepo.findBankByUserId(user_id);
        if(b==null)
        {
            b = new Bank();
            b.setMoney(money);
            b.setUserId(user_id);
            bankRepo.save(b);
        }
        else
            return "fail";
        return "BankInfo";
    }
    





}
