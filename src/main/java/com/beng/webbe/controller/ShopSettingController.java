package com.beng.webbe.controller;

import com.beng.webbe.model.ShopSetting;
import com.beng.webbe.repository.ShopSettingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopSettingController {

    @Autowired
    private ShopSettingRepo shopSettingRepo;

    @RequestMapping(value = "/shop-setting", method = RequestMethod.GET)
    public ResponseEntity<List<ShopSetting>> getShopSettingList(@RequestParam final Integer userId) {
        return new ResponseEntity<>(shopSettingRepo.findByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/shop-setting/{id}", method = RequestMethod.GET)
    public ResponseEntity<ShopSetting> getShopSetting(@PathVariable final Integer id) {
        return new ResponseEntity<ShopSetting>(shopSettingRepo.findOneById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/shop-setting", method = RequestMethod.POST)
    public ResponseEntity<String> addShopSetting(@RequestBody final ShopSetting shopSetting) {
        shopSettingRepo.save(shopSetting);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @RequestMapping(value = "/shop-setting/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> changeShopSetting(
            @PathVariable final Integer id,
            @RequestBody final ShopSetting shopSetting) {
        shopSetting.setId(id);
        shopSettingRepo.save(shopSetting);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/shop-setting/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteShopSetting(@PathVariable final Integer id) {
        shopSettingRepo.deleteById(id);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
