package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUUD_1 = "uuid1";
    private static final String UUUD_2 = "uuid2";
    private static final String UUUD_3 = "uuid3";
    private static final String UUUD_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
            RESUME_1 = new Resume(UUUD_1);
            RESUME_2 = new Resume(UUUD_2);
            RESUME_3 = new Resume(UUUD_3);
            RESUME_4 = new Resume(UUUD_4);
    }

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        collection.add(RESUME_4);

        for (Resume r : collection) {
            System.out.println(r);
        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            if (Objects.equals(resume.getUuid(), UUUD_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put(UUUD_1, RESUME_1);
        map.put(UUUD_2, RESUME_2);
        map.put(UUUD_3, RESUME_3);
    }
}
