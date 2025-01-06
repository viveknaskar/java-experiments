package com.javaexperiments;

public class CountingNumberOfWords {

    public static void main(String[] args) {
        String str = "This This is is Vivek";
        int count = str.split(" ").length;
        System.out.println("count " + count);
    }

}
