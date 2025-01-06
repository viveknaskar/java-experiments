package com.javaexperiments;

/**
 *  An illustration of user defined generics method
 */
public class GenericsMethod {

    // Created a generic method of type T
      static <T> void printValue(T obj) {
        System.out.println(obj.getClass().getName()+ " ===> " +obj);
    }

    public static void main(String[] args) {

         // Integer
        printValue(1);

        // String
        printValue("Java is awesome!");

    }
}



