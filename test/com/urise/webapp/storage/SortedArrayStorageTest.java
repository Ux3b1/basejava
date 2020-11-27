package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class SortedArrayStorageTest extends AbstractStorageTest {
    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
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
}