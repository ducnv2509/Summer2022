package com.example.lab34.entity;

public enum TypeStatus {
    PRIVATE(0),
    PUBLIC(1);
    private final int value;
    TypeStatus(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
