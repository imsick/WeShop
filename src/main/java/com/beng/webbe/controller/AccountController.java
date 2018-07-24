package com.beng.webbe.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.beng.webbe.model.*;

import com.beng.webbe.model.Account;

import com.beng.webbe.repository.AccountRepo;
import com.beng.webbe.repository.AddressRepo;
import com.beng.webbe.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BankRepo bankRepo;

    private HttpRequest httpRequest;

    class AccountInfo {
        Integer userId;
        String userName;
        String tel;
        List<String> addressList;
    }
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public ResponseEntity<String> recharge(
            @RequestBody final Account account

    ) {
        int user_id = account.getId();
        int money = account.getMoney();
        AlipayClient alipayClient = new
                DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016091900545639", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9eF/0HNakuQBshAv9re/YEYlSei6zzDQ3BAQxbrtuIUW04fqrLF/y+krALR0FLTmpL9WdFoCuSkxAyZj/2qFFzK2mhaOohM8B0dsJXae8MQHSOQAC4TlyubMBJ8w+oDxOye7Zrd8T4IuMqBUrtkLLSjyfrqUGvhEUkfNw9Cs0NrcTsVZZY+hV8nOdisf/zb7fsC7b4f8HtiX2UxuqWK8W86OTmiFKZa9Lj7oien4IT9UcNKX6W/vGT6yKtAtdYLgcSDBFWsq68Wsi/eVaS2jeqh9SiUXIUFY2kEjDjPjg+wMVtL/JJnVh+csgTHiSdRrtE8rr7Iu5JEAB2qhhJxFBAgMBAAECggEBAIOKHbvBhbcohUXRSu3cowXz7s1m7COBYsLLNAoJoXBtAxL4TGooTZjH8buH1nzwj/aIshn0NHRMOrJEA8elRo/J8MkKQLvPMFRIGHRhJAGAWI5Vak+Vg6fFiqQDuEXGQvhEM2HG13faTafiTYhiae7u5DXMLuAGdp88ULGbop8FJxz/XVS4KFRsifqMML4W5oLMmL6MpRladwZd/WlxazB2d9BE3EWjx9hzhrg3TI4f/q0RkkTXH4/7+4GT+Z7WrwK+FPfK3yJ13vpphbkGQrielnu+Y23Pd50ZRU1VKGZeJ+QLkxebNsq9MG9HhqzqzhSEK0CzwW7CRoyVDGIJnZECgYEA6pxkHcy1HXNypdYYwhdIYuuGGGwjNP7J/H6NCkeIcAiSuyKEjCiyv7Z/39k2npZwY+g9QMgpoWn4v+k/9j8Igh6M0pR1RukrxV9K1EjP2ErNDMos5PC+8ufK2I2M8zW+f+tNh9gKnUtYPLtwoXPFFbwdu2JUfUuAt6pUjbMlKz0CgYEAzr5wvTdcHdJaF8AKPC4OIV3ivCck9nYxCKezO00LpbZXuVaS90tYk8SNl7nm4R5/DNfCCY4UsBRsmbiZIFD5yEFSjqXaRgnilQYmtoMqiIsrPDB7N1WS6+vnMH47ACbnVkVLlJTCZE0M+IBfXwaCAEzOKKv4yU3J8WUgFyPh7lUCgYBYUzJ56ZSSFuGlv3mosJ1G6IaecS+8BuRCU96DbTTXgNLE8xTVs4jAFlQEEUG36Mk9Q7Szy+eoZj4I+iZjbY2ldxzrNosEfEpHTz3bt+HP+zFBTGgkdOJejpdWecwD0Er827hfmR095Jy+mI6pqe0b5quG3VkTprY57z1P747hvQKBgDr1sK0llo2iqbLQP5r9/2WgosLJ3w6ykjVHriOhS0sM/2OJvwvrXu11RnQYvjFBQzZkaZ/T9y5oBLiqHnFK5pEnn+WygtcqhoW9ZVjzezPJjKDzqpATRX0mn54Cwcy/S4Yc6PsMmYuFNcfAxHITJwvy23BZ6u9t0cOX9VjkENCpAoGBAODLFsU1BQ0qC5vaWljzyjjwBBOmeAEzmvBzmLchQZqt7EGqts8N31/jc5t4wKLnwqhswjSz9RNdCu3/CMmbcBJxg6SkgwEfWyKITuzKWoOs9EvAAvI9PxTytGq8zWmPvmjUW6tYwP8neFZKclvd2lUW1gzgpK8nwNh48G34YSWV", "json", "utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr9b6adnev/MJfFZaVcNQo9HSZfEnYVXdhqPI24xFaz1F1gVgYjTQbwFLBnxe1AGiUSfjqxhol7GUk8X+4f4EfceLrzDh2vwd/3XYKIHSNv1iNgm+HyymHjc6v8F563Ku8UibE6cUrUSlwpoSR8PaIvsih5k7+Z1vZ/bAVOQYMEFCBwzd5nHadfquz6pZfDsAaMR6qOJ6T8XMaITGk001P/Aat0Y9ksHq6Gx1NBg05D9miHRySFGz3WC+zJicsygX0AR5DpfwGeOT1FdgnLM6gxveBipXwz3xBaBMmp2e2p+N6CMSzh4rSK4pZaDTR9sHNkHJQ2oe+md2rlfpBFpSswIDAQAB", "RSA2");

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("test");
        model.setSubject(String.valueOf(user_id));
        model.setOutTradeNo(String.valueOf(new Date().getTime()));
        model.setTimeoutExpress("30m");
        model.setTotalAmount(String.valueOf(money));
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
        return new ResponseEntity<String>("fail", HttpStatus.OK);
    }
    @RequestMapping(value = "/rechargeAlipay", method = RequestMethod.POST)
    String getResponse(HttpServletRequest request)
    {
        System.out.println("receive");
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
            signVerified = AlipaySignature.rsaCheckV1(params,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvXhf9BzWpLkAbIQL/a3v2BGJUnous8w0NwQEMW67biFFtOH6qyxf8vpKwC0dBS05qS/VnRaArkpMQMmY/9qhRcytpoWjqITPAdHbCV2nvDEB0jkAAuE5crmzASfMPqA8Tsnu2a3fE+CLjKgVK7ZCy0o8n66lBr4RFJHzcPQrNDa3E7FWWWPoVfJznYrH/82+37Au2+H/B7Yl9lMbqlivFvOjk5ohSmWvS4+6Inp+CE/VHDSl+lv7xk+sirQLXWC4HEgwRVrKuvFrIv3lWkto3qofUolFyFBWNpBIw4z44PsDFbS/ySZ1YfnLIEx4knUa7RPK6+yLuSRAAdqoYScRQQIDAQAB",  "UTF-8", "RSA2");
        }
        catch (com.alipay.api.AlipayApiException e)
        {
            return "fail";
        }

        if(signVerified)
        {
            if(request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
                int user_id = Integer.valueOf(request.getParameter("subject")).intValue();
                int amount = (int)(Double.valueOf(request.getParameter("total_amount")).doubleValue());
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
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public ResponseEntity<Integer> viewMoney(@RequestParam final Integer userId) {
        return new ResponseEntity<>(accountRepo.findOneById(userId).getMoney(), HttpStatus.OK);
    }

    @RequestMapping(value = "/new-recharge", method = RequestMethod.POST)
    public ResponseEntity<String> newRecharge(@RequestBody final Account account) {
        Bank bank = bankRepo.getOne(account.getId());
        Integer newMoney = bank.getMoney()-account.getMoney();
        if(newMoney<0)
        {
            return new ResponseEntity<>("银行存款不足！", HttpStatus.OK);
        }
        bank.setMoney(newMoney);
        bankRepo.save(bank);
        Account origin = accountRepo.findOneById(account.getId());
        origin.setMoney(origin.getMoney()+account.getMoney());
        accountRepo.save(origin);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }




}
