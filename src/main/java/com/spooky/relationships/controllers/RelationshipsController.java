package com.spooky.relationships.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spooky.relationships.models.License;
import com.spooky.relationships.models.Person;
import com.spooky.relationships.repostiories.LicenseRepository;
import com.spooky.relationships.repostiories.PersonRepository;
import com.spooky.relationships.service.RelationshipService;

@Controller
public class RelationshipsController {
	private final RelationshipService relationshipService;
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public RelationshipsController(RelationshipService relationshipService, PersonRepository personRepository, LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
		this.relationshipService = relationshipService;
	}
	@RequestMapping("/person/new")
		public String newPerson(@ModelAttribute("person") Person p, Model model) {
		List<Person>allPersons = relationshipService.allPersons();
		model.addAttribute("person", allPersons);
			return "/relationships/newPerson.jsp";
	}
	@RequestMapping(value="/person/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person p, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Person>allPersons = relationshipService.allPersons();
			model.addAttribute("person", allPersons);
			return "/relationships/newPerson.jsp";
		} else {
			relationshipService.createPerson(p);
			return "redirect:/view";
		}
		
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	@RequestMapping(value="/license/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License l, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Person>allPersons = relationshipService.allPersons();
			model.addAttribute("person", allPersons);
			return "/relationships/newLicense.jsp";
		} else {
		relationshipService.createLicense(l);
		return "redirect:/view";
		}
	}
	@RequestMapping("/license/new")
	public String newLicense(@ModelAttribute("license") License l, Model model) {
		List<Person>allPersons = relationshipService.allPersons();
		model.addAttribute("person", allPersons);
		return "/relationships/newLicense.jsp";
}
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Person person = relationshipService.findPerson(id);
		License license = relationshipService.findLicense(id);
		model.addAttribute("person", person);
		model.addAttribute("license", license);
		return "/relationships/show.jsp";
	}
	public PersonRepository getPersonRepository() {
		return personRepository;
	}
	public LicenseRepository getLicenseRepository() {
		return licenseRepository;
	}
}
