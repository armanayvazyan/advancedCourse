package com.company.lesson1;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    @SerializedName(value = "name", alternate = {"first_name", "Name"})
    private String name;

    private  int age;

    private boolean hasCar;

    private List<Phone> numbers;

    public User() {
    }

    public User(String name, int age, boolean hasCar) {
        this.name = name;
        this.age = age;
        this.hasCar = hasCar;
    }

    public User(String name, int age, boolean hasCar, List<Phone> numbers) {
        this.name = name;
        this.age = age;
        this.hasCar = hasCar;
        this.numbers = numbers;
    }

    public List<Phone> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Phone> numbers) {
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hasCar=" + hasCar +
                ", numbers=" + numbers +
                '}';
    }
}
