package com.czh.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.czh.dubbo.common.entity.People;
import com.czh.dubbo.common.service.PeopleService;

@RestController
public class PeopleController {
	
	@Reference
	private PeopleService peopleService;
	@GetMapping("/people/{name}")
	public People getPeople(@PathVariable("name") String name) {
		People people = new People();
		people.setName(name);
		return peopleService.getPeople(people);
	}
}
