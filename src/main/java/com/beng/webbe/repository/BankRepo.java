package com.beng.webbe.repository;

import com.beng.webbe.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Integer> {
    Bank findBankByUserId(int user_id);
}
