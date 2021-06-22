package com.company.lesson5.classwork.immutableClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {

    private String name;
    private Date birthDate;

    public Human(String name, Date birthDate) {
        this.name = name;
        if(birthDate != null)
            this.birthDate = (Date) birthDate.clone();
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return (Date) birthDate.clone();
    }

    public void printInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println("Name: " + name);
        System.out.println("BirthDay: " + sdf.format(birthDate));
    }
}
