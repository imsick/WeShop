package com.beng.webbe.repository;

import com.beng.webbe.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
