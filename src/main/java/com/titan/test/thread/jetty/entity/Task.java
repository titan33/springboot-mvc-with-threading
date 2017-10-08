package com.titan.test.thread.jetty.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {

    private String task;
    private Status status;
    private Timestamps timestamps;

    public Task() {};

    public Task(String task,Status status,Timestamps timestamps) {

        this.task = task;
        this.status = status;
        this.timestamps = timestamps;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Timestamps getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Timestamps timestamps) {
        this.timestamps = timestamps;
    }
}
