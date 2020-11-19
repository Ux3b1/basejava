package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return resumeMap.get(uuid);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        resumeMap.replace(resume.getUuid(), resume);
    }


    @Override
    protected void saveResume(int index, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        resumeMap.remove(uuid);
    }


    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    public Resume[] getAll() {
        return resumeMap.values().toArray(new Resume[0]);
    }

    @Override
    protected int getIndex(String uuid) {
        if (resumeMap.containsKey(uuid)) {
            return 0;
        }
        return -1;
    }
}
