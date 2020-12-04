package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("./gitignore");
        System.out.println(file.getCanonicalPath());
        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.getCanonicalPath());
        System.out.println(dir.isDirectory());
        printDirectoryDepply(dir);
    }

    public static void printDirectoryDepply(File dir) {
        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("./Directory: " + file.getName());
                printDirectoryDepply(file);
            } else {
                System.out.println("--File: " + file.getName());
            }
        }
    }
}
