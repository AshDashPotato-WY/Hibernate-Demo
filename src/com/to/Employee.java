package com.to;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // it will generate ID automatically everytime we try to insert
    @Column(name = "employeeID")
    private int employeeID;
    @Column(nullable = false, name="first_name")
    private String employeeName;

//    private String department;

    @OneToOne
    private Department department; // one employee associated with one department

    @ManyToMany
    List<Task> taskList = new ArrayList<>();
    private String position;
    private int age;

    // constructor
    public Employee() {

    }

    public Employee(String employeeName, Department department, List<Task> taskList, String position, int age) {
        this.employeeName = employeeName;
        this.department = department;
        this.taskList = taskList;
        this.position = position;
        this.age = age;
    }

    public Employee(String employeeName, Department department, String position, int age) {
        this.employeeName = employeeName;
        this.department = department;
        this.position = position;
        this.age = age;
    }

    public Employee(int employeeID, String employeeName, Department department, List<Task> taskList, String position, int age) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.taskList = taskList;
        this.position = position;
        this.age = age;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", departmentDetails=" + department +
                ", taskList=" + taskList +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
