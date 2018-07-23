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
import java.util.HashMap;
import java.util.Iterator;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

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
            @RequestParam final int user_id,@RequestParam final int money

    ) {

        AlipayClient alipayClient = new
                DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2018071960663535", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFymmhgHG+8Tk6\n" +
                "x8Q2fFw8CupvI+BEIPa4LsRZfH8xyGJhimU4f4useIipCZaRbozBGNAgd5QcohlC\n" +
                "IEEaiseR4Q/Y5Ezq2+wGwZ1Uth604YmGtLTXxXuATnp3F1Yr6bwFPgbvTGDe0fAR\n" +
                "8H/lrfkP6MZA45OHmeFJN4TM6p7bvi2bykN7RG3yz32ILkzi3LCn6AWlGXkZRX+i\n" +
                "qzJsx2yUCUpH/whFIPaw3h2659ZKqPGdD4YTrc6SP5QrC1V0ovIAVsxYM6ZVYr2t\n" +
                "bNzIyzx+ET/slMo2IaPpXHIuqzLukcVQ+Td3BU74iJQTdlVNxYENYrNduV5weqvi\n" +
                "qaYIGPslAgMBAAECggEAMHHndXs0YQRMdC1Bzeaf4MT7rsUmxQkd5PbveMuZi+P8\n" +
                "1M9FA5WZ7GCJeH20t2JQb2tYbttbF7hMX3nu+EVNpFlvvDwO6ud65BzAIGOLGdq0\n" +
                "CJ5yPPdNzJtsO4cnwBG7z7zlje8zOuBI4Nv7N5JpEpB9Hp+fHvN9zqUejeJZjpCT\n" +
                "225CW8h0mlM6is66N8khNZFzUc8MUAQ/avaHpfXGjOoBTqAr82XihPHXBfBOPwJd\n" +
                "9gAOrniV5cdg+uMQuvYekVbdKPVixonPNDizFWEY9xGxN3ZM6vOPle/mxYfkfPqo\n" +
                "npNE1UncYy+ze6R4dbR8JEwgntnLItcRSeQqTG9ncQKBgQDraY9IORI6yutE965F\n" +
                "M1v0AOAT4OWzAV2wzXJR1BrwjfoKDQ6vBQytBWRhZ7tlx2mA2c/dPVMufMJhDQmU\n" +
                "ACMp2Ehtqma07iIhpepq2Qj2VwqRDm+7R/UZP5H6YfzskekzA9wk/jcgK7k/dg44\n" +
                "h+Lgx53sZwWr7XkdoulPDhrKuwKBgQDXFpMM9drs4DDzICQWowKKBZfYtSxXC5Wm\n" +
                "6UkqpuB3pJNUgZj5shx8iABGYDKwME68OTuhNKa5XzaJhSis4aqwoCen2hiKonFR\n" +
                "vgWdJ6Nsvo4cQPehwtnjwfn7cdx+Cf8tK492PBh5fAwEwcTt2cYEenUFj4K8lLSO\n" +
                "TCrvLSCjnwKBgQDDNN0jPm/nYKyGm/teVqBBTRiCY1MVhGR0X2gUgpV0M8bK3tj2\n" +
                "OHGyZ249dw7l7t2FgxfilR+MxNdKMs1mdFa0NCybA1n3Xh/fVv1zbFUKMFMKxbXQ\n" +
                "znJnZVdfEDHy2WtOajz6T/LWMmuCPBq+ta9kRSKnDSae0mRENvrQGxoMUQKBgGz/\n" +
                "562dukBorOXI2AEQwuynQPh1d+700/YuKwIOZ5q6MF+W/assc/s4AMupXIalNIF2\n" +
                "j512TTeL5Nt0O9TA1/uCbhZGFEHNaJgAMGAgAlXNi78NvXCgikM9vi2K2i6Vale9\n" +
                "x4onkk+eaYjPmbjfr9X9KOiUfbCLu6SRPQDQYcYJAoGBAOfdkgqm3UFjg1q73312\n" +
                "zf4EkWuxCAw5u3Ckwe6gYISlSpzWDmPW7Xf4Ci45JCn9BXarc2wLLshIhbn3Mnk0\n" +
                "iyN1DScx9pcVzjyapWZPNPlhtRcwoO1SqV/fUhAA3q0BQ8ezrdRRB+pZQyRIx5Hi\n" +
                "WNaoYJr4okee0ej4X9Qm+Svt\n", "json", "utf-8",
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
