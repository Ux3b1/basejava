package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {
    List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    protected void doUpdate(Resume resume, Integer index) {
        resumeList.set(index, resume);
    }

    @Override
    protected void doSave(Resume resume, Integer index) {
        resumeList.add(resume);
    }

    @Override
    protected Resume doGet(Integer index) {
        return resumeList.get(index);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        resumeList.remove(searchKey.intValue());
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(resumeList);
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }
}
