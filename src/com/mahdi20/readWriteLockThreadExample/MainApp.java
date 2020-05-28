package com.mahdi20.readWriteLockThreadExample;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainApp {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static String number = "0";

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Reader(), "Thread 1");
        Thread t2 = new Thread(new Reader(), "Thread 2");
        Thread t3 = new Thread(new WriterOdd(), "Write odd Thread");
        Thread t4 = new Thread(new WriterEven(), "Write even Thread");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

    static class Reader implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " ---> Number is " + number);
                lock.readLock().unlock();
            }
        }
    }

    static class WriterOdd implements Runnable {

        public void run() {
            for (int i = 1; i <= 7; i += 2) {
                try {
                    lock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + "\t" + "Writer odd is writing");
                    number = number.concat(" " + i);
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }

    static class WriterEven implements Runnable {

        public void run() {
            for (int i = 2; i <= 8; i += 2) {
                try {
                    lock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + "\t" + "Writer Even is writing");
                    number = number.concat(" " + i);
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }
}