package com.beng.webbe.controller;

import com.beng.webbe.model.Item;
import com.beng.webbe.model.ShopHistory;
import com.beng.webbe.model.ShopSetting;
import com.beng.webbe.repository.ItemRepo;
import com.beng.webbe.repository.ShopHistoryRepo;
import com.beng.webbe.repository.ShopSettingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ShopSettingController {

    @Autowired
    private ShopSettingRepo shopSettingRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ShopHistoryRepo shopHistoryRepo;


    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems()
    {
        return new ResponseEntity<>(itemRepo.findAll(),HttpStatus.OK);
    }

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

    @RequestMapping(value = "/shop",method = RequestMethod.POST)
    public ResponseEntity<String> buyItem(@RequestBody final ShopSetting shopSetting){
        ShopHistory shopHistory=new ShopHistory();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String desc=String.format("于%s购买%s共%d件",dateString,itemRepo.getOne(shopSetting.getItemId()).getItemName(),shopSetting.getAmount());
        shopHistory.addNew(shopSetting.getUserId(),desc);
        shopHistoryRepo.save(shopHistory);
        return new ResponseEntity<>("success",HttpStatus.OK);
//        shopHistory.addNew();
    }

    @RequestMapping(value = "/shop-history", method = RequestMethod.GET)
    public ResponseEntity<List<ShopHistory>> getShopHistory(@RequestParam final Integer userId) {
        return new ResponseEntity<>(shopHistoryRepo.findByUserId(userId), HttpStatus.OK);
    }
}
