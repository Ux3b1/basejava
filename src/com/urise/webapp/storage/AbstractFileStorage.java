package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> implements FilePathStorage{
    protected File directory;
    private int size;

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    public AbstractFileStorage(String dir) {
        Objects.requireNonNull(dir, "directory must not be null");
        File incomingDirectory = new File(dir);
        if (!incomingDirectory.isDirectory()) {
            throw new IllegalArgumentException(incomingDirectory.getAbsolutePath() + "is not directory");
        }
        if (!incomingDirectory.canRead() || !incomingDirectory.canWrite()) {
            throw new IllegalArgumentException(incomingDirectory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = incomingDirectory;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doSave(Resume resume, File file) {
        boolean isCreated = false;
        try {
            isCreated = file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), resume.getUuid(), e);
        }
        if (isCreated) {
            doUpdate(resume, file);
            size++;
        }
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
        size--;
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = directory.listFiles();

        if (files == null) {
            throw new StorageException("Directory read error", null);
        }

        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            doDelete(file);
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
}
