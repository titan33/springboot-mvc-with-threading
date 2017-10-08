/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.titan.test.thread.jetty.service;

import com.titan.test.thread.jetty.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class HelloWorldService {


    public static ConcurrentMap<String, KnapsackDTO> submitted_tasks = new ConcurrentSkipListMap<>();
    public static ConcurrentMap<String, KnapsackDTO> started_tasks = new ConcurrentSkipListMap<>();
    public static ConcurrentMap<String, KnapsackDTO> completed_tasks = new ConcurrentSkipListMap<>();


	@Value("${name:World}")
	private String name;


	@Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
    ProblemSolverAgent problemSolverAgent;


	public KnapsackDTO problemRequest(KnapsackDTO knapsackDTO) throws Exception {

        System.out.println("problemRequest Thread : " + Thread.currentThread().getName());

        String taskId = UUID.randomUUID().toString();
        Timestamps timestamps = new Timestamps(Instant.now().getEpochSecond(), 0l, 0l);
        Task task = new Task(taskId, Status.submitted,timestamps);
        KnapsackDTO submittedTask = new KnapsackDTO(task);
        submitted_tasks.put(taskId,submittedTask);
        problemSolverAgent.solveProblem (taskId);
        return submittedTask;
    }


    public KnapsackAdministrationDTO shutdown() {

        threadPoolTaskExecutor.shutdown();
        long epoch = Long.parseLong(String.valueOf(Instant.now().getEpochSecond()));
        Instant instant = Instant.ofEpochSecond(epoch);
        String timestamp = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        KnapsackAdministrationDTO adminMsg = new KnapsackAdministrationDTO(timestamp, "Service was shut down!!", "Service-shutdown");
        return adminMsg;
    }

}
