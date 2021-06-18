package com.company.lesson4.classwork.bank;

import com.company.lesson4.classwork.bank.BankAccount;

public class OnlineBankThread extends Thread {

    private BankAccount account;
    private String login;
    private String password;
    private int money;

    public OnlineBankThread(BankAccount account, String login, String password, int money) {
        this.account = account;
        this.login = login;
        this.password = password;
        this.money = money;
    }

    @Override
    public void run() {
        System.out.println("Online bank payment started");
        account.pay(money);
        System.out.println("Online bank payment ended");
    }
}


