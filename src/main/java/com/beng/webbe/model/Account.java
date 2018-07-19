package com.beng.webbe.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    String userName;

    @Column
    String password;

    @Column
    String tel;

    @Column
    Integer money;

    public Account(){}

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getMoney() {
        return money;
    }

    public void setNewAccount(final String userName, final String password
                           ) {
        this.userName = userName;
        this.password = password;
        this.money = 0;
        this.tel="0";
    }
    public void setPassword(final String password)
    {
        this.password = password;
    }
}
