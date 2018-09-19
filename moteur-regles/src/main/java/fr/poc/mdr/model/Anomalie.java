package fr.poc.mdr.model;

import java.io.Serializable;

public class Anomalie implements Serializable{

	/** serialVersionUID. */
	private static final long serialVersionUID = -4020799891140358049L;

	
	  
	  private String reference;
	  
	  private String description;

	/**
	 * @param reference
	 * @param description
	 */
	public Anomalie(String reference, String description) {
		super();
		this.reference = reference;
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	  
}
