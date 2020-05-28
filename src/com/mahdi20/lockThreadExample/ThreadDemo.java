package com.mahdi20.lockThreadExample;

class ThreadDemo extends Thread {

    PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo printDemo) {
        super(name);
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        System.out.printf("%s starts printing a document\n", Thread.currentThread().getName());
        printDemo.print();
    }
}