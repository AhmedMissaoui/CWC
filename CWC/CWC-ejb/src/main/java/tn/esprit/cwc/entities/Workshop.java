package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.cwc.entities.Activity;

/**
 * Entity implementation class for Entity: Workshop
 *
 */
@Entity


public class Workshop extends Activity implements Serializable {

	
	private String Theme;
	private Integer Number_Participants;
	private Integer Duration;
	private static final long serialVersionUID = 1L;

	public Workshop() {
		super();
	}   
	public String getTheme() {
		return this.Theme;
	}

	public void setTheme(String Theme) {
		this.Theme = Theme;
	}   
	public Integer getNumber_Participants() {
		return this.Number_Participants;
	}

	public void setNumber_Participants(Integer Number_Participants) {
		this.Number_Participants = Number_Participants;
	}   
	public Integer getDuration() {
		return this.Duration;
	}

	public void setDuration(Integer Duration) {
		this.Duration = Duration;
	}
   
}
