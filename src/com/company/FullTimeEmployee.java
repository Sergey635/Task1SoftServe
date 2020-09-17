package com.company;

public class FullTimeEmployee implements IAccounting {
    private String name;
    private double salary;

//getters setters constructors

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public double getMontsSalary() {
        return this.getSalary();
    }
}
