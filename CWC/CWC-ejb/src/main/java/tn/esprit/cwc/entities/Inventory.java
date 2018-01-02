package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Inventory
 *
 */
@Entity

public class Inventory implements Serializable {

	
	private Integer id_Inventory;
	private String HumanResources;
	private String LogisticalResources;
	private String SoftwareResources;
	private static final long serialVersionUID = 1L;

	public Inventory() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId_Inventory() {
		return this.id_Inventory;
	}

	public void setId_Inventory(Integer id_Inventory) {
		this.id_Inventory = id_Inventory;
	}   
	public String getHumanResources() {
		return this.HumanResources;
	}

	public void setHumanResources(String HumanResources) {
		this.HumanResources = HumanResources;
	}   
	public String getLogisticalResources() {
		return this.LogisticalResources;
	}

	public void setLogisticalResources(String LogisticalResources) {
		this.LogisticalResources = LogisticalResources;
	}   
	public String getSoftwareResources() {
		return this.SoftwareResources;
	}

	public void setSoftwareResources(String SoftwareResources) {
		this.SoftwareResources = SoftwareResources;
	}
   
}
