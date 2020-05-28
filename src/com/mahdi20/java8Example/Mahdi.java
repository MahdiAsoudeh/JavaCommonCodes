package com.mahdi20.java8Example;


@FunctionalInterface
public interface Mahdi {

    void a();

    default String b() {
        return "hooooo";
    }

}
