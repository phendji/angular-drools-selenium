package fr.poc.mdr.service.impl;

import java.io.IOException;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import fr.poc.mdr.model.User;
import fr.poc.mdr.service.IMoteurReglesService;

/**
 * Impl�mentation des services pour le moteur de r�gles.
 */
@Service(value = "moteurReglesService")
public class MoteurReglesServiceImpl implements IMoteurReglesService{
	
	// source file rule
	@Value("${api.moteur.regles.drl}")
	String reglesDRL;
	
	/** Base de connaissance de JBoss Rules. */
	private KieContainer kieContainer; 

	public User executerRegles(User user) {
		// TODO Auto-generated method stub
	if(user != null) {
		if(kieContainer == null) {
			 KieServices kieServices = KieServices.Factory.get();

	        // buider le contenu du fichier de r�gles.
	        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

	        // r�cup�rer les fichiers de r�gles .drl
	        Resource[] fichierRegles = getFichierRegles();

	        // ajouter le fichier des r�gles dans KieFileSystem.
	        if (fichierRegles != null && fichierRegles.length > 0) {
	          for (Resource fichierRegle : getFichierRegles()) {
	            kieFileSystem
	                .write(ResourceFactory.newFileResource(reglesDRL + fichierRegle.getFilename()));
	          }
	        }
	        
	        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
	        kb.buildAll();

	        // cr�er un nouveau KieContainer.
	        KieRepository kieRepository = kieServices.getRepository();
	        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
	        kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
		}
		
		 KieSession kieSession = kieContainer.newKieSession();
		 
		// ins�rer les r�gles dans le kieSession.
		 	kieSession.insert(user);

	      // d�clencher les r�gles.
	      kieSession.fireAllRules();

	      // release & free memory
	      kieSession.dispose();
	}
		return user;
	}
	
	private Resource[] getFichierRegles() {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] fichierRegles = new Resource[0];
		try {
			fichierRegles = resourcePatternResolver.getResources("file:" + reglesDRL + "validation.drl");
		} catch (IOException e) {
			// TODO: handle exception
			throw new IllegalStateException("Probl�me li� au chargement du fichier de regles (.drl)", e);
		}
		
		return fichierRegles;
	}
}
