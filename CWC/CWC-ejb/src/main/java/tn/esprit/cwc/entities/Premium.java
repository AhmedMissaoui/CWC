package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Premium
 *
 */
@Entity

public class Premium implements Serializable {
   
	private Employee employee;
	private Integer Id_Prime;
	private String Category;
	private String Date;
	private static final long serialVersionUID = 1L;

	public Premium() {
		super();
	}   
	@Id    
	public Integer getId_Prime() {
		return this.Id_Prime;
	}

	public void setId_Prime(Integer Id_Prime) {
		this.Id_Prime = Id_Prime;
	}   
	public String getCategory() {
		return this.Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}   
	public String getDate() {
		return this.Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}
	@ManyToOne
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
		
   
}
