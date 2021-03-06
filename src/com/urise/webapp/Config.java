package com.urise.webapp;

import com.urise.webapp.storage.SqlStorage;
import com.urise.webapp.storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String FILE_NAME = String.format("%sconfig%sresumes.properties", File.separator, File.separator);
    private static final File PROPS = new File(getHomeDir(),FILE_NAME);
    private static final Properties props = new Properties();
    private static final Config INSTANCE = new Config();
    private final File storageDir;
    private final Storage storage;

    public static Config getInstance() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream inputStream = new FileInputStream(PROPS)) {
            props.load(inputStream);
            storageDir = new File(props.getProperty("storage.dir"));
            storage = new SqlStorage(props.getProperty("db.url"),
                                    props.getProperty("db.user"),
                                    props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file" + PROPS.getAbsolutePath());
        }
    }

    public File getStorageDir() {
        return storageDir;
    }

    public Storage getStorage() {
        return storage;
    }

    private static File getHomeDir() {
        String prop =  System.getProperty("homeDir");
        File homeDir = new File(prop == null ? "." : prop);
        if (!homeDir.isDirectory()) {
            throw new IllegalStateException(homeDir + " is not directory");
        }
        return homeDir;
    }
}
