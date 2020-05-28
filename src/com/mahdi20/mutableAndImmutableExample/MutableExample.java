package com.mahdi20.mutableAndImmutableExample;

public class MutableExample {

    private String name;

    MutableExample(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // this setter can modify the name
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        MutableExample obj = new MutableExample("mehdi");
        System.out.println(obj.getName());

        // update the name, this object is mutable
        obj.setName("new mehdi");
        System.out.println(obj.getName());

    }
}