package tn.esprit.cwc.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Conference;
import tn.esprit.cwc.entities.Traning_Session;
import tn.esprit.cwc.services.ActivityServiceLocal;

@ManagedBean
@ViewScoped
public class ConferenceBean {
	@EJB
	ActivityServiceLocal local ;
	Conference c = new Conference();
	private List<Conference> conferences ;

	 private Boolean test=false;
	public Conference getC() {
		return c;
	}
	public void setC(Conference c) {
		this.c = c;
	}
	public String AddConference(){
		
		local.createActivity(c);
		 init();
		 return null ;
	}
	 public String updateTS(){
			local.updateActivity(c);
			init();
			return null;
		}
	 public String delete(Conference c){
		 
			local.deleteActivity(c);
			init();
	        return null;
	   }
	public List<Conference> getConferences() {
		return conferences;
	}
	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	@PostConstruct
	public void init(){
		c =new Conference();
		conferences=local.FindAll1();
		test=false;
	}
	public String inisialiser(){
		 test=true;
		
		
		return null;
	}
}
