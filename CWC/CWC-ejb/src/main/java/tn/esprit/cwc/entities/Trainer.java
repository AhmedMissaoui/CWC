package tn.esprit.cwc.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.cwc.entities.Employee;

/**
 * Entity implementation class for Entity: Trainer
 *
 */
@Entity

public class Trainer extends Employee implements Serializable {
 
	private String speciality;
	
	private static final long serialVersionUID = 1L;

	public Trainer() {
		super();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
   
}
