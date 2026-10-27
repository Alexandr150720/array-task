package com.example.arrays.entity;

import java.util.Arrays;

public class CustomArray {

    private int[] elements;

    public CustomArray(int... elements) {
        this.elements = elements.clone();
    }

    public int[] getElements() {
        return elements.clone();
    }

    public void setElements(int... elements) {
        this.elements = elements.clone();
    }

    public int getLength() {
        return elements.length;
    }

    @Override
    public String toString() {
        return "CustomArray" + Arrays.toString(elements);
    }
}
