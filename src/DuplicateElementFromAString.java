import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElementFromAString {

    public static void main(String[] args) {

        String phrase = "life is great and coding is the best";

        findDuplicateElements (phrase);
    }

    /**
     * Finds and prints duplicate elements from a given string.
     * Spaces are excluded from the computation.
     *
     * @param phrase The input string to analyze.
     */
    private static void findDuplicateElements (String phrase) {
        List<String> duplicateElements = Arrays.stream(phrase.split(""))
                .filter(character -> !character.isBlank()) // Exclude spaces or blank characters
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) //Function.identity() uses the characters themselves as keys
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // Filter elements with count > 1 (duplicates)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();

        System.out.println("The duplicate elements are: " + duplicateElements);
    }

}
