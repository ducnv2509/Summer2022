package com.example.lab34.entity;

public enum TypeRole {
    ADMIN(0), CUSTOMER(1);
    private final int value;
    TypeRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
