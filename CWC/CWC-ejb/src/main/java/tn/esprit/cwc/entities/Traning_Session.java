package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Traning_Session
 *
 */
@Entity

public class Traning_Session implements Serializable {
    private List<EmployeeSession> empsessions ; 
	private List<Employee> employees ;
	private Integer Id_Training;
	private Date Date;
	private Integer Nbr_employees;
	private String Session;
	private static final long serialVersionUID = 1L;

	public Traning_Session() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId_Training() {
		return this.Id_Training;
	}

	public void setId_Training(Integer Id_Training) {
		this.Id_Training = Id_Training;
	}   
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Integer getNbr_employees() {
		return this.Nbr_employees;
	}

	public void setNbr_employees(Integer Nbr_employees) {
		this.Nbr_employees = Nbr_employees;
	}   
	public String getSession() {
		return this.Session;
	}

	public void setSession(String Session) {
		this.Session = Session;
	}
	@OneToMany(mappedBy="tr_se")
	public List<EmployeeSession> getEmpsessions() {
		return empsessions;
	}
	public void setEmpsessions(List<EmployeeSession> empsessions) {
		this.empsessions = empsessions;
	}
	
   
}
