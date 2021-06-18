package com.company.lesson4.classwork.bank;

public class ATMThread extends Thread{

    private String pin;
    private BankAccount account;
    private int money;

    public ATMThread(BankAccount account, String pin, int money) {
        this.pin = pin;
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        System.out.println("ATM payment started");
        account.pay(money);
        System.out.println("ATM payment ended");
    }
}
