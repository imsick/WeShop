///*
// * ProgressController.java
// * Copyright 2018 Qunhe Tech, all rights reserved.
// * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
// */
//
//package com.beng.webbe.controller;
//
//import com.beng.webbe.model.Progress;
//import com.beng.webbe.model.User;
//import com.beng.webbe.repository.ProgressRepo;
//import com.beng.webbe.repository.UsersRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @author yuandun
// *
// */
//@RestController
//public class ProgressController {
//    @Autowired
//    private ProgressRepo mProgressRepo;
//    @Autowired
//    private UsersRepo mUsersRepo;
//
//    @RequestMapping(value = "/progress", method = RequestMethod.GET)
//    public ResponseEntity<List<Progress>> getProgress(@RequestParam final String user) {
//        return new ResponseEntity<List<Progress>>(mProgressRepo.getByUser(user), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/progress", method = RequestMethod.POST)
//    public ResponseEntity<Progress> addProgress(@RequestParam final String user,
//            @RequestParam final String book) {
//        final Progress progress = mProgressRepo.findOneByUserAndBook(user, book);
//        progress.addId();
//        final User u = mUsersRepo.findFirstByUser(user);
//        u.addOne();
//        mUsersRepo.save(u);
//        return new ResponseEntity<Progress>(mProgressRepo.save(progress), HttpStatus.OK);
//    }
//}
