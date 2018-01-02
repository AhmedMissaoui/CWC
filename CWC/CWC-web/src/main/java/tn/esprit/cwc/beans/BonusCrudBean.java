
package tn.esprit.cwc.beans;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.services.BonusCrudServiceLocal;
import tn.esprit.cwc.entities.Bonus;
import tn.esprit.cwc.entities.Employee;
@ManagedBean
@ViewScoped
public class BonusCrudBean {
	



	@EJB
	  BonusCrudServiceLocal local;
	 Bonus bonus = new Bonus();
	 //Employee employee = new Employee();

	 private List<Bonus> bonuss ;
	 //private List<Employee> employees ;

	 private Boolean test=false;
	 
	 
	 
	
	public BonusCrudServiceLocal getLocal() {
		return local;
	}
	public void setLocal(BonusCrudServiceLocal local) {
		this.local = local;
	}
	public Bonus getBonus() {
		return bonus;
	}
	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	public List<Bonus> getBonuss() {
		return bonuss;
	}
	public void setBonuss(List<Bonus> bonuss) {
		this.bonuss = bonuss;
	}
	
	
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	
	public String update(){
		local.updateBonus(bonus);
		init();
		return null;
	}
	public String delete(Bonus bonus){
		local.removeBonus(bonus);
		init();
		return null;
	}
	
	@PostConstruct
	public void init(){
		bonus =new Bonus();
		bonuss=local.getAllBonuss();
		test=false;
	}
	
	
	
	
	public String inisialiser(){
		 test=true;
		
		
		return null;
	}
	}
	
