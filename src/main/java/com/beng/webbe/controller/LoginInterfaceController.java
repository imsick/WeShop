/*
 * PrivateWordbookController.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.beng.webbe.model.Account;

import com.beng.webbe.model.NewAccount;
import com.beng.webbe.repository.AccountRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuandun
 *
 */
@RestController
public class LoginInterfaceController {
    @Autowired
    private AccountRepo mAccountRepo;
    //注册
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> Register(@RequestBody NewAccount na) {
        String user_name = na.getUser_name();
        String user_password  = na.getUser_password();
        Map<String,String> m = new HashMap<String,String>();

        List<Account> a = mAccountRepo.findAccountByUserName(user_name);
        if(a.size()!=0)//用戶名已被註冊
        {
            m.put("Register_result","The username has been registered");
            return new ResponseEntity<Map<String,String>>(m,HttpStatus.valueOf(1000));
        }

        final Account account = new Account();
        account.setNewAccount(user_name,user_password);
        mAccountRepo.save(account);
        m.put("Register_result","ok");
        return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);

    }

    //登录

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> Login(@RequestBody NewAccount na
            ) {
        String user_name = na.getUser_name();
        String user_password = na.getUser_password();
        Map<String,Object> m = new HashMap<String,Object>();
        List<Account> a = mAccountRepo.findAccountByUserName(user_name);
        if(a.size()==0)
        {
            m.put("Login_result","The username doesn't exist");
            return new ResponseEntity<>(m, HttpStatus.valueOf(1001));
        }
        else
        {
            if(a.get(0).getPassword().equals(user_password))
            {
                m.put("Login_result", "ok");
                m.put("id",a.get(0).getId());
                m.put("username",a.get(0).getUserName());
                m.put("tel",a.get(0).getTel());
                m.put("money",a.get(0).getMoney());
                return new ResponseEntity<>(m, HttpStatus.OK);
            }
            else
            {
                m.put("Login_result","The password is not correct");
                return new ResponseEntity<>(m, HttpStatus.valueOf(1002));
            }
        }

    }

    //修改密码
    @RequestMapping(value = "/Update_password", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> Update_password(
            @RequestBody NewAccount na) {
        String user_name = na.getUser_name();
        String user_password = na.getUser_password();
        String new_user_password = na.getNew_userpassword();
        Map<String,String> m = new HashMap<String,String>();
        List<Account> a = mAccountRepo.findAccountByUserName(user_name);
        if(a.size()==0)
        {
            m.put("Update_password_result","The username doesn't exist");
            return new ResponseEntity<>(m, HttpStatus.valueOf(1001));
        }
        else
        {
            if(a.get(0).getPassword().equals(user_password))
            {
                a.get(0).setPassword(new_user_password);
                mAccountRepo.save(a.get(0));
                m.put("Update_password_result", "ok");
                return new ResponseEntity<>(m,HttpStatus.OK);
            }
            else
            {
                m.put("Update_password_result","The password is not correct");
                return new ResponseEntity<>(m, HttpStatus.valueOf(1002));
            }
        }

    }

}
