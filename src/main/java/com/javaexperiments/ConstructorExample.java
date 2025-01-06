package com.javaexperiments;

public class ConstructorExample {

    private String accountNumber;
    private String accountName;
    private double balance;

    public ConstructorExample(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double depositAmount) {

        balance += depositAmount;
        System.out.println("The amount deposited is " + depositAmount + " and balance is " + balance);

    }

    public static void main(String[] args) {
        ConstructorExample constructorExample = new ConstructorExample("123456", "Vivek", 2000.0);
        System.out.println("The account belongs to " + constructorExample.accountName + " with account number: "
                + constructorExample.accountNumber + " and balance: " +constructorExample.balance);
    }
}
