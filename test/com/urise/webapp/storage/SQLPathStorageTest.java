package com.urise.webapp.storage;

import com.urise.webapp.Config;

import java.sql.SQLException;

public class SQLPathStorageTest extends AbstractStorageTest {
    public SQLPathStorageTest() throws SQLException {
        super(Config.getInstance().getStorage());
    }
}