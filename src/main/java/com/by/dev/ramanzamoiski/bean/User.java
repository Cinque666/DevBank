package com.by.dev.ramanzamoiski.bean;

public class User {

    private long id;

    private String name;

    private String surName;

    private int account;

    public User() {
    }

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public User(long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public User(String name, String surName, int account) {
        this.name = name;
        this.surName = surName;
        this.account = account;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
