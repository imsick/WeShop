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
import com.beng.webbe.model.PrivateWord;
import com.beng.webbe.repository.PrivateWordbookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuandun
 *
 */
@RestController
public class LoginInterfaceController {
    //注册
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> Register(
            @RequestParam final String user_name,@RequestParam final String user_password) {
        Map<String,String> m = new HashMap<String,String>();
        m.put("Register_result","ok");
        return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
    }

    //登录
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> Login(
            @RequestParam final String user_name,@RequestParam final String user_password) {
        Map<String,String> m = new HashMap<String,String>();
        m.put("Login_result","ok");
        return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
    }

    //修改密码
    @RequestMapping(value = "/Update_password", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> Update_password(
            @RequestParam final String user_name,@RequestParam final String user_password,@RequestParam final String new_user_password) {
        Map<String,String> m = new HashMap<String,String>();
        m.put("Update_password_result","ok");
        return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
    }

}
