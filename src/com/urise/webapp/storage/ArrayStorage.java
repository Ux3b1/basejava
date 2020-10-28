package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (resumeNotPresent(resume.uuid)) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", resume.uuid);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                storage[i] = resume;
            }
        }
    }

    public void save(Resume resume) {
        if (resumeNotPresent(resume.uuid)) {
            if (size < storage.length) {
                storage[size++] = resume;
            } else {
                System.out.println("Error. storage is crowded.");
            }
        } else {
            update(resume);
        }
    }

    public Resume get(String uuid) {
        if (resumeNotPresent(uuid)) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", uuid);
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (resumeNotPresent(uuid)) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", uuid);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    private boolean resumeNotPresent(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
