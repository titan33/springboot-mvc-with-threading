package com.titan.test.thread.jetty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Timestamps {

    private long submitted;
    private long started;
    private long completed;

    public Timestamps(){};

    public Timestamps (long submitted, long started,long completed) {

        this.submitted  = submitted;
        this.started = started;
        this.completed = completed;
    }

    public long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(long submitted) {
        this.submitted = submitted;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }
}
