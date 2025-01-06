package com.javaexperiments;

/**
 * An illustration of state design pattern
 */
public class StateExample {

    public static void main(String[] args) {

        Parcel parcel = new Parcel();
        parcel.printStatus();

        parcel.nextState();
        parcel.printStatus();

        parcel.nextState();
        parcel.printStatus();

        parcel.nextState();
        parcel.printStatus();
    }
}

class Parcel {

    private ParcelState state = new OrderedState();

    public ParcelState getState() {
        return state;
    }

    public void setState(ParcelState state) {
        this.state = state;
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}

interface ParcelState {
    void next(Parcel parcel);
    void prev(Parcel parcel);
    void printStatus();
}

class OrderedState implements ParcelState {

    @Override
    public void next(Parcel parcel) {
        parcel.setState(new DeliveredState());
    }

    @Override
    public void prev(Parcel parcel) {
        System.out.println("The parcel is in its initial state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Parcel ordered, not delivered to the delivery center yet.");
    }

    @Override
    public String toString() {
        return "Ordered";
    }
}

class DeliveredState implements ParcelState {

    @Override
    public void next(Parcel parcel) {
        parcel.setState(new ReceivedState());
    }

    @Override
    public void prev(Parcel parcel) {
        parcel.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("The parcel delivered to the delivery center, not received yet.");
    }

    @Override
    public String toString() {
        return "Delivered";
    }

}

class ReceivedState implements ParcelState {

    @Override
    public void next(Parcel parcel) {
        System.out.println("The parcel is received by a customer.");
    }

    @Override
    public void prev(Parcel parcel) {
        parcel.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("The parcel was received by customer.");
    }

    @Override
    public String toString() {
        return "Received";
    }
}