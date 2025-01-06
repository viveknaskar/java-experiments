package com.javaexperiments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueElementFromAString {

    public static void main(String[] args) {

        String phrase = "lifeisgreatandcodingisthebest";

        List<String> uniqueElements = Arrays.stream(phrase.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("The unique elements are: " + uniqueElements);
    }
}
