package com.beng.webbe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BankShowController {


    @RequestMapping(value = "/bankShow", method = RequestMethod.GET)
    public String bankShow(
    ) {
        return "BankInfo";
    }

    





}
