package com.javaexperiments;

/**
 * An illustration of decorator design pattern
 */
public class DecoratorExample {

    public static void main(String args[]) {

        /**
         * Creating new Margherita pizza
         */
        Pizza margheritaPizza = new Margherita();
        System.out.println(margheritaPizza.getDescription()
                + " Cost :$" + margheritaPizza.getCost());

        /**
         * Creating new FarmHouse pizza
         */
        Pizza farmhousePizza = new FarmHouse();

        /**
         * Decorating with FreshTomato topping
         */
        farmhousePizza = new FreshTomato(farmhousePizza);
        System.out.println(farmhousePizza.getDescription()
                + " Cost :$" + farmhousePizza.getCost());

        Pizza cheeseburstPizza = new CheeseBurst(margheritaPizza);
        System.out.println(cheeseburstPizza.getDescription()
                + " Cost :$" + cheeseburstPizza.getCost());

    }
}

/**
 * Abstract pizza class
 */
abstract class Pizza {
    String description = "";

    public String getDescription() {
        return description;
    }
    public abstract double getCost();
}

/**
 * Concrete classes for abstract Pizza class where the pizza types are different
 */
class FarmHouse extends Pizza {
    public FarmHouse() { description = "FarmHouse"; }
    public double getCost() { return 200.00; }
}

class Margherita extends Pizza {
    public Margherita() { description = "Margherita"; }
    public double getCost() { return 100.00; }
}

/**
 * Toppings is the decorator abstract class here that extends abstract Pizza class where
 * the toppings like CheeseBurst, and FreshTomato are different
 */
abstract class Toppings extends Pizza {
    public abstract String getDescription();
}

/**
 * Decorator concrete classes extending abstract Toppings class
 */
class CheeseBurst extends Toppings {
    Pizza pizza;
    public CheeseBurst(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() {
        return pizza.getDescription() + " with Cheese Burst topping ";
    }
    public double getCost() { return 50.00 + pizza.getCost(); }
}

class FreshTomato extends Toppings {
    Pizza pizza;
    public FreshTomato(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() {
        return pizza.getDescription() + " with Fresh Tomato topping ";
    }
    public double getCost() { return 35.00 + pizza.getCost(); }
}
