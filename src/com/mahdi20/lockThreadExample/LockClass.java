package com.mahdi20.lockThreadExample;

public class LockClass {

    public static void main(String[] args) {

        PrintDemo PD = new PrintDemo();
        ThreadDemo t1 = new ThreadDemo("Thread - 1 ", PD);
        ThreadDemo t2 = new ThreadDemo("Thread - 2 ", PD);
        ThreadDemo t3 = new ThreadDemo("Thread - 3 ", PD);
        ThreadDemo t4 = new ThreadDemo("Thread - 4 ", PD);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}



