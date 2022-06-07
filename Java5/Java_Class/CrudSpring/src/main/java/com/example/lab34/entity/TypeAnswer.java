package com.example.lab34.entity;

public enum TypeAnswer {
    A(0), B(1), C(2), D(3);

    private final int value;

    TypeAnswer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
