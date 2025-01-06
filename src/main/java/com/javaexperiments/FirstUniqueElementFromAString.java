package com.javaexperiments;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueElementFromAString {

    public static void main(String[] args) {

        String phrase = "lifeisgreatandcodingisthebest";

        String firstUniqueElement = Arrays.stream(phrase.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();

        System.out.println("The first unique element is: " + firstUniqueElement);
    }
}
