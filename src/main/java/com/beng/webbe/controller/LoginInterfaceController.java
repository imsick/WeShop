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
//    @RequestMapping(value = "/private-wordbook", method = RequestMethod.POST)
//    public ResponseEntity<Map<String,String>> Pay(
//            @RequestParam final int money) {
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.SERVER_URI, AlipayConfig.APP_ID, AlipayConfig.RSA2_PRIVATE,
//                "json", AlipayConfig.input_charset, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
//
//        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//
//        // SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//        model.setBody("一个月会员");
//        model.setSubject("一个月会员");
//        model.setOutTradeNo(paymentOrder.getPkId()+"");
//        model.setTimeoutExpress("30m");
//        model.setTotalAmount(centTransformYuan(paymentOrder.getMoney()));
//        model.setProductCode("QUICK_MSECURITY_PAY");
//        request.setBizModel(model);
//        request.setNotifyUrl(AlipayConfig.app_notify_url);//回调地址
//        String orderInfo = null;
//        try {
//            //这里和普通的接口调用不同，使用的是sdkExecute
//            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
//            //response.getBody()就是orderString 可以直接给客户端请求，无需再做处理。
//            orderInfo = response.getBody();
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        logger.info("生成支付宝支付订单信息完成 orderInfo:{}",orderInfo);
//        Map<String, String> resultMap = new HashMap<String, String>();
//        resultMap.put(Dicts.ORDER_INFO, orderInfo);
//
//        return new Response<Map<String, String>>(resultMap)
//        return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
//    }
}
