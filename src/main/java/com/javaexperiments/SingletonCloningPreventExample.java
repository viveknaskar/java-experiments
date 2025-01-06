package com.javaexperiments;

/**
 * By explicitly throwing CloneNotSupported exception from the clone()
 * would prevent object creation the second time, thereby preventing
 * the breaking of Singleton Pattern
 */
public class SingletonCloningPreventExample extends SuperCloneableClass {

    private static SingletonCloningPreventExample single_instance = null;

    // Making the constructor as private
    private SingletonCloningPreventExample() {
    }

    /**
     * Static method to create instance of Singleton class
     *
     * @return single object of 'SingletonCloningExample' class
     */
    public static SingletonCloningPreventExample getInstance() {
        // Ensuring only one instance is created
        if (single_instance == null) single_instance = new SingletonCloningPreventExample();
        return single_instance;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        // Instantiating SingletonCloningExample class with variable 'objectOne'
        SingletonCloningPreventExample objectOne = SingletonCloningPreventExample.getInstance();

        // Cloning the 'objectOne' using clone()
        SingletonCloningPreventExample objectTwo = (SingletonCloningPreventExample) objectOne.clone();

        /**
         * Checking the hashCode for both the objects which would be same,
         * meaning the objects are same
         */
        System.out.println("Hashcode of Object 1 - " + objectOne.hashCode());
        System.out.println("Hashcode of Object 2 - " + objectTwo.hashCode());
    }

    // Override the clone() to throw the same instance
    @Override
    protected Object clone() {
        return single_instance;
    }

}

class SuperCloneableClass implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
