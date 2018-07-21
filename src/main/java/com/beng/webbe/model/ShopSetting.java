package com.beng.webbe.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_settings")
public class ShopSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    Integer userId;

    @Column
    Integer itemId;

    @Column
    Integer amount;

    @Column
    String address;

    @Column
    Integer intervalTime;

    @Column
    String name;

    public ShopSetting(){}

    public Integer getAmount() {
        return amount;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setSettings(
            Integer userId,
            Integer itemId,
            Integer amount,
            String address,
            Integer intervalTime) {
        this.address = address;
        this.userId=userId;
        this.itemId=itemId;
        this.amount=amount;
        this.intervalTime =intervalTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}

