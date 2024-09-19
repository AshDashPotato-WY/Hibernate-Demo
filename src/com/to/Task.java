package com.to;

import jakarta.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "taskID")
    private int taskID;
    private String task;

    public Task() {}

    public Task(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", task='" + task + '\'' +
                '}';
    }
}
