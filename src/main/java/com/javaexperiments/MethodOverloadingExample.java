package com.javaexperiments;

public class MethodOverloadingExample {
    /**
     * Method Overloading is basically same method name but with different method signature
     */

    public static void main(String[] args) {

        int rating = calculateScore("Bruce Wayne", 300);
        System.out.println("The player 1 rating is " + rating);

        int ratingUnnamed = calculateScore(500);
        System.out.println("The player 2 rating is " + ratingUnnamed);

        int ratingZero = calculateScore();
        System.out.println("The player 3 rating is " + ratingZero);

    }

    public static int calculateScore(String name, int score) {
        System.out.println("Player " + name + " scored " + score);
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score);
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No score ");
        return 0;
    }

}
