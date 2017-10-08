package com.titan.test.thread.jetty.service;

import com.titan.test.thread.jetty.entity.KnapsackDTO;
import com.titan.test.thread.jetty.entity.Status;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProblemSolverAgent {

    @Async("threadPoolTaskExecutor")
    public void solveProblem (String taskId) throws Exception {

        System.out.println("solveProblem Thread : " + Thread.currentThread().getName());

        KnapsackDTO submitted = HelloWorldService.submitted_tasks.remove(taskId);
        submitted.getTask().setStatus(Status.started);
        submitted.getTask().getTimestamps().setStarted(Instant.now().getEpochSecond());
        KnapsackDTO started = submitted;
        HelloWorldService.started_tasks.put(taskId, started);

        for(int i=0; i <1000000000; i++); // do the hardcore stuff!!!

        KnapsackDTO completed = HelloWorldService.started_tasks.remove(taskId);
        completed.getTask().setStatus(Status.completed);
        completed.getTask().getTimestamps().setCompleted(Instant.now().getEpochSecond());
        HelloWorldService.completed_tasks.put(taskId, completed);
    }
}
