package com.javaexperiments;

import java.io.*;

/**
 * Preventing the breaking of SingletonPattern due to Deserialization
 * by implementing readResolve() to return the current instance
 */
public class SingletonDeserializationPreventExample implements Serializable {

    private static SingletonDeserializationPreventExample single_instance = null;

    /**
     * Making the constructor as private
     */
    private SingletonDeserializationPreventExample() {

    }

    /**
     * Static method to create instance of Singleton class
     * @return single object of 'SingletonDeserializationExample' class
     */
    public static SingletonDeserializationPreventExample getInstance() {
        /**
         * Ensuring only one instance is created
         */
        if (single_instance == null)
            single_instance = new SingletonDeserializationPreventExample();
        return single_instance;
    }

    /**
     * Overriding the readResolve method to return the current instance
     * thereby preventing the new object creation
     */
    protected Object readResolve() {
        return SingletonDeserializationPreventExample.getInstance();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * Serializing the object into byte stream and saving into a file
         */
        SingletonDeserializationPreventExample objectOne = SingletonDeserializationPreventExample.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(objectOne);
        out.close();

        /**
         * Deserializing the byte-stream from the file into a new object
         */
        ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
        SingletonDeserializationPreventExample objectTwo = (SingletonDeserializationPreventExample) in.readObject();
        in.close();

        /**
         * Checking the hashCode for both the objects which would be same,
         * meaning the objects are same
         */
        System.out.println("Hashcode of Object 1 - " + objectOne.hashCode());
        System.out.println("Hashcode of Object 2 - " + objectTwo.hashCode());

    }

}
