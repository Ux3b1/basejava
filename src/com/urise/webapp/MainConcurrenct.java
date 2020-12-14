package com.urise.webapp;

public class MainConcurrenct {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        }.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
