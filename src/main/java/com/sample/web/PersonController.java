package com.sample.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.Person;
import com.sample.service.PersonService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping
	@ApiOperation(value = "Create a Person for use in the portfolio management system")
	public Person create(@Valid @RequestBody Person person)  {
		return personService.create(person);
	}
	
	@GetMapping
	@ApiOperation(value = "Retrieve a persons details matching an ID")
	public Person retrieve(@RequestParam Long id) {
		
		return personService.retrieve(id);
	}
	
}
