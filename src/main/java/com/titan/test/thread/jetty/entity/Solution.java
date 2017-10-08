package com.titan.test.thread.jetty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Solution {

    private String task;
    private Problem problem;
    private Solutions solutions;

    public Solution() {}

    public Solution(String task, Problem problem, Solutions solutions ) {

        this.task = task;
        this.problem = problem;
        this.solutions = solutions;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Solutions getSolutions() {
        return solutions;
    }

    public void setSolutions(Solutions solutions) {
        this.solutions = solutions;
    }
}

