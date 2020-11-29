package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }


    @Override
    protected void doUpdate(Resume r, Resume resume) {
        resumeMap.replace(r.getUuid(), r);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        resumeMap.remove(resume.getUuid());
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
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
    protected Resume getSearchKey(String uuid) {
        return resumeMap.get(uuid);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }
}
