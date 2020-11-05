package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index <= -1) {
            index = -(index) - 1;
            if (size < storage.length) {
                remap(index, false);
                storage[index] = resume;
                size++;
            } else {
                System.out.println("Error. storage is crowded.");
            }
        } else {
            System.out.printf("Error. Resume with UUID: %s already exists in storage.\n", resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.printf("Error. Resume with UUID: %s not found in storage.\n", uuid);
        } else {
            remap(index, true);
            size--;
        }
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

