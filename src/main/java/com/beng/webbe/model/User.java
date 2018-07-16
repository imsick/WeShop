/*
 * User.java
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
import java.util.Date;

/**
 * @author yuandun
 *
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer superId;

    @Column
    String user;

    @Column
    String password;

    @Column
    String email;

    @Column
    Integer plan;

    @Column
    Date planUpdatedAt;

    @Column
    Integer day1;

    @Column
    Integer day2;

    @Column
    Integer day3;

    @Column
    Integer day4;

    @Column
    Integer day5;

    @Column
    Integer day6;

    @Column
    Integer day7;

    @Column
    Date dayUpdatedAt;

    public User() {
    }

    public Integer getSuperId() {
        return superId;
    }

    public String getUser() {
        return user;
    }

    public Date getDayUpdatedAt() {
        return dayUpdatedAt;
    }

    public Date getPlanUpdatedAt() {
        return planUpdatedAt;
    }

    public Integer getDay1() {
        return day1;
    }

    public Integer getDay2() {
        return day2;
    }

    public Integer getDay3() {
        return day3;
    }

    public Integer getDay4() {
        return day4;
    }

    public Integer getDay5() {
        return day5;
    }

    public Integer getDay6() {
        return day6;
    }

    public Integer getDay7() {
        return day7;
    }

    public Integer getPlan() {
        return plan;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordVoid() {
        this.password = "******";
    }

    public void setPlan(final Integer plan) {
        this.plan = plan;
        this.planUpdatedAt = new Date();
    }

    public void setNewUser(final String user, final String password, final String email) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.plan = 0;
        this.planUpdatedAt = new Date(0, 1, 1);
        this.day1 = 0;
        this.day2 = 0;
        this.day3 = 0;
        this.day4 = 0;
        this.day5 = 0;
        this.day6 = 0;
        this.day7 = 0;
        this.dayUpdatedAt = this.planUpdatedAt;
    }

    public void addOne() {
        day1++;
    }

    public void updateDay() {
        day7 = day6;
        day6 = day5;
        day5 = day4;
        day4 = day3;
        day3 = day2;
        day2 = day1;
        day1 = 0;
        dayUpdatedAt=new Date();
    }
}
