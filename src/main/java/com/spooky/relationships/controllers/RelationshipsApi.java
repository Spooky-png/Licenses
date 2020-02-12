package com.spooky.relationships.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spooky.relationships.models.License;
import com.spooky.relationships.models.Person;
import com.spooky.relationships.service.RelationshipService;

@RestController
public class RelationshipsApi {
	private final RelationshipService relationshipService;
	public RelationshipsApi(RelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}
	@RequestMapping("/api/persons")
	public List<Person> index(){
		return relationshipService.allPersons();
	}
	@RequestMapping(value="/api/persons", method=RequestMethod.POST)
	public Person create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
		Person person = new Person(firstName, lastName);
		return relationshipService.createPerson(person);
	}
	@RequestMapping(value="/api/licenses", method=RequestMethod.POST)
	public License create2(@RequestParam(value="number") String number, @RequestParam(value="expirationDate") String expirationDate, @RequestParam(value="state") String state, @RequestParam(value="person") Person person) {
		License license = new License(number, expirationDate, state, person);
		return relationshipService.createLicense(license);
	}
}
