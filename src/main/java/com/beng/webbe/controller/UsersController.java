/*
 * UsersController.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.controller;

import com.beng.webbe.model.Progress;
import com.beng.webbe.model.User;
import com.beng.webbe.repository.ProgressRepo;
import com.beng.webbe.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author yuandun
 *
 */
@RestController
public class UsersController {
    @Autowired
    private UsersRepo mUsersRepo;
    @Autowired
    private ProgressRepo mProgressRepo;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUserInfo(@RequestParam final String user) {
        final User userInfo = mUsersRepo.findFirstByUser(user);
        userInfo.setPasswordVoid();
        return new ResponseEntity<User>(userInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> register(
            @RequestParam final String user,
            @RequestParam final String password,
            @RequestParam final String email
    ) {
        final User userInfo = new User();
        if(mUsersRepo.findFirstByUser(user)!=null || mUsersRepo.findFirstByEmail(email)!=null)
        {
            return new ResponseEntity<User>(userInfo, HttpStatus.BAD_REQUEST);
        }
        userInfo.setNewUser(user, password, email);
        mUsersRepo.save(userInfo);
        Progress progress1 = new Progress(),progress2 = new Progress();
        progress1.setNewProgress(user,"托福");
        progress2.setNewProgress(user,"雅思");
        mProgressRepo.save(progress1);
        mProgressRepo.save(progress2);
        userInfo.setPasswordVoid();
        return new ResponseEntity<User>(userInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/token", method = RequestMethod.GET)
    public ResponseEntity<String> getToken(@RequestParam final String user,@RequestParam final String password) {
        final User userInfo = mUsersRepo.findFirstByUser(user);
        if(userInfo==null) return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
        if(checkDayDate(userInfo.getDayUpdatedAt())){userInfo.updateDay();mUsersRepo.save(userInfo);}
        if(userInfo.getPassword().equals(password))return new ResponseEntity<String>("ok", HttpStatus.OK);
        return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/user/plan", method = RequestMethod.POST)
    public ResponseEntity<User> setPlan(
            @RequestParam final String user,
            @RequestParam final Integer plan) {
        final User userInfo = mUsersRepo.findFirstByUser(user);
        if (checkPlanDate(userInfo.getPlanUpdatedAt())) {
            userInfo.setPlan(plan);
            mUsersRepo.save(userInfo);
            userInfo.setPasswordVoid();
            return new ResponseEntity<User>(userInfo, HttpStatus.OK);
        } else {
            userInfo.setPasswordVoid();
            userInfo.setPlan(-1);
            return new ResponseEntity<User>(userInfo, HttpStatus.OK);
        }
    }
    private boolean checkDayDate(final Date dayUpdatedAt) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final Date today = new Date();
        String d1=today.toString();
        String d2=dayUpdatedAt.toString();
        Date dt1=new Date(),dt2=new Date();
        try {
            dt1 = df.parse(d1);
            dt2 = df.parse(d2);
        }
        catch (Exception e)
        {
            ;
        }

        return dt1.getTime() > dt2.getTime();
    }
    private boolean checkPlanDate(final Date planUpdatedAt) {
        final Date today = new Date();
        final Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(today);

        final Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(planUpdatedAt);
        calendar2.add(calendar2.DATE, 7);

        return calendar1.after(calendar2);
    }
}
