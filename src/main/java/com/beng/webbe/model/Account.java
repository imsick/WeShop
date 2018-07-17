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

    Account(){}

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
}
