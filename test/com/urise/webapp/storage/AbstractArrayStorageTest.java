package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUUD_1 = "uuid1";
    private static final String UUUD_2 = "uuid2";
    private static final String UUUD_3 = "uuid3";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUUD_1));
        storage.save(new Resume(UUUD_2));
        storage.save(new Resume(UUUD_3));
    }

    @Test
    public void clear() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void size() {
        System.out.println("Expected: " + 3);
        System.out.println("Actual: " + storage.size());
        Assert.assertEquals(3,storage.size());
    }
}