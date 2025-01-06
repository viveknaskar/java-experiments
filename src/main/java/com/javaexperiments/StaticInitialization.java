package com.javaexperiments;

import java.util.Scanner;

public class StaticInitialization {

    private static int B;
    private static int H;

    private static boolean flag = false;

    static {
        System.out.println("static block can be used to initialize singleton instance, " +
                "to prevent using synchronized getInstance() method.");
        System.out.println("static initialization blocks allows more complex initialization.");
        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        B = input.nextInt();
        input.nextLine();
        H = input.nextInt();
        input.close();

        try {
            if (B <= 0 || H <= 0) {
                throw new Exception("java.lang.Exception: Breadth and height must be positive");
            } else {
                flag = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }

}

