/*
 * PrivateWordbook.java
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
@Table(name = "private_wordbook")
public class PrivateWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer superId;

    @Column
    Integer id;

    @Column
    String user;

    @Column
    String word;

    @Column
    String meaning;

    public PrivateWord() {
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public Integer getSuperId() {
        return superId;
    }

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setNewWord(final Integer id, final String user, final String word,
            final String meaning) {
        this.id = id;
        this.user = user;
        this.word = word;
        this.meaning = meaning;
    }
}
