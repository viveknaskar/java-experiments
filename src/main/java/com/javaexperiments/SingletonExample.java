package com.javaexperiments;

/**
 * Singleton is a design pattern by which you create a singleton class that has only one instance
 * at any time
 */
public class SingletonExample {

    private static SingletonExample single_instance = null;

    public String msg;

    // Making the constructor as private
    private SingletonExample() {
        msg = "Hello World!";
    }

    /**
     * Static method to create instance of Singleton class
     *
     * @return single object of 'SingletonExample' class
     */
    public static SingletonExample getInstance() {
        // Ensuring only one instance is created
        if (single_instance == null) single_instance = new SingletonExample();
        return single_instance;
    }

    public static void main(String[] args) {
        // Instantiating SingletonExample class with variable 'singletonObject'
        SingletonExample singletonObject = SingletonExample.getInstance();
        System.out.println(singletonObject.msg);
    }

}
