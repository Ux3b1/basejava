package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        resumeMap.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        resumeMap.put((String) searchKey, resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumeMap.remove(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumeMap.get(searchKey);
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
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(resumeMap.values());
        list.sort(Comparator.comparing(Resume::getUuid));
        return list;
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return resumeMap.containsKey(searchKey);
    }
}
