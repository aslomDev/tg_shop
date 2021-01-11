package com.company.telegramshop.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|firstName")
@Table(name = "TELEGRAMSHOP_USER")
@Entity(name = "telegramshop_User")
public class User extends StandardEntity {
    private static final long serialVersionUID = 6180318388135078747L;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userId")
    private String userId;

    public User(String lastName, String firstName, String userName, String userId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.userId = userId;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}