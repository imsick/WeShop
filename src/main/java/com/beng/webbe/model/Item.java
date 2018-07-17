package com.beng.webbe.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    String itemName;

    @Column
    Integer price;

    @Column
    Integer amount;

    @Column
    String description;

    @Column
    String picturePath;

    Item(){}

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPicturePath() {
        return picturePath;
    }

}
