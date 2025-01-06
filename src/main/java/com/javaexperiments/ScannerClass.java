package com.javaexperiments;

import java.util.Scanner;

public class ScannerClass {

    /**
     * Scanner class to take input from user
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (scan.hasNext()) {
            i++;
            System.out.println(i + " " + scan.nextLine());
        }
    }
}

