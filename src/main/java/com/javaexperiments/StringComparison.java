package com.javaexperiments;

import java.util.Objects;

public class StringComparison {

    public static void main(String[] args) {

        String s1 = "HELLO";
        String s2 = "HELLO";

        System.out.println("Different ways of comparing Strings in Java.");

        System.out.println(" Example 1 - Comparing objects using Objects class of java.util package: " + Objects.equals(s1, s2));
        System.out.println(" Example 2 - Comparing strings using equals method: " + s1.equals(s2));
        System.out.println(" Example 3 - Comparing strings using equalsIgnoreCase method: " + s1.equalsIgnoreCase(s2));
        System.out.println(" Example 4 - Comparing strings using compareTo() method: " + s1.compareTo(s2));

        System.out.println("\n");
        System.out.println("Note: The '==' operand is also used to compare objects to check equality. " +
                "This operand checks if both the objects point to the same memory location or not.");
        System.out.print(" The '==' will give : ");
        System.out.println(s1 == s2);

    }
}
