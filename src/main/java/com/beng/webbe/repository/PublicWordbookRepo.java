/*
 * PublicWordbookRepo.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.repository;

import com.beng.webbe.model.PublicWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuandun
 *
 */
public interface PublicWordbookRepo extends JpaRepository<PublicWord, Integer> {
    List<PublicWord> getByBook(String book);
}
