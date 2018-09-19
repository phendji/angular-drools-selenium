/**
 * 
 */
package fr.poc.api.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.poc.api.backend.model.User;
import fr.poc.api.backend.service.IBackendService;

/**
 * @author phendji
 *
 */

@CrossOrigin
@RestController
@RequestMapping("api-backend/v1")
public class BackendController {
	
	/* Service Backend */
	@Autowired
	private IBackendService backendService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User getUser(@RequestBody(required = true) User user) {
		User users = null;
		users = backendService.verifierIntegriteDesDonnees(user);
		return users;
	}
	
}
