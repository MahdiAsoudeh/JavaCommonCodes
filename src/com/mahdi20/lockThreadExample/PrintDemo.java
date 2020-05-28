package com.mahdi20.lockThreadExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintDemo {

    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + "  Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s printed the document successfully.\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}