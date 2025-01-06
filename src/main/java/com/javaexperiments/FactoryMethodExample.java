package com.javaexperiments;

import java.util.Scanner;

public class FactoryMethodExample {

    public static void main(String[] args) {

        System.out.println("Enter the type of car:\nAudi \nTesla");

        Scanner in = new Scanner(System.in);
        String carType = in.nextLine();

        /**
         * The factory method is called to get the object of the concrete classes by passing
         * the information of the car from the user.
         */
        CarFactory carFactory = new CarFactory();
        carFactory.manufactureCar(carType.toLowerCase());

    }

}

/**
 * Abstract Class with abstract and concrete method
 */
abstract class Car {
    public abstract void addEngineType();
    public void deliverCar() {
        System.out.println("Your car will be delivered at your doorstep.");
    }
}

/**
 * Concrete class 'AudiCar' extending the abstract Class
 */
class AudiCar extends Car {
    @Override
    public void addEngineType() {
        System.out.println("You have ordered a car with gasoline Engine.");
    }
}

/**
 * Concrete class 'TeslaCar' extending the abstract Class
 */
class TeslaCar extends Car {
    @Override
    public void addEngineType() {
        System.out.println("You have ordered a car with electric Engine. ");
    }
}

/**
 * In Factory method, the object of the Car is created.
 */
class CarFactory {
    public Car manufactureCar(String type){
        Car car;
        switch (type.toLowerCase())
        {
            case "audi":
                car = new AudiCar();
                break;
            case "tesla":
                car = new TeslaCar();
                break;
            default: throw new IllegalArgumentException("No such car available.");
        }
        car.addEngineType();
        car.deliverCar();
        return car;
    }
}

