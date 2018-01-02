package tn.esprit.cwc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Planing;
import tn.esprit.cwc.services.PlanningServiceLocal;

@ManagedBean
@ViewScoped
public class PlanningBean {
	@EJB
	PlanningServiceLocal local;
	private Planing p=new Planing();
	private Boolean test=false;
	private List<Planing> Planings =new ArrayList<Planing>();
	
	
	
	
	
	 public PlanningServiceLocal getLocal() {
		return local;
	}
	public void setLocal(PlanningServiceLocal local) {
		this.local = local;
	}
	public Planing getP() {
		return p;
	}
	public void setP(Planing p) {
		this.p = p;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	public List<Planing> getPlanings() {
		return Planings;
	}
	public void setPlanings(List<Planing> planings) {
		Planings = planings;
	}
	public String AddPlaning() {
		 local.createPlanning(p);
		 init();
		 return null ;
	 }
	 public String updatePlaning(){
			local.updatePlanning(p);
			init();
			return null;
		}
	 public String deletePlaning(Planing p){
		 
			local.deletePlanning(p);
			init();
	        return null;
	   }
	 
	 
	 
	 
	@PostConstruct
	public void init(){
		p=new Planing();
		Planings=local.fidAll();
		test=false;
		
	}
	
	public String initialiser(){
		test=true;
		
		return null;
		
	}

	
	

}

	


