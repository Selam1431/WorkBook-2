package com.pluralsight.collection;
import java.util.ArrayList;

public class FixedList<T> {
    private ArrayList<T> items;
    private int maxSize;



    public FixedList( int maxSize) {
        this.items = new ArrayList<>();
        this.maxSize = maxSize;
    }
    public void add(T item) {
        if (items.size() < maxSize) {
            items.add(item);
        } else {
            System.out.println("List is full.");
        }
    }
    public ArrayList<T> getItems() {
        return new ArrayList<>(items);
    }

}
