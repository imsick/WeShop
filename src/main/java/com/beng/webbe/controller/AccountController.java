package com.beng.webbe.controller;


import com.beng.webbe.model.Account;
import com.beng.webbe.model.AccountAndAddress;
import com.beng.webbe.model.Address;
import com.beng.webbe.repository.AccountRepo;
import com.beng.webbe.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;
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
