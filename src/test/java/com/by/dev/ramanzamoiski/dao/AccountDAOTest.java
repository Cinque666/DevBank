package com.by.dev.ramanzamoiski.dao;

import com.by.dev.ramanzamoiski.bean.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Hardcoded tests to check how many entries the table have
 * Hardcoded.
 * Summary can change and the test will not work.
 *
 */
public class AccountDAOTest {

    private AccountDAO accountDAO;

    @Before
    public void setUp() throws Exception {
        accountDAO = AccountDAO.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        accountDAO = null;
    }

    /**
     * It was 10 24.07.2019
     */
    @Test
    public void getAll() {
        List<Account> accounts = accountDAO.getAll();

        assertEquals(10, accounts.size());
    }

    /**
     * Total account was 1499994 24.07.2019
     * The test demonstrate that method works right.
     */
    @Test
    public void getSummary() {
        assertEquals(1499994, accountDAO.getSummary().getAccount());
    }

    @Test
    public void getSummary1(){
        assertNotEquals(1, accountDAO.getSummary().getAccount());
    }
}