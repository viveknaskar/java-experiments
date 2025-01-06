package com.javaexperiments;

/*
* A simple program to demonstrate user-defined generics
*
*  Generics allow type (Integer, String, … etc and user defined types) to be
*  a parameter to methods, classes and interfaces.
* */
public class GenericsExample {

    public static void main(String[] args) {

        UserDefinedGenericClass<Integer> intObj = new UserDefinedGenericClass<>(100);
        System.out.println("*****Generics instance type for Integer****** " + intObj.getObj());

        UserDefinedGenericClass<Double> doubleObj = new UserDefinedGenericClass<>(100.0);
        System.out.println("*****Generics instance type for Double****** " + doubleObj.getObj());

        UserDefinedGenericClass<String> stringObj = new UserDefinedGenericClass<>("Generics is awesome");
        System.out.println("*****Generics instance type for String****** " + stringObj.getObj());

    }

}


class UserDefinedGenericClass<T> {
    // An object of type T
    T obj;

    // Constructor
     UserDefinedGenericClass(T obj) {
        this.obj = obj;
    }

    // Getter method
    public T getObj() {
        return obj;
    }
}
