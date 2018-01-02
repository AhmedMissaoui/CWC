package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {

	private Project project;
	private Integer Id_Task;
	private String State;
	private Integer Workload;
	private Integer id_employee;
	private boolean acomplished;
	private static final long serialVersionUID = 1L;
	private String Nom ;
	private String Description ;

	public Task() {
		super();
	}   
	
	public Integer getId_employee() {
		return id_employee;
	}

	public void setId_employee(Integer id_employee) {
		this.id_employee = id_employee;
	}

	@Id    
	public Integer getId_Task() {
		return this.Id_Task;
	}

	public void setId_Task(Integer Id_Task) {
		this.Id_Task = Id_Task;
	}   
	public String getState() {
		return this.State;
	}

	public void setState(String State) {
		this.State = State;
	}   
	public Integer getWorkload() {
		return this.Workload;
	}

	public void setWorkload(Integer Workload) {
		this.Workload = Workload;
	}
	@ManyToOne
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	public boolean isAcomplished() {
		return acomplished;
	}

	public void setAcomplished(boolean acomplished) {
		this.acomplished = acomplished;
	}
	public void AssignTaskToEmloyee (Employee emp , Project prj ){
		for(Project p:emp.getProjects()){
			if(p.equals(prj)){
				prj.getTasks().add(this);
			}
		}
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
   
}
