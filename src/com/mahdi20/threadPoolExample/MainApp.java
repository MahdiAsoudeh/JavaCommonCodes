package com.mahdi20.threadPoolExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {


    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 item: " + i);
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2 item: " + i);
            }
        });

        // dige thread add nemishe ta inja base
        executor.shutdown();


    }

}