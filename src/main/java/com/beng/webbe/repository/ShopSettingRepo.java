package com.beng.webbe.repository;

import com.beng.webbe.model.ShopSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopSettingRepo  extends JpaRepository<ShopSetting, Integer> {
    List<ShopSetting> findByUserId(Integer userId);
    ShopSetting findOneById(Integer id);
}
