package com.titan.test.thread.jetty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Solutions {

    private int [] items;
    private int time;

    public Solutions() {}

    public Solutions(int [] items, int time) {

        this.items = items;
        this.time = time;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

