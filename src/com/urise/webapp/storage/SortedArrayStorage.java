package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(int index, Resume resume) {
        index = -(index) - 1;
        remap(index, false);
        storage[index] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        remap(index, true);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, Comparator.comparing(Resume::getUuid));
    }

    private void remap(int index, boolean delete) {
        if (delete) {
            if (size - 1 - index >= 0)
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        } else {
            if (size - index >= 0) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
        }
    }
}

