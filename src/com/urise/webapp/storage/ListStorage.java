package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return resumeList.get(index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        resumeList.set(index, resume);
    }

    @Override
    protected void saveResume(int index, Resume resume) {
        resumeList.add(resume);
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        resumeList.remove(index);
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[0]);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
