package com.beng.webbe.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    Integer userId;

    @Column
    String address;

    Address(){}

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }
}
