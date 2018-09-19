/**
 * 
 */
package fr.poc.api.backend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author phendji
 *
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6677015086198019968L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "age")
	private int age;
	
	private List<Anomalie> anomalies;

	/**
	 * @return the anomalies
	 */
	public List<Anomalie> getAnomalies() {
		return anomalies;
	}

	/**
	 * @param anomalies the anomalies to set
	 */
	public void setAnomalies(List<Anomalie> anomalies) {
		this.anomalies = anomalies;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
