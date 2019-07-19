package com.by.dev.ramanzamoiski.dao;

import com.by.dev.ramanzamoiski.bean.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements DAO{

    private static final Logger LOGGER = LogManager.getLogger(AccountDAO.class);

    private static final String SELECT_ALL = "SELECT * FROM account";

    private static final String INSERT = "INSERT INTO account(account, userId) VALUE(?, ?)";
    private static final String TOTAL_ACCOUNT = "SELECT SUM(account) as account FROM account";

    public static final AccountDAO INSTANCE = new AccountDAO();

    private AccountDAO(){}

    public List<Account> getAll() {
        Account account;
        List<Account> accounts = new ArrayList<>();
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = connection.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();

            while(rs.next()){
                long id = rs.getInt(1);
                int accountRS = rs.getInt(2);
                int userId = rs.getInt(3);
                account = new Account(id, accountRS, userId);
                accounts.add(account);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException getAll method, AccountDAO class");
        }
        return accounts;
    }

    public void add(Object accountObject) {
        Account account = (Account) accountObject;
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(INSERT);
            ps.setInt(1, account.getAccount());
            ps.setInt(2, account.getUserId());

            ps.execute();
        } catch (SQLException e) {
            LOGGER.error("SQLException add method, AccountDAO class");
        }

    }

    public Account getSummary(){
        Account account = new Account();
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(TOTAL_ACCOUNT);
            ResultSet rs = ps.executeQuery();
            rs.next();

            int accountValue = rs.getInt("account");
            account = new Account();
            account.setAccount(accountValue);

        } catch (SQLException e) {
            LOGGER.error("SQLException getSummary method, AccountDAO class");
        }
        return account;
    }
}
