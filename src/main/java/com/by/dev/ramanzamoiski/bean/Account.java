package com.by.dev.ramanzamoiski.bean;

public class Account {

    private long id;

    private String account;

    private int userId;

    public Account() {
    }

    public Account(String account, int userId) {
        this.account = account;
        this.userId = userId;
    }

    public Account(long id, String account, int userId) {
        this.id = id;
        this.account = account;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
