package com.javaexperiments;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingNumberOfCharactersInAWord {

    public static void main(String[] args) {
        String input = "java is my favourite language";

        Map<String, Long> map = Arrays.stream(input.trim().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

}
