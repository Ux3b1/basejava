package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
//        static final Storage ARRAY_STORAGE = new ArrayStorage();
    static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {

        Resume r1 = new Resume("uuid1", "Name1");
        Resume r2 = new Resume("uuid2", "Name2");
        Resume r3 = new Resume("uuid3", "Name3");
        Resume r4 = new Resume("uuid4", "Name4");

        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r2);

        printAll();
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        Resume r5 = new Resume("uuid1", "Name1");
        ARRAY_STORAGE.update(r5);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r5.getUuid()));

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        System.out.println(ARRAY_STORAGE.size());
        ARRAY_STORAGE.delete(r2.getUuid());
        printAll();
        System.out.println(ARRAY_STORAGE.size());
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
