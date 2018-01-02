package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {
	private Type type ;
	private List<Task> tasks ;
	private List<Team> teams;
    private Planing planing ;
	private Employee employee ;
	private Integer Id_project;
	private Integer Deadline;
	private static final long serialVersionUID = 1L;

	public Project() {
		super();
	}   
	@Id    
	public Integer getId_project() {
		return this.Id_project;
	}

	public void setId_project(Integer Id_project) {
		this.Id_project = Id_project;
	}   
	public Integer getDeadline() {
		return this.Deadline;
	}

	public void setDeadline(Integer Deadline) {
		this.Deadline = Deadline;
	}
	@ManyToOne
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@ManyToOne
	public Planing getPlaning() {
		return planing;
	}
	public void setPlaning(Planing planing) {
		this.planing = planing;
	}
	@ManyToMany
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	@OneToMany(mappedBy="project")
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	@Enumerated(EnumType.STRING)
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
	
   
}
