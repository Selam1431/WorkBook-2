package com.pluralsight.collection;

public class Main {
    static void main(String[] args) {
//        FixedList<Integer> numbers = new FixedList<>(3);
//
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//        numbers.add(40);
//
//        System.out.println(numbers.getItems());

        FixedList<String> names = new FixedList<>(2);
        names.add("sal");
        names.add("dijon");

        System.out.println(names.getItems());
    }
}
