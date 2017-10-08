package com.titan.test.thread.jetty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnapsackDTO {

    private Problem problem;
    private Solution solution;
    private Task task;

    public KnapsackDTO() {}

    public KnapsackDTO(Problem problem, Solution solution, Task task) {

        this.problem = problem;
        this.solution = solution;
        this.task = task;
    }

    public KnapsackDTO(Problem problem, Solution solution) {

        this.problem = problem;
        this.solution = solution;
    }

    public KnapsackDTO(Problem problem) {

        this.problem = problem;
    }

    public KnapsackDTO(Solution solution) {

        this.solution = solution;
    }

    public KnapsackDTO(Task task) {

        this.task = task;
    }

    public Problem getProblem() {
        return problem;
    }

    public Solution getSolution() {
        return solution;
    }

    public Task getTask() {
        return task;
    }
}
