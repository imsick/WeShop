package com.beng.webbe.repository;

import com.beng.webbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
