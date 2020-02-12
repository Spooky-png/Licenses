package com.spooky.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spooky.relationships.models.License;
import com.spooky.relationships.models.Person;
import com.spooky.relationships.repostiories.LicenseRepository;
import com.spooky.relationships.repostiories.PersonRepository;

@Service
public class RelationshipService {
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public RelationshipService(PersonRepository personRepository, LicenseRepository licenseRepository) {
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	public List<Person> allPersons() {
		return personRepository.findAll();
	}
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}


	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	}