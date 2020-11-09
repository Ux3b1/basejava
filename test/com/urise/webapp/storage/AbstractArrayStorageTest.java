package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUUD_1 = "uuid1";
    private static final String UUUD_2 = "uuid2";
    private static final String UUUD_3 = "uuid3";
    private static final String UUUD_4 = "uuid4";
    private static final String UUUD_5 = "uuid5";

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUUD_1));
        storage.save(new Resume(UUUD_2));
        storage.save(new Resume(UUUD_3));
        storage.save(new Resume(UUUD_4));
        storage.save(new Resume(UUUD_5));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        Resume resume = new Resume("uuid_test");
        storage.save(resume);
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test(expected = StorageException.class)
    public void overFlowStorage() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException thrown) {
            Assert.fail("Exception expected before main test.");
        }
        storage.save(new Resume());
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
        Assert.assertEquals(new Resume(UUUD_1), storage.get(UUUD_1));
        Assert.assertEquals(new Resume(UUUD_2), storage.get(UUUD_2));
        Assert.assertEquals(new Resume(UUUD_3), storage.get(UUUD_3));
        Assert.assertEquals(new Resume(UUUD_4), storage.get(UUUD_4));
        Assert.assertEquals(new Resume(UUUD_5), storage.get(UUUD_5));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        String uuid = "uuid_test";
        storage.save(new Resume(uuid));
        storage.delete(uuid);
        storage.get(uuid);
    }

    @Test
    public void getAll() {
        Assert.assertEquals(5, storage.getAll().length);
    }

    @Test
    public void size() {
        Assert.assertEquals(5, storage.size());
    }
}