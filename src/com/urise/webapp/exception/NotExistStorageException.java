package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Error. Resume with UUID: " + uuid + " not exists in storage.", uuid);
    }
}
