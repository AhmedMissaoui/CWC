package tn.esprit.cwc.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Inventory;
import tn.esprit.cwc.entities.Traning_Session;
import tn.esprit.cwc.services.InventoryServiceLocal;

@ManagedBean
@ViewScoped
public class InventoryBean {
	
	
	@EJB
	InventoryServiceLocal local ;
	Inventory inventory = new Inventory();
	private List<Inventory> inventories ;
	private Boolean test=false;
	
	
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public List<Inventory> getInventories() {
		return inventories;
	}
	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	
	public String AddInventory() {
		 local.createI(inventory);
		 init();
		 return null ;
	 }
	 public String updateInventory(){
			local.updateI(inventory);
			init();
			return null;
		}
	 public String delete(Inventory inventory){
		 
			local.deleteI(inventory) ;
			init();
	        return null;
	   }
	
	
	
	@PostConstruct
	public void init(){
		inventory =new Inventory();
		inventories=local.findAll();
		test=false;
	}
	
	public String inisialiser(){
		 test=true;
		return null;
	}

}
