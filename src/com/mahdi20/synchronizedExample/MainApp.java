package com.mahdi20.synchronizedExample;

public class MainApp {


    public void readFromHard(String name) {

        synchronized (this) {

            System.out.println(name + " reading from hard...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " read success!");

        }

    }

    public void runThreads() {

        Thread th1 = new Thread(() -> {
            readFromHard("th1");
        });

        Thread th2 = new Thread(() -> {
            readFromHard("th2");
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

        new MainApp().runThreads();


    }

}