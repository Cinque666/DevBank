package com.by.dev.ramanzamoiski.dao;

import com.by.dev.ramanzamoiski.bean.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO{

    public static final UserDAO INSTANCE = new UserDAO();

    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

    private static final String INSERT = "INSERT INTO user(name, surName) VALUE(?, ?)";

    private static final String SELECT_ALL = "SELECT * FROM user";

    private static final String SELECT_BY_ID = "SELECT * FROM user WHERE id = ?";

    private static final String SELECT_MAX_ACCOUNT = "SELECT name, surName, MAX(account) as account FROM user_and_account_join";

    private UserDAO(){}

    public void add(Object userObject){

        User user = (User) userObject;
        Connection connection = Config.INSTANCE.getConnection();

        PreparedStatement ps;

        if(connection != null){
            try {
                ps = connection.prepareStatement(INSERT);
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurName());
                ps.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error("SQLException addUser method, UserDAO class");
            }
        }
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<User>();
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(SELECT_ALL);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                long id = rs.getInt(1);
                String name = rs.getString(2);
                String surName = rs.getString(3);
                User user = new User(id, name, surName);
//                System.out.println(user.toString());
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException getAll method, UserDAO class");
        }

        return users;
    }

    public User getUserById(long id){
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;
        User user = new User();

        try {
            ps = connection.prepareStatement(SELECT_BY_ID);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            long userId = rs.getLong(1);
            String name = rs.getString(2);
            String surName = rs.getString(3);

            user = new User(userId, name, surName);
        } catch (SQLException e) {
            LOGGER.error("SQLException getUserById method, UserDAO class");
        }
        return user;
    }

    public User getMaxAccountValue(){
        Connection connection = Config.INSTANCE.getConnection();
        PreparedStatement ps;
        User user = new User();

        try {
            ps = connection.prepareStatement(SELECT_MAX_ACCOUNT);
            ResultSet rs = ps.executeQuery();

            rs.next();
            int account = rs.getInt("account");
            String name = rs.getString("name");
            String surName = rs.getString("surName");

            user = new User(name, surName, account);
        } catch (SQLException e) {
            LOGGER.error("SQLException selectMaxValue method, UserDAO class");
        }
        return user;
    }
}
