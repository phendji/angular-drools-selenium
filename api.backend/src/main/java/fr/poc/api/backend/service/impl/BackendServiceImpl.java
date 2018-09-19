/**
 * 
 */
package fr.poc.api.backend.service.impl;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.poc.api.backend.model.User;
import fr.poc.api.backend.service.IBackendService;

/**
 * @author phendji
 *
 */
@Service
public class BackendServiceImpl implements IBackendService {

	/** URL Api moteur de règles */
	@Value("${api.moteur.regles.url}")
	private String urlAPIMoteurRegles;
	  
	/** Mapping Api moteur de règles */
	@Value("${api.moteur.regles.mapping}")
	private String mappingAPIMoteurRegles;
	  
	/* (non-Javadoc)
	 * @see fr.poc.api.backend.service.IBackendService#verifierIntegriteDesDonnees(fr.poc.api.backend.model.User)
	 */
	public User verifierIntegriteDesDonnees(User user) {
		// TODO Auto-generated method stub
		System.out.println("Firstname : " + user.getFirstname());
		System.out.println("Age : " + user.getAge());
		return this.executerMoteurDeRegles(user);
	}

	public User executerMoteurDeRegles(User user) {
		
		// Appel du moteur de regles
		ResponseEntity<User> response = this.appelerAuMoteurDeRegles(user);
		
		return response.getBody();
		
	}
	
	private ResponseEntity<User> appelerAuMoteurDeRegles(User user) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<User>(user);
		
		return restTemplate.exchange(
										urlAPIMoteurRegles.concat(mappingAPIMoteurRegles),
										HttpMethod.POST,
										request,
										new ParameterizedTypeReference<User>() {});
	}
	
}
