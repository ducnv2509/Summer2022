package com.example.class3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
       String message = "Hello";
        print(message);
        message += "World!";
        print(message);
    }

    static void print(String meeee) {
        System.out.print(meeee);
        meeee += "";
    }
}
