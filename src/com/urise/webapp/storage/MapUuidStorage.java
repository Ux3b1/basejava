package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected void doUpdate(Resume resume, String index) {
        resumeMap.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, String searchKey) {
        resumeMap.put(searchKey, resume);
    }

    @Override
    protected void doDelete(String searchKey) {
        resumeMap.remove(searchKey);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return resumeMap.get(searchKey);
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(resumeMap.values());
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String searchKey) {
        return resumeMap.containsKey(searchKey);
    }
}
