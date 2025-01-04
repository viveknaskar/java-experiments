import java.util.Arrays;

/**
 * Demonstrates finding the maximum and minimum values in an array using
 * both traditional and Java 8 Stream API approaches.
 */
public class FindingMaxInJava8 {

    public static void main(String[] args) {

        int arr[] = {61, 54, 23, 5, 23};

        /*
         * Using Traditional Approach
         * - Iterates through the array to find the maximum and minimum values manually.
         */
        int maxim = arr[0]; // Initialize maximum with the first element
        int minim = arr[0]; // Initialize minimum with the first element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxim) { // If current element is greater than the maximum
                maxim = arr[i];
            } else if (arr[i] < minim) { // If current element is smaller than the minimum
                minim = arr[i];
            }
        }

        System.out.println("Maximum number (Without Stream) is " + maxim);
        System.out.println("Minimum number (Without Stream) is " + minim);

        /*
         * Using Java 8 Stream API
         * - Streams provide a functional approach to process data.
         */
        // Find the maximum value using stream
        int max = Arrays.stream(arr).max().getAsInt();
        // Find the minimum value using stream
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println("Maximum number (With Stream) is " + max);
        System.out.println("Minimum number (With Stream) is " + min);
    }
}
