package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File("./gitignore");
        System.out.println(file.getCanonicalPath());
        File dir = new File("./src/com/urise");
        System.out.println(dir.getCanonicalPath());
        System.out.println(dir.isDirectory());
        printDirectoryDepply(dir, "");
    }

    public static void printDirectoryDepply(File dir, String offset) {
        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(offset + "D: " + file.getName());
                printDirectoryDepply(file, offset + "  ");
            } else {
                System.out.println(offset + "F: " + file.getName());
            }
        }
    }
}
