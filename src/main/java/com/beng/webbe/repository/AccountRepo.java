package com.beng.webbe.repository;

import com.beng.webbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    List<Account> findAccountByUserName(String userName);
}
