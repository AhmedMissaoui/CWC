package tn.esprit.cwc.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Activity;
import tn.esprit.cwc.entities.Traning_Session;
import tn.esprit.cwc.entities.Workshop;
import tn.esprit.cwc.services.ActivityServiceLocal;

@ManagedBean
@ViewScoped
public class WorkshopBean {
	
	@EJB
	ActivityServiceLocal local ;
	Workshop w =new Workshop();
	private List<Workshop> workshops ;
	
	 private Boolean test=false;
	
	
	
	public Workshop getW() {
		return w;
	}
	public void setW(Workshop w) {
		this.w = w;
	}
	public  String AddWorkshop(){
		local.createActivity(w);
		init();
		return null ;
	}
	 public String updateworkshop(){
			local.updateActivity(w);
			init();
			return null;
	 }
	 public String delete(Workshop w){
		 
			local.deleteActivity(w);
			init();
	        return null;
	   }

	public List<Workshop> getWorkshops() {
		return workshops;
	}
	public void setWorkshops(List<Workshop> workshops) {
		this.workshops = workshops;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}

     @PostConstruct
     public void init(){
	w =new Workshop();
	workshops=local.findAll();
	test=false;
}
	public String inisialiser(){
		 test=true;
		
		
		return null;
	}
}
