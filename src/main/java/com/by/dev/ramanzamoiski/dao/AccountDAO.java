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

    public static final AccountDAO INSTANCE = new AccountDAO();

    private AccountDAO(){}

    public List<Account> getAll() {
        Account account;
        List<Account> accounts = new ArrayList<Account>();
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = connection.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();

            while(rs.next()){
                long id = rs.getInt(1);
                String accountRS = rs.getString(2);
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
            ps.setString(1, account.getAccount());
            ps.setInt(2, account.getUserId());

            ps.execute();
        } catch (SQLException e) {
            LOGGER.error("SQLException add method, AccountDAO class");
        }

    }
}
