package com.beng.webbe.repository;

import com.beng.webbe.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    @Transactional
    @Modifying
    @Query(value= "delete from addresses where user_id= ?1",nativeQuery=true)
    void deleteByUserId(Integer userId);
}
