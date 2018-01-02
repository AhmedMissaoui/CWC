package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity

public class Team implements Serializable {
    
	private List<Project>projets ;
	private List<Employee> employees ;
	private Integer Id_Team;
	private Integer Nbr_Employees;
	private Integer Id_Team_Leader;
	private String Category;
	private static final long serialVersionUID = 1L;

	public Team() {
		super();
	}   
	@Id    
	public Integer getId_Team() {
		return this.Id_Team;
	}

	public void setId_Team(Integer Id_Team) {
		this.Id_Team = Id_Team;
	}   
	public Integer getNbr_Employees() {
		return this.Nbr_Employees;
	}

	public void setNbr_Employees(Integer Nbr_Employees) {
		this.Nbr_Employees = Nbr_Employees;
	}   
	public Integer getId_Team_Leader() {
		return this.Id_Team_Leader;
	}

	public void setId_Team_Leader(Integer Id_Team_Leader) {
		this.Id_Team_Leader = Id_Team_Leader;
	}   
	public String getCategory() {
		return this.Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}
	@OneToMany(mappedBy="team")
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@ManyToMany(mappedBy="teams")
	public List<Project> getProjets() {
		return projets;
	}
	public void setProjets(List<Project> projets) {
		this.projets = projets;
	}
	
	
	
   
}
