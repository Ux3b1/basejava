package com.urise.webapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainFile {
    public static void main(String[] args) throws IOException {
/*        File file = new File("./gitignore");
        System.out.println(file.getCanonicalPath());
        File dir = new File("./src/com/urise");
        System.out.println(dir.getCanonicalPath());
        System.out.println(dir.isDirectory());
        printDirectoryDepply(dir, "");*/
        System.out.println(minValue(new int[]{1, 2, 3, 3, 2, 3}));
        System.out.println(minValue(new int[]{9, 8}));
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

    public static int minValue(int[] values) {
        String uniqueValuesLine = Arrays.stream(values)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        return Integer.parseInt(uniqueValuesLine);
    }

    List<Integer> oddOrEven(List<Integer> integers) {
        Objects.requireNonNull(integers);
        List<Integer> oddIntegers = new ArrayList<>();
        List<Integer> evenIntegers = new ArrayList<>();
        int sumOfAllIntegers = 0;
        for (Integer integer : integers) {
            sumOfAllIntegers += integer;
            if (integer % 2 == 0) {
                evenIntegers.add(integer);
            } else {
                oddIntegers.add(integer);
            }
        }
        if (sumOfAllIntegers % 2 == 0) {
            return oddIntegers;
        } else {
            return evenIntegers;
        }
    }

//    public static @NotNull List<Integer> oddOrEven2(List<Integer> integers) {
//        Map<Boolean, List<Integer>> map = integers.stream()
//                .collect(Collectors.partitioningBy(element -> element % 2 == 0));
//    }
}
