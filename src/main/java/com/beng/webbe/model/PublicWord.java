/*
 * PublicWordbook.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.beng.webbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yuandun
 *
 */
@Entity
@Table(name = "public_wordbook")
public class PublicWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer superId;

    @Column
    Integer id;

    @Column
    String book;

    @Column
    String word;

    @Column
    String meaning;

    PublicWord() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getSuperId() {
        return superId;
    }

    public String getBook() {
        return book;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }
}
