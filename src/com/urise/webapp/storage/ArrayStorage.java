package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveResumeArray(int index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage[index];
    }

    @Override
    protected void deleteResumeArray(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
