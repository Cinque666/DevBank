package com.by.dev.ramanzamoiski.controller;

import com.by.dev.ramanzamoiski.bean.Account;
import com.by.dev.ramanzamoiski.bean.User;
import com.by.dev.ramanzamoiski.dao.AccountDAO;
import com.by.dev.ramanzamoiski.dao.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/users")
public class Controller extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("get".equals(req.getParameter("getUser"))) {
            User user = UserDAO.INSTANCE.getMaxAccountValue();
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/showUsers.jsp");
            dispatcher.forward(req, resp);
        } else if("get".equals(req.getParameter("getSummary"))){
            if("get".equals(req.getParameter("getSummary")));
            Account account = AccountDAO.INSTANCE.getSummary();
            req.setAttribute("summary", account);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/showSummary.jsp");
            dispatcher.forward(req, resp);
        } else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            LOGGER.error("ServletException init method, Controller class");
        }
    }
}
