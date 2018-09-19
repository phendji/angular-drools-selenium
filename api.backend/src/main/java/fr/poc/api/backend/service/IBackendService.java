/**
 * 
 */
package fr.poc.api.backend.service;

import fr.poc.api.backend.model.User;

/**
 * @author phendji
 *
 */
public interface IBackendService {
	User verifierIntegriteDesDonnees(User user);
}
