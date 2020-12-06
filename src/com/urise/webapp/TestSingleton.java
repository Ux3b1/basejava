package com.urise.webapp;

import java.util.Arrays;
import java.util.Comparator;

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
        String [] arr= {"Chop", "your", "own", "wood", "and", "it", "will", "warm", "you", "twice"};
//        System.out.println(sortByLength(arr));
        System.out.println("====");
        System.out.println(arr == sortByLength(null));
    }

    public static String[] sortByLength (String[] arr)  {
        return Arrays.stream(arr).sorted(Comparator.comparing(String::length)).toArray(String[]::new);
    }
}