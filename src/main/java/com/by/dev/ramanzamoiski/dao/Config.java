package com.by.dev.ramanzamoiski.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Config {

    private static final Logger LOGGER = LogManager.getLogger(Config.class);

    public static final Config INSTANCE = new Config();

    private static final String DB_PROPERTY_FILE_FOR_PC_VERSION = "src/main/resources/db.properties";

    private static final String DB_PROPERTY_FILE = "http/WEB-INF/classes/db.properties";

    private static final String DB_HOST = "db.host";

    private static final String DB_LOGIN = "db.login";

    private static final String DB_PASSWORD = "db.password";

    private Config(){
    }

    public Connection getConnection(){
//        FileInputStream fis;
//        Properties property = new Properties();
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            properties.load(is);
//            fis = new FileInputStream(DB_PROPERTY_FILE_FOR_PC_VERSION);
//            property.load(fis);

            String host = properties.getProperty(DB_HOST);
            String login = properties.getProperty(DB_LOGIN);
            String password = properties.getProperty(DB_PASSWORD);

            connection = DriverManager.getConnection(host, login, password);

        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFountException setConnection method, Config class");
        } catch(IOException e){
            LOGGER.error("IOException setConnection method, Config class");
        } catch(SQLException e) {
            LOGGER.error("SQLException setConnection method, Config class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        } catch (ClassNotFoundException e) {
//            LOGGER.error("ClassNotFoundException setConnection method, Config class");
//        }
        return connection;
    }
}
