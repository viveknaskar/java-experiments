import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/** Finding the longest string in a given array **/

public class FindingLongestStringInArray {

    public static void main(String[] args) {

        String[] elements = {"Vivek", "John", "Mark", "Ty", "Stephen", "Peter"};

        /*
         * There are multiple ways to achieve this
         */

        /*
         Way #1
         */

        String longestElement = Arrays.stream(elements)
                .sorted(Comparator.comparing(s -> s.split("").length))
                .skip(elements.length - 1)
                .collect(Collectors.toList()).get(0);
        System.out.println("Longest element in an array using way #1: " + longestElement);

        /*
         * Way #2: Using reduce()
         */

        String longestElem = Arrays.stream(elements)
                .reduce((string1, string2) -> string1.length() > string2.length() ? string1 : string2)
                .get();
        System.out.println("Longest element in an array using way #2: " + longestElem);

    }
}
