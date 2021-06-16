package com.company.lesson1;

import java.io.Serializable;

public class Phone implements Serializable {

    private int number;
    private String operator;

    public Phone(int number, String operator) {
        this.number = number;
        this.operator = operator;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
