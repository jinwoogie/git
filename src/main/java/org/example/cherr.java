package org.example;

import java.util.Arrays;

public class cherr {
    public static void main(String[] args) {
        String a = "a  b";
        String[] s = a.split(" ");
        for (String string : s) {
            System.out.println(string.trim());
        }
    }
}
