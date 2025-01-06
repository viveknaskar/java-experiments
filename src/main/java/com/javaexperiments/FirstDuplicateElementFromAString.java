package com.javaexperiments;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstDuplicateElementFromAString {

    public static void main(String[] args) {
        String phrase = "this is the best day of my life";

        // Find the first duplicate element
        Optional<String> firstDuplicateElement = findFirstDuplicateElement(phrase);

        // Output the result
        if (firstDuplicateElement.isPresent()) {
            System.out.println("The first duplicate element: " + firstDuplicateElement.get());
        } else {
            System.out.println("No duplicate elements found.");
        }
    }

    /**
     * Finds the first duplicate character in a given string.
     * Spaces are excluded, and the search is case-sensitive.
     *
     * @param phrase The input string.
     * @return An Optional containing the first duplicate character, or empty if no duplicates exist.
     */
    private static Optional<String> findFirstDuplicateElement(String phrase) {
        if (phrase == null || phrase.isBlank()) {
            return Optional.empty(); // Handle null or empty strings gracefully
        }

        return Arrays.stream(phrase.trim().split(""))
                .filter(character -> !character.isBlank()) // Exclude spaces
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // Find elements with more than one occurrence
                .map(entry -> entry.getKey()) // Extract the key (character)
                .findFirst(); // Return the first match, wrapped in an Optional
    }
}
