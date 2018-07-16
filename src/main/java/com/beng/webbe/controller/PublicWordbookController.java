/*
 * PublicWordbookController.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.controller;

import com.beng.webbe.model.PublicWord;
import com.beng.webbe.repository.PublicWordbookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuandun
 *
 */
@RestController
public class PublicWordbookController {

    @Autowired
    private PublicWordbookRepo mPublicWordbookRepo;

    @RequestMapping(value = "/public-wordbook", method = RequestMethod.GET)
    public ResponseEntity<List<PublicWord>> getPublicWordbook(@RequestParam final String book) {
        return new ResponseEntity<List<PublicWord>>(mPublicWordbookRepo.getByBook(book),
                HttpStatus.OK);
    }
}
