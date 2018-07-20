package com.beng.webbe.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.beng.webbe.model.Account;

import com.beng.webbe.model.Account;
import com.beng.webbe.model.AccountAndAddress;
import com.beng.webbe.model.Address;

import com.beng.webbe.repository.AccountRepo;
import com.beng.webbe.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;

    private HttpRequest httpRequest;

    class AccountInfo {
        Integer userId;
        String userName;
        String tel;
        List<String> addressList;
    }
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public ResponseEntity<String> recharge(
            @RequestParam final int user_id,@RequestParam final int money

    ) {

        AlipayClient alipayClient = new
                DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2018071960663535", "MIIEpQIBAAKCAQEA1BgpabZ9h54YExwXED9HlfMGbsA8wSATWMSbL2gn566+hHSq" +
                "ooVgifIzu8t02hKa01IXU5RIBYBA0QGiyPpulMvd28WDzAbKLJRBrT4/pTBWU56G" +
                "OBsiRaB7MJww5GQ5qoFzY/183JD+RiyX5cRlDusuq24sIRo9WHoKlApu1/BXQkE/" +
                "mgnZj5jhDU/e6yLAMZhJ8//s2EXuaZ1u5s5OVBXMc2zxyG/8gxsxyuxogVxt1lIK" +
                "fG0PtlkT6vzYZsnSQjgNugu2uuMa2vkT8QnVFm9CH7IJySkBmiOrCW2wTeWum6t8" +
                "450qYDAUak+Ma4foQxQkHLiFlnGRozhHtkz2YwIDAQABAoIBAQCREyXgpW8gAMe+" +
                "6ovsFRzGOMHBp8Tm5SXWpkTwHHKPSzwOJi9Bk7IBKaaxYe2/7NHykkhaZycMfDnZ" +
                "vSC4EHTrWreayHPqbwqDi7WQ5u9p8rJZ6Cku34CF18vr6CqZTuUS+BER6CYsSRFk" +
                "tsP/6mKl3cDCik2tJuGnT3NE6A4BrajaEBo7r6X3cI32xyAzkJiLbQ+r5tDuBmgP" +
                "j+/CmiCqpVAPfZFveMJeCvsxxVTVC/Wq4pgx1SivUy+uz4xLSeraTjVvwu1UwkV5" +
                "/7JK3i7xJlS/aUTG5RQPB58FCag2bCm3Ov7E55STF9cjf3jOWVuEXnYqiEbVUYIB" +
                "CPnn+y5BAoGBAPgn8/iMYZIreenK7QtYED+L0KiQtVYJzSjGvUOQNzhM/rib5399" +
                "+ufc+eIiMtn0+GgQ432PcDvwcS/47MFSPuiiE/BQC+SmbUPUEzqwj3T5Os20Tstc" +
                "5f5U/ftUe8HMdWJOIzAkHSeqQwCRLPPFeIMAGoCqWk91ahmkb69IRR6bAoGBANrM" +
                "ZvldsCCb7z01PsNunEpCMtZPLOlVP5t1AdfygTrHBwa/kplBPTgnUlkFNmyFlDp0" +
                "Fj7HIRZbdXQMv2oNW3qEPm5tLCEp6XsJhKCzfThwmNDDY8SlioRU6R5DNOCAoxOz" +
                "os8XCxekbROCYshyydQQAFzVckhTX3acMxhMd9/ZAoGAP5FcecrcI6lnbXBCEKna" +
                "X6zdIpEPIp8YIt3mFayXuKBgj8HAJ3SKFWMRz8+a3yJVj7Lj04Iu6evJ0tQdMdhz" +
                "rPv3x5N5uHS5gKqO0nXwCbLeUVti481ETUZQWVVm7loFp80EToyxuztuNnL55Ogs" +
                "2sHoCBWbVMdrCm6I/YmxywkCgYEAtU556hvDjlIJHlxX5RRseHCAtewoGDZnHggI" +
                "fgzbH3y7itEGxu4zr6uN5myWW7kZSpLVuDHEbkVdf8vsdhIZgt3A6jqXPegALM+H" +
                "Uq9JjZJoX13594MB1ISUJFqmn36ZJANQX3EF5RKAvJDoEJhmPM8BrevF5r8HtT7c" +
                "bD85eokCgYEAkOgLegw8jhYzizoJLhU/xQcL2z5BHrEJ9InLK4l/tgxi8IgCFqbq" +
                "oejsmR5nepX+a7N/tIBxlZNj5aBUGJSumny5dGawtRGBFHwNwq0SSPYVRG5ODt5B" +
                "veVO86Ip66EwLgXRBevMwzWebw/Ljct2Ol7Qd3XKeKu2QH5Enx56zwE=", "json", "utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr9b6adnev/MJfFZaVcNQo9HSZfEnYVXdhqPI24xFaz1F1gVgYjTQbwFLBnxe1AGiUSfjqxhol7GUk8X+4f4EfceLrzDh2vwd/3XYKIHSNv1iNgm+HyymHjc6v8F563Ku8UibE6cUrUSlwpoSR8PaIvsih5k7+Z1vZ/bAVOQYMEFCBwzd5nHadfquz6pZfDsAaMR6qOJ6T8XMaITGk001P/Aat0Y9ksHq6Gx1NBg05D9miHRySFGz3WC+zJicsygX0AR5DpfwGeOT1FdgnLM6gxveBipXwz3xBaBMmp2e2p+N6CMSzh4rSK4pZaDTR9sHNkHJQ2oe+md2rlfpBFpSswIDAQAB", "RSA2");

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo(String.valueOf(user_id));
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("http://114.115.143.130:8080/rechargeAlipay");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
    @RequestMapping(value = "/rechargeAlipay", method = RequestMethod.POST)
    String getResponse(HttpServletRequest request)
    {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr9b6adnev/MJfFZaVcNQo9HSZfEnYVXdhqPI24xFaz1F1gVgYjTQbwFLBnxe1AGiUSfjqxhol7GUk8X+4f4EfceLrzDh2vwd/3XYKIHSNv1iNgm+HyymHjc6v8F563Ku8UibE6cUrUSlwpoSR8PaIvsih5k7+Z1vZ/bAVOQYMEFCBwzd5nHadfquz6pZfDsAaMR6qOJ6T8XMaITGk001P/Aat0Y9ksHq6Gx1NBg05D9miHRySFGz3WC+zJicsygX0AR5DpfwGeOT1FdgnLM6gxveBipXwz3xBaBMmp2e2p+N6CMSzh4rSK4pZaDTR9sHNkHJQ2oe+md2rlfpBFpSswIDAQAB",  "UTF-8", "RSA2");
        }
        catch (com.alipay.api.AlipayApiException e)
        {
            return "fail";
        }

        if(signVerified)
        {
            if(request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
                int user_id = Integer.valueOf(request.getParameter("out_trade_no")).intValue();
                int amount = (int)(Double.valueOf(request.getParameter("total_amount")).doubleValue()*100);
                Account a = accountRepo.findOneById(user_id);
                a.setMoney(a.getMoney()+amount);
                accountRepo.save(a);
                return "success";
            }
            return "fail";
        }
        else
        {
            return "fail";
        }
    }

    @Autowired
    private AddressRepo addressRepo;


    @RequestMapping(value = "/information", method = RequestMethod.POST)
    public ResponseEntity<String> changeInfo(@RequestBody final AccountAndAddress account) {
        Integer userId=account.getId();
        Account target=accountRepo.findOneById(userId);
        target.setTel(account.getTel());
        accountRepo.save(target);
        addressRepo.deleteByUserId(userId);
        for(String add:account.addresses)
        {
            Address address=new Address();
            address.addNew(userId,add);
            addressRepo.save(address);
        }
        return new ResponseEntity<>(account.addresses.get(0), HttpStatus.OK);
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public ResponseEntity<Integer> viewMoney(@RequestParam final Integer userId) {
        return new ResponseEntity<>(accountRepo.findOneById(userId).getMoney(), HttpStatus.OK);
    }






}
