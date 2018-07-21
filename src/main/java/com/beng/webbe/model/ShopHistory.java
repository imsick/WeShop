package com.beng.webbe.model;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    Date createdAt;

    @Column
    Integer itemId;

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

    public void addNew(Integer userId,String info,Date createdAt,Integer itemId) {
        this.userId = userId;
        this.info=info;
        this.createdAt=createdAt;
        this.itemId=itemId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getItemId() {
        return itemId;
    }
}
