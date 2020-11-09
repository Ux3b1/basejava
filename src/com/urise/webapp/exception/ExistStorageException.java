package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Error. Resume with UUID: " + uuid + " already exists in storage.", uuid);
    }
}
