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
    Integer interval;

    ShopSetting(){}

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

    public Integer getInterval() {
        return interval;
    }

    public Integer getItemId() {
        return itemId;
    }

}

