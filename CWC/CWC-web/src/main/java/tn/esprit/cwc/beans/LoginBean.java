package tn.esprit.cwc.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.cwc.entities.Employee;

import tn.esprit.cwc.services.EmployementServiceLocal;


@ManagedBean(name="logBean")
@SessionScoped
public class LoginBean {

	@EJB
	EmployementServiceLocal local ;
	
	private  String login;
	private String pswd;
	private String message="";
	
	private Boolean loggedIn=false;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
public String doLogin(){
		
	 Employee emp =null;
		emp=local.authentifcate(login, pswd);
		{
			if(emp instanceof Employee){
				
				return "template";
			}
	
		
		else{
			message="vérifier le login et/ou mot de passe ";
		return null;
		}
	}
	
}

}
