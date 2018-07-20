package com.beng.webbe.repository;

import com.beng.webbe.model.ShopHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopHistoryRepo extends JpaRepository<ShopHistory, Integer> {
    List<ShopHistory> findByUserId(Integer userId);
}
