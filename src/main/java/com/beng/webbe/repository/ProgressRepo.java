/*
 * ProgressRepo.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.repository;

import com.beng.webbe.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuandun
 *
 */
public interface ProgressRepo extends JpaRepository<Progress, Integer> {
    List<Progress> getByUser(String user);

    Progress findOneByUserAndBook(String user, String book);
}
