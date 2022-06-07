package com.springmnv.demo.models;

public class demo {
    public static void main(String[] args) {
        String[] actions = {"jump", "run", "hike"};
        String jump = "jump";
        String hike = new String("hike");
        System.out.print(actions[0] == jump);
        System.out.print(actions[2] == hike);
        System.out.print(actions[2].equals(hike));
    }
}
