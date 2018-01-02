package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.cwc.entities.Employee;

/**
 * Entity implementation class for Entity: TeamLeader
 *
 */
@Entity

public class TeamLeader extends Employee implements Serializable {

	
	private String Team_Name;
	private static final long serialVersionUID = 1L;

	public TeamLeader() {
		super();
	}   
	public String getTeam_Name() {
		return this.Team_Name;
	}

	public void setTeam_Name(String Team_Name) {
		this.Team_Name = Team_Name;
	}
   
}
