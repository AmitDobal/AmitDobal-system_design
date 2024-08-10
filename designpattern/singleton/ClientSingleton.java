package com.amit.systemdesign.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class ClientSingleton {
    public static void main(String[] args) {
        Employee employee1 = Employee.getInstance();
        System.out.println("Original Instance1 " + employee1.hashCode());
        breakSingleton(employee1);
        Employee employee2 = Employee.getInstance();
        System.out.println("Original Instance2 " + employee2.hashCode());
    }

    private static void breakSingleton(Employee emp) {
        // reflectionAPI();

        // cloneSingleton(emp);

        serDesSingleton(emp);
    }

    private static void reflectionAPI() {
        try {
            Constructor<Employee> constructor = Employee.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Employee reflectionInstance = constructor.newInstance();
            System.out.println("Reflection instance: " + reflectionInstance.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cloneSingleton(Employee emp) {
        try {
            Employee employee = emp.clone();
            System.out.println("Cloned Instance: " + employee.hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void serDesSingleton(Employee emp) {
        // serialization
        try (FileOutputStream fileOut = new FileOutputStream("Emp.ser")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            System.out.println("Serialized Emp is saved in Emp.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Deserialization
        try (FileInputStream fileIN = new FileInputStream("Emp.ser")) {
            ObjectInputStream in = new ObjectInputStream(fileIN);
            Employee employee = (Employee) in.readObject();
            System.out.println("Deserialized Employee: " + employee.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
