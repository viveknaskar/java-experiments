package com.javaexperiments;

import java.util.Arrays;
import java.util.Comparator;

public class FindingSecondHighestNumberInArray {

    public static void main(String[] args) {

        int[] numbersList = {3, 7, 1, 43, 24, 62, 2, 31};

        Integer secondHighestElement = Arrays.stream(numbersList)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("Second highest element: " + secondHighestElement);
    }
}
