package com.to;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table
public class User {
    @Id
    private int userID;
    private String userName;
    private String department;
    private String position;
    private int age;

    // constructor
    public User() {

    }

    public User(int userID, String userName, String department, String position, int age) {
        this.userID = userID;
        this.userName = userName;
        this.department = department;
        this.position = position;
        this.age = age;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

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
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
