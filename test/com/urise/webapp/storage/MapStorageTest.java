package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapStorageTest {
    private Storage storage = new MapStorage();

    private static final String UUUD_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUUD_1);
    private static final String UUUD_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUUD_2);
    private static final String UUUD_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUUD_3);
    private static final String UUUD_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUUD_4);

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    public void update() {
        Resume resume = new Resume("uuid1");
        Resume resume1 = storage.get("uuid1");
        storage.update(resume);
        Assert.assertEquals(resume, resume1);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUUD_1);
        assertSize(2);
        storage.get(UUUD_1);
    }

    @Test
    public void getAll() {
        Resume[] result = storage.getAll();
        assertEquals(3, result.length);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}