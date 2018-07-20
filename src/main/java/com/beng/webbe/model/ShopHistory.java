package com.beng.webbe.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_history")
public class ShopHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    Integer userId;

    @Column
    String info;

    public ShopHistory(){}

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void addNew(Integer userId,String info) {
        this.userId = userId;
        this.info=info;
    }
}
