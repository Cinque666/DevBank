package com.by.dev.ramanzamoiski.bean;

public class Account {

    private long id;

    private int account;

    private int userId;

    public Account() {
    }

    public Account(int account, int userId) {
        this.account = account;
        this.userId = userId;
    }

    public Account(long id, int account, int userId) {
        this.id = id;
        this.account = account;
        this.userId = userId;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getAccount(){
        return account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
