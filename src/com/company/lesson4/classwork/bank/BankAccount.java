package com.company.lesson4.classwork.bank;

public class BankAccount {

    public int amount;

    public BankAccount(int amount) {
        this.amount = amount;
    }

    public synchronized void pay(int money) {
        int newBalance = amount - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amount = newBalance;
    }
}
