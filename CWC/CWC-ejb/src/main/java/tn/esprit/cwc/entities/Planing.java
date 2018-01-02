package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Planing
 *
 */
@Entity

public class Planing implements Serializable {
    private List<Project> projects ;
	private List<Employee> employees ;
	private Integer Id_Planing;
	private static final long serialVersionUID = 1L;

	public Planing() {
		super();
	}   
	@Id    
	public Integer getId_Planing() {
		return this.Id_Planing;
	}

	public void setId_Planing(Integer Id_Planing) {
		this.Id_Planing = Id_Planing;
	}
	@OneToMany(mappedBy="planing")
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@OneToMany(mappedBy="planing")
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
   
}
