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
        size++;
    }

    @Override
    protected void deleteResume(int index) {
        remap(index, true);
        size--;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, Comparator.comparing(Resume::getUuid));
    }

    private void remap(int index, boolean delete) {
        if (delete) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        } else {
            if (size - index >= 0) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
        }
    }
}

