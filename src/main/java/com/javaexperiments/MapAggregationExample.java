package com.javaexperiments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapAggregationExample {

    public static void main(String[] args) {
        List<Map<String, Object>> products = Arrays.asList(
                createProduct("Laptop", "Electronics", 1200.00),
                createProduct("Mouse", "Electronics", 25.00),
                createProduct("Keyboard", "Electronics", 75.00),
                createProduct("T-Shirt", "Apparel", 20.00),
                createProduct("Jeans", "Apparel", 60.00),
                createProduct("Book - Java", "Books", 45.00),
                createProduct("Book - Design Patterns", "Books", 55.00)
        );

        // Group products by category and calculate the average price for each category
        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        productMap -> (String) productMap.get("category"), // Classifier function
                        Collectors.averagingDouble(productMap -> (Double) productMap.get("price")) // Downstream collector
                ));
        System.out.println("Average price by category:");
        averagePriceByCategory.forEach((category, avgPrice) ->
                System.out.printf("  %s: $%.2f%n", category, avgPrice)
        );
    }

    private static Map<String, Object> createProduct(String name, String category, Double price) {
        Map<String, Object> product = new java.util.HashMap<>();
        product.put("name", name);
        product.put("category", category);
        product.put("price", price);
        return product;
    }
}
