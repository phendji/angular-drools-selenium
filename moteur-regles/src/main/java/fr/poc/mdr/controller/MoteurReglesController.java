package fr.poc.mdr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.poc.mdr.model.User;
import fr.poc.mdr.service.IMoteurReglesService;

@RestController
@RequestMapping("api-moteur-regles/v1")
public class MoteurReglesController {

	/**
	 * Moteur de règles service.
	 */
	@Autowired
	private IMoteurReglesService moteurReglesService;
	
	@CrossOrigin
	@RequestMapping(value = "/executerRegles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User executerRegles(@RequestBody(required = true) User user ) {
		System.out.println("Firstname : " + user.getFirstname());
		System.out.println("Age : " + user.getAge());
		moteurReglesService.executerRegles(user);
		return user;
	}

}
