package com.javaexperiments;

import java.util.Scanner;
public class IntegerToString {
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();
            // Method 1: Using Integer.toString()
            // String s = Integer.toString(n);

            // Method 2: Using String.valueOf()
            String s = String.valueOf(n);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}