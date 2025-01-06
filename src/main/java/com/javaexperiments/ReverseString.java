package com.javaexperiments;

/**
 * Java program to Reverse a String by converting string to characters one by one
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "JAVA IS AWESOME";

        // convert String to character array by using toCharArray
        char[] charArray = str.toCharArray();

        for (int i = charArray.length-1; i>=0; i--)
            System.out.print(charArray[i]);

    }
}
