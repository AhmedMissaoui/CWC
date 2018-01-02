package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;
import tn.esprit.cwc.entities.Employee;

/**
 * Entity implementation class for Entity: Developer
 *
 */
@Entity

public class Developer extends Employee implements Serializable {

	
	private Integer Evaluation;
	private static final long serialVersionUID = 1L;

	public Developer() {
		super();
	}   
	public Integer getEvaluation() {
		return this.Evaluation;
	}

	public void setEvaluation(Integer Evaluation) {
		this.Evaluation = Evaluation;
	}
   
}
