package com.mahdi20.genericExample;

public class GenericExample {

    public static <E> void printArray(E[] inputArray) {

        for (E element : inputArray) {
            System.out.printf("\n%s ", element);
        }

    }

    public static void main(String args[]) {

        // Create arrays of Integer, Double and Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }
}