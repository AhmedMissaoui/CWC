package tn.esprit.cwc.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Project;
import tn.esprit.cwc.services.ProjectServiceLocal;


@ManagedBean
@ViewScoped
public class ProjectBean {
	
	@EJB
	ProjectServiceLocal local;
	 Project p = new Project();
	 private List<Project> t_Projects;
	 private Boolean test=false;
	 
	 
	 
	 public Project getP() {
		return p;
	}
	public void setP(Project p) {
		this.p = p;
	}
	public String AddPR() {
		 local.createProject(p );
		 init();
		 return null ;
	 }
	 public String updatePR(){
			local.updateProject(p );
			init();
			return null;
		}
	 public String deletePR(Project p ){
		 
			local.deleteProject(p );
			init();
	        return null;
	   }
	 
	public List<Project> getT_Projects() {
		return t_Projects;
	}
	public void setT_Projects(List<Project> t_Projects) {
		this.t_Projects = t_Projects;
	}
	
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	@PostConstruct
	public void init(){
		p =new Project();
		t_Projects=local.findAll();
		test=false;
	}
	public String inisialiser(){
		 test=true;
		
		
		return null;
	}

	

}
