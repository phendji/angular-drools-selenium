package fr.poc.mdr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class User implements Serializable {
	
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -3447300487690179566L;
	
	private String firstname;
	
	private int age;
	
	private List<Anomalie> anomalies;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean addAnomalie(String reference, String description) {
		Anomalie anomalie = new Anomalie(reference, description);
		if(CollectionUtils.isEmpty(anomalies)) {
			setAnomalies(new ArrayList<Anomalie>(1));
		}
		anomalies.add(anomalie);
		return true;
	}

	public final List<Anomalie> getAnomalies() {
		return anomalies;
	}

	public final void setAnomalies(List<Anomalie> anomalies) {
		this.anomalies = anomalies;
	}

}
