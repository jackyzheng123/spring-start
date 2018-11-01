package com.zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjx.entity.Person;
import com.zjx.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	/**
	 * 添加
	 */
	@RequestMapping("/save")
	public String save(@RequestBody Person person){
		personService.save(person);
		return "save success";
	}
}
