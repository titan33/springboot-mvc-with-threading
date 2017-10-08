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

package com.titan.test.thread.jetty.web;

import com.titan.test.thread.jetty.entity.KnapsackAdministrationDTO;
import com.titan.test.thread.jetty.entity.KnapsackDTO;
import com.titan.test.thread.jetty.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {


	private HelloWorldService helloWorldService;

    @Autowired
	public SampleController (HelloWorldService helloWorldService) {
	    this.helloWorldService = helloWorldService;
    }

	@RequestMapping(value = "/task", method = RequestMethod.POST, produces = "application/json")
	public KnapsackDTO submitTask(@RequestBody KnapsackDTO knapsackDTO) throws Exception {
		return this.helloWorldService.problemRequest(knapsackDTO);
	}

	@RequestMapping(value = "/shutdown", method = RequestMethod.POST, produces = "application/json")
	public KnapsackAdministrationDTO shutdown() {
		return this.helloWorldService.shutdown();
	}
}
