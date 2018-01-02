package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.cwc.entities.Activity;

/**
 * Entity implementation class for Entity: Conference
 *
 */
@Entity


public class Conference extends Activity implements Serializable {

	
	private String Speaker;
	private String Subject;
	private String Description;
	private static final long serialVersionUID = 1L;

	public Conference() {
		super();
	}   
	public String getSpeaker() {
		return this.Speaker;
	}

	public void setSpeaker(String Speaker) {
		this.Speaker = Speaker;
	}   
	public String getSubject() {
		return this.Subject;
	}

	public void setSubject(String Subject) {
		this.Subject = Subject;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
