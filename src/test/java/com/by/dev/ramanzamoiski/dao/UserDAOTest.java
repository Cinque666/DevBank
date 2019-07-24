package com.by.dev.ramanzamoiski.dao;

import com.by.dev.ramanzamoiski.bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    private UserDAO objectUnderTest;

    @Before
    public void setUp() throws Exception {
        objectUnderTest = UserDAO.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        objectUnderTest = null;
    }

    @Test
    public void getAll() {
        List<User> users = objectUnderTest.getAll();

        assertEquals(10, users.size());
    }

    @Test
    public void getAll1(){
        List<User> users = objectUnderTest.getAll();

        assertNotEquals(9, users.size());
    }
}