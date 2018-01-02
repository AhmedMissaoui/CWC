package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Activity
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)


public class Activity implements Serializable {

	private List<Employee> employees ;
	private Integer Id_Activity;
	private Date date;
	
	private String Location;
	private static final long serialVersionUID = 1L;

	public Activity() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public Integer getId_Activity() {
		return this.Id_Activity;
	}

	public void setId_Activity(Integer Id_Activity) {
		this.Id_Activity = Id_Activity;
	}   
	@Temporal(TemporalType.DATE)
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getLocation() {
		return this.Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}
	@ManyToMany(mappedBy="activities")
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Activity == null) ? 0 : Id_Activity.hashCode());
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (Id_Activity == null) {
			if (other.Id_Activity != null)
				return false;
		} else if (!Id_Activity.equals(other.Id_Activity))
			return false;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}
   
}
