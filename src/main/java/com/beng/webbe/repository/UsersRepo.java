/*
 * UsersRepo.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.repository;

import com.beng.webbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuandun
 *
 */
public interface UsersRepo extends JpaRepository<User,Integer> {
    User findFirstByUser(String user);
    User findFirstByEmail(String email);
}
