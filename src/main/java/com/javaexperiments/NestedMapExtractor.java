package com.javaexperiments;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Utility class for safely accessing nested Map structures.
 * Ideal for processing dynamic data such as JSON payloads.
 */
public class NestedMapExtractor {

    /**
     * Safely extract a nested map from a parent map.
     *
     * @param map the parent map
     * @param key the key whose value should be a nested map
     * @return the nested map if present and valid, otherwise an empty map
     */
    public static Map<String, Object> get(Map<?, ?> map, String key) {
        if (map == null) return new HashMap<>();

        return Optional.ofNullable(key)
                .map(map::get)
                .filter(Map.class::isInstance)
                .map(value -> {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> nested = (Map<String, Object>) value;
                    return nested;
                })
                .orElse(new HashMap<>());
    }

    /**
     * Safely extract a value of a specific type from a map.
     *
     * @param map   the map to extract from
     * @param key   the key to look up
     * @param clazz the expected type class
     * @param <T>   the type of the value
     * @return the value if present and of the correct type, otherwise null
     */
    public static <T> T get(Map<String, Object> map, String key, Class<T> clazz) {
        if (map == null || key == null || clazz == null) return null;

        Object value = map.get(key);
        if (clazz.isInstance(value)) {
            return clazz.cast(value);
        }
        return null;
    }

    /**
     * Retrieves a String value from a nested "Something" map within the payload.
     *
     * @param payload the top-level payload map
     * @param key     the key inside the "Something" context
     * @return the string value, or null if missing or not a string
     */
    public static String getFromContext(Map<String, Object> payload, String key) {
        Map<String, Object> context = get(payload, "Something");
        return get(context, key, String.class);
    }

    /**
     * Demonstrates usage of the utility methods with various scenarios.
     */
    public static void main(String[] args) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("username", "bruce.wayne");
        userDetails.put("email", "brucewayne@google.com");
        userDetails.put("accessLevel", 2);

        Map<String, Object> payload = new HashMap<>();
        payload.put("Something", userDetails);

        // Example 1: Expected string
        String username = getFromContext(payload, "username");
        System.out.println("Username: " + username); // bruce.wayne

        // Example 2: Type mismatch
        String accessLevel = getFromContext(payload, "accessLevel");
        System.out.println("AccessLevel (as String): " + accessLevel); // null

        // Example 3: Missing key
        String nonExistent = getFromContext(payload, "nonExistentKey");
        System.out.println("Non-existent key: " + nonExistent); // null
    }

}
