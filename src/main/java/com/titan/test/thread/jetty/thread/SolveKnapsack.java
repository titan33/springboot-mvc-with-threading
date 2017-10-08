package com.titan.test.thread.jetty.thread;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SolveKnapsack {

    String name;

    public void setName(String name){
        this.name = name;
    }

    @Async("solutionExecutor")
    public void solveKnapsack() {

        System.out.println(name + " is running");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " is running");

    }
}
