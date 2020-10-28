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
        int index = indexOfResume(resume.uuid);
        if (index == -1) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", resume.uuid);
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        int index = indexOfResume(resume.uuid);
        if (index == -1) {
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
        int index = indexOfResume(uuid);
        if (index == -1) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", uuid);
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index == -1) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", uuid);
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    private int indexOfResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
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
