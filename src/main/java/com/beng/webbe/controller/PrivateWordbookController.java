/*
 * PrivateWordbookController.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.controller;

import com.beng.webbe.model.PrivateWord;
import com.beng.webbe.repository.PrivateWordbookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuandun
 *
 */
@RestController
public class PrivateWordbookController {

    @Autowired
    private PrivateWordbookRepo mPrivateWordbookRepo;

    @RequestMapping(value = "/private-wordbook", method = RequestMethod.GET)
    public ResponseEntity<List<PrivateWord>> getPrivateWordbook(
            @RequestParam final String user) {
        return new ResponseEntity<List<PrivateWord>>(mPrivateWordbookRepo.getByUser(user),
                HttpStatus.OK);
    }




    @RequestMapping(value = "/private-wordbook", method = RequestMethod.POST)
    public ResponseEntity<PrivateWord> addWord(
            @RequestParam final Integer id,
            @RequestParam final String user,
            @RequestParam final String word,
            @RequestParam final String meaning
    ) {
        final PrivateWord privateWord = new PrivateWord();
        privateWord.setNewWord(id, user, word, meaning);
        return new ResponseEntity<PrivateWord>(mPrivateWordbookRepo.save(privateWord),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/private-wordbook", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteWord(@RequestParam final Integer superId) {
        mPrivateWordbookRepo.deleteById(superId);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
