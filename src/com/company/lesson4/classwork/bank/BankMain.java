package com.company.lesson4.classwork.bank;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        ATMThread atmThread = new ATMThread(account, "1111", 100);
        OnlineBankThread onlineBankThread = new OnlineBankThread(account, "", "", 100);
        OnlineBankThread onlineBankThread2 = new OnlineBankThread(account, "", "", 100);

        atmThread.start();
        onlineBankThread.start();
        onlineBankThread2.start();

        atmThread.join();
        onlineBankThread.join();
        onlineBankThread2.join();
        System.out.println(account.amount);
    }
}
