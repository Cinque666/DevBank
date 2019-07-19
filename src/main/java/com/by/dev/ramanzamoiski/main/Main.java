package com.by.dev.ramanzamoiski.main;

import com.by.dev.ramanzamoiski.bean.User;
import com.by.dev.ramanzamoiski.dao.UserDAO;

public class Main {

    public static void main(String[] args) {
        UserDAO userDao = UserDAO.INSTANCE;
        User user = new User("Raman", "Zamoiski");
        userDao.add(user);
    }
}
