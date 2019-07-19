package com.by.dev.ramanzamoiski.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Config {

    private static final Logger LOGGER = LogManager.getLogger(Config.class);

    public static final Config INSTANCE = new Config();

    private static Connection connection = setConnection();

    private static final String DB_PROPERTY_FILE = "src/main/resources/db.properties";

    private static final String DB_HOST = "db.host";

    private static final String DB_LOGIN = "db.login";

    private static final String DB_PASSWORD = "db.password";

    private Config(){}

    private static Connection setConnection(){
        FileInputStream fis;
        Properties property = new Properties();
        Connection connection = null;

        try {
            fis = new FileInputStream(DB_PROPERTY_FILE);
            property.load(fis);

            String host = property.getProperty(DB_HOST);
            String login = property.getProperty(DB_LOGIN);
            String password = property.getProperty(DB_PASSWORD);

            connection = DriverManager.getConnection(host, login, password);

        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFountException setConnection method, Config class");
        } catch(IOException e){
            LOGGER.error("IOException setConnection method, Config class");
        } catch(SQLException e){
            LOGGER.error("SQLException setConnection method, Config class");
        }
        return connection;
    }

    public Connection getConnection(){
        return connection;
    }
}
