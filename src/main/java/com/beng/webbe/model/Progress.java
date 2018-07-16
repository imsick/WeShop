/*
 * Progress.java
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
@Table(name = "progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer superId;

    @Column
    String user;

    @Column
    String book;

    @Column
    Integer id;

    public Progress() {
    }

    public String getUser() {
        return user;
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

    public void setNewProgress(final String user, final String book) {
        this.user = user;
        this.book = book;
        this.id = 0;
    }

    public void addId() {
        this.id++;
    }
}
