package HCL_Mini_Project2;

import java.io.Serializable;

/*
 * Employee class
 * Stores employee details
 * Serializable so that object can be saved in file
 */
public class Employee implements Serializable {

    int id;                 // Employee ID
    String name;            // Employee Name
    String department;      // Employee Department
    double salary;          // Employee Salary

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display employee details
    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Dept: " + department +
               " | Salary: " + salary;
    }
}
