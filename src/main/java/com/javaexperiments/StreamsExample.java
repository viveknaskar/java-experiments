package com.javaexperiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
    /**
     * Streams have been introduced from Java 8 and is used basically to perform operations on a
     * collection of objects
     */

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Microsoft");
        list.add("Google");
        list.add("Tesla");
        list.add("Amazon");

        /**
         *  Traditional Approach: Without Streams, we needed to iterate over the collection
         *  then do a conditional check and then count
         */

        int countWithoutUsingStreams = 0;

        for (String num : list) {
            if(num.length() > 5) {
                countWithoutUsingStreams ++;
            }
        }
        System.out.println("Count Without Using Streams: " + countWithoutUsingStreams);

        /**
         * Streams incorporate something called Parallel execution
         *  of Operations which drastically improves the performance of the code.
         *  Iteration, Filtering and Counting occur in parallel
         */

        long countUsingStreams = list.stream().filter(num -> num.length() > 5).count();
        System.out.println("Count Using Streams: " + countUsingStreams);

        /**
         * ********************* MORE STREAM EXAMPLES ************************
         */

        // Example 1: This would print 1-9 in the console
        IntStream
                .range(1, 10) // .range(inclusiveNum, exclusiveNum)
                .forEach(System.out::print);
        System.out.println();

        // Example 2: IntStream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::print);
        System.out.println();

       // Example 3: IntStream with sum()
        int sumOfNumbers =
                    IntStream
                            .range(1, 5)
                            .sum();
        System.out.println(sumOfNumbers);

        // Example 4: Stream.of with sorted() and findFirst()
        Stream.of("Vivek", "Abi", "Anoop", "Arun")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);
        System.out.println();

        // Example 5: Stream from Array, sort, filter
        String[] names = {"Bruce", "Tony" , "Banner", "Sebastian", "Bertha"};
        Arrays.stream(names)
                .filter(s -> s.startsWith("B"))
                .sorted()
                .forEach(System.out::println);

        // Example 6: Average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::print);
        System.out.println();

        // Example 7: Stream from List, filter and print
        List<String> people = Arrays.asList("Bruce", "Tony" , "Banner", "Sebastian", "Bertha", "Spyder");
        people
            .stream()
            .map(String::toUpperCase)
            .filter(x -> x.startsWith("S"))
            .forEach(System.out::println);

       // Example 8: Reduction and Sum
        double total = Stream.of(7.3, 6.4, 34.6)
                .reduce(0.0, Double::sum);
        System.out.println(total);


       // Example 9: Reduction and Sum
        IntSummaryStatistics summary = IntStream.of(12, 4, 46, 8, 10, 76, 34)
                .summaryStatistics();
        System.out.println(summary);
        // Output is: IntSummaryStatistics{count=7, sum=190, min=4, average=27.142857, max=76}

    }
}
