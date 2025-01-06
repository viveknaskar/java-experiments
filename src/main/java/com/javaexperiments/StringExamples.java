package com.javaexperiments;

// Java Examples for String, StringBuffer and StringBuilder
// StringBuffer is thread-safe

public class StringExamples {
    public static void main(String[] args) {

        // String is an array of characters, hence it starts from 0 and it is immutable

        String s = "VIVEK";
        String s1 = "NASKAR";

        String s2 = s.concat(s1);
        System.out.println(s2);
        System.out.println(s.charAt(3));
        System.out.println(s.substring(3));

        // Will print the string from index i to j-1
        System.out.println("Will print the string from index i to j-1");
        System.out.println(s2.substring(2, 8));

        StringBuffer s3 = new StringBuffer("NASKARA");
        System.out.println(s3);

        StringBuffer s4 = new StringBuffer();
        s4.append("ABC");
        System.out.println(s4);

        StringBuilder s5 = new StringBuilder("DEF");
        System.out.println(s5);

        //Conversion of string object to StringBuilder
        System.out.println("Conversion of string object to StringBuilder");
        StringBuilder str = new StringBuilder(s);
        str.append(" is awesome!");
        System.out.println(str);

        //Conversion of string object to StringBuffer
        System.out.println("Conversion of string object to StringBuilder");
        StringBuffer str1 = new StringBuffer(s);
        str1.append(" is too awesome!");
        System.out.println(str1);

        //Conversion of StringBuffer object to String
        System.out.println("Conversion of StringBuffer object to String");
        String stringObject = str1.toString();
        System.out.println(stringObject);


    }
}
