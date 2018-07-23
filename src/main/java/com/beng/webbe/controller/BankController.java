package com.beng.webbe.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.beng.webbe.model.Account;
import com.beng.webbe.model.AccountAndAddress;
import com.beng.webbe.model.Address;
import com.beng.webbe.model.Bank;
import com.beng.webbe.repository.AccountRepo;
import com.beng.webbe.repository.AddressRepo;
import com.beng.webbe.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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
