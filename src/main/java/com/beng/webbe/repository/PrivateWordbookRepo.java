/*
 * PrivateWordbook.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.repository;

import com.beng.webbe.model.PrivateWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuandun
 *
 */
public interface PrivateWordbookRepo extends JpaRepository<PrivateWord, Integer> {
    List<PrivateWord> getByUser(String user);
}
