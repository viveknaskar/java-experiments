package com.javaexperiments;

import java.lang.reflect.Constructor;

/**
 * Using ReflectionAPI, we can create more than one instance in a Singleton class
 */
public class SingletonReflectionExample {
    private static SingletonReflectionExample single_instance = null;

    /**
     * Making the constructor as private
     */
    private SingletonReflectionExample() {}

    /**
     * Static method to create instance of Singleton class
     * @return single object of 'SingletonReflectionExample' class
     */
    public static SingletonReflectionExample getInstance() {
        /**
         * Ensuring only one instance is created
         */
        if (single_instance == null)
            single_instance = new SingletonReflectionExample();
        return single_instance;
    }

    public static void main(String[] args) {

        SingletonReflectionExample objectOne = SingletonReflectionExample.getInstance();

        /**
         * Creating a second instance using Reflection API
         */
        SingletonReflectionExample objectTwo = null;
        try {
            Constructor constructor = SingletonReflectionExample.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objectTwo = (SingletonReflectionExample) constructor.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        /**
         * Checking the hashCode for both the objects which would be different,
         * meaning the objects are different
         */
        System.out.println("Hashcode of Object 1 - " + objectOne.hashCode());
        System.out.println("Hashcode of Object 2 - " + objectTwo.hashCode());

    }
}
