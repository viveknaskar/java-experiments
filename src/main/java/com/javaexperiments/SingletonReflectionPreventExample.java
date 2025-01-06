package com.javaexperiments;

import java.lang.reflect.Constructor;

/**
 * Illustration of preventing breakage of Singleton pattern using Reflection API
 */
public class SingletonReflectionPreventExample {
    private static SingletonReflectionPreventExample single_instance = null;

    /**
     * Making the constructor as private
     */
    private SingletonReflectionPreventExample() {
        /**
         * Throwing a run-time exception would prevent Reflection API to create object
         */
        if( single_instance != null ) {
            throw new InstantiationError( "Object creation is not allowed!" );
        }
    }

    /**
     * Static method to create instance of Singleton class
     * @return single object of 'SingletonReflectionPreventExample' class
     */
    public static SingletonReflectionPreventExample getInstance() {
        /**
         * Ensuring only one instance is created
         */
        if (single_instance == null)
            single_instance = new SingletonReflectionPreventExample();
        return single_instance;
    }

    public static void main(String[] args) {

        SingletonReflectionPreventExample objectOne = SingletonReflectionPreventExample.getInstance();

        /**
         * Creating a secondary instance using Reflection API
         */
        SingletonReflectionPreventExample objectTwo = null;
        try {
            Constructor constructor = SingletonReflectionPreventExample.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objectTwo = (SingletonReflectionPreventExample) constructor.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        /**
         * Checking the hashCode for both the objects
         * The hashcode of objectTwo would fail due to InvocationTargetException
         */
        System.out.println("Hashcode of Object 1 - " + objectOne.hashCode());
        System.out.println("Hashcode of Object 2 - " + objectTwo.hashCode());

    }
}
