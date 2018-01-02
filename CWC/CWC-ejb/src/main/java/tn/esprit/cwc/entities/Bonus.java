package tn.esprit.cwc.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Premium
 *
 */
@Entity
public class Bonus implements Serializable {
   
	private Employee employee;
	private Integer idBonus;
	private BonusType Category;
	private Integer value;
	private static final long serialVersionUID = 1L;

	public Bonus() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdBonus() {
		return this.idBonus;
	}

	public void setIdBonus(Integer idBonus) {
		this.idBonus = idBonus;
	}   
	
	@Enumerated(EnumType.STRING)

	public BonusType getCategory() {
		return Category;
	}
	public void setCategory(BonusType category) {
		Category = category;
	}

	
	@ManyToOne
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getValue() {
		return value;}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	

	
	
	
   
}

