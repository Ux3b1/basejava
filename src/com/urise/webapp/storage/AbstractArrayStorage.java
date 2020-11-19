package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        deleteResumeArray(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void saveResume(int index, Resume resume) {
        if (size < storage.length) {
            saveResumeArray(index, resume);
            size++;
        } else {
            throw new StorageException("Error. storage is crowded.", resume.getUuid());
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract void saveResumeArray(int index, Resume resume);

    protected abstract void deleteResumeArray(int index);
}
