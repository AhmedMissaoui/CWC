package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity

public class Responsable implements Serializable {

	
	private Integer Id_Administrator;
	private String login;
	private String pswd;
	private static final long serialVersionUID = 1L;

	public Responsable() {
		super();
	}   
	@Id    
	public Integer getId_Administrator() {
		return this.Id_Administrator;
	}

	public void setId_Administrator(Integer Id_Administrator) {
		this.Id_Administrator = Id_Administrator;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
   
}
