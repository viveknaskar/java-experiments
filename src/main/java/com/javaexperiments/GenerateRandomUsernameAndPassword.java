package com.javaexperiments;

import java.security.SecureRandom;
import java.util.Random;

public class GenerateRandomUsernameAndPassword {
    public static void main(String[] args) throws IllegalAccessException {
        generateRandomPassword(20); // Generate password using Random
        generateRandomPwd(20);     // Generate password using SecureRandom
    }

    /**
     * Generates a random password of the specified length using java.util.Random.
     * This method uses ASCII code points for characters.
     *
     * @param length Length of the password to generate.
     */
    static void generateRandomPassword(int length) {
        String password = new Random().ints(33, 122) // Generate random ASCII values for printable characters
                .filter(Character::isLetterOrDigit) // Include only alphanumeric characters
                .limit(length) // Limit the number of characters to the specified length
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println("Random password: " + password);
    }

    /**
     * Generates a secure random password of the specified length using java.security.SecureRandom.
     * Includes uppercase, lowercase, and numeric characters.
     *
     * @param length Length of the password to generate.
     * @return Generated secure password as a String.
     * @throws IllegalAccessException If the specified length is non-positive.
     */
    static String generateRandomPwd(int length) throws IllegalAccessException {
        if (length <= 0) {
            throw new IllegalAccessException("Password length must be a positive number");
        }

        SecureRandom random = new SecureRandom();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphaNum = upper + lower + digits; // Pool of characters to generate the password

        String password = random.ints(length, 0, alphaNum.length()) // Generate random indices
                .mapToObj(alphaNum::charAt) // Map indices to characters
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println("Random secure password: " + password);
        return password;
    }
}
