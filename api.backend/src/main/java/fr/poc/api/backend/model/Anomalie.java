/**
 * 
 */
package fr.poc.api.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author phendji
 *
 */
@Entity
@Table(name = "anomalies")
public class Anomalie implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 3323272092348201475L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "id")
	private User idUser;

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	 
	
}
