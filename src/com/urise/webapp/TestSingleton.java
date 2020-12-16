package com.urise.webapp;

public class TestSingleton {
    private static TestSingleton instance;

    private TestSingleton() {
    }

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}