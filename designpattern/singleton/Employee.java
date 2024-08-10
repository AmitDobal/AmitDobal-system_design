package com.amit.systemdesign.designpattern.singleton;

import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
    private String name;
    private String department;
    private double salary;

    private static Employee INSTANCE;

    private Employee() {
        if(INSTANCE != null){
            throw new RuntimeException("Use getInstance() method to get the instance");
        }
    }

    public static Employee getInstance() {
        if (INSTANCE == null) {
            synchronized (Employee.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Employee();
                }
            }
        }
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + "]";
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return INSTANCE;
    }

    public Object readResolve(){
        return getInstance();
    }

}
