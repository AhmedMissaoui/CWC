package tn.esprit.cwc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.cwc.entities.Bonus;
import tn.esprit.cwc.entities.BonusType;
import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.services.BonusCalculatingServiceLocal;
import tn.esprit.cwc.services.BonusCrudServiceLocal;

@ManagedBean
public class BonusCalculatingBean {
	
	@EJB
	BonusCalculatingServiceLocal bonusCalculatingServiceLocal;
	@EJB
	BonusCrudServiceLocal bonusCrudServiceLocal;
	
	List<Employee> allEmployees = new ArrayList<>();
	
	
	public void initEmployeeList(){
		
		allEmployees = bonusCrudServiceLocal.getAllEmployees();
		
	}
	
	
	public void calculateBonusForAllEmployees (){
		initEmployeeList();
		
		for (Employee employee : allEmployees){
			
			Integer idEmployee = employee.getId_Employee();
			Integer attendBonus = bonusCalculatingServiceLocal.calculateBonusAttend(idEmployee);
			Integer prodBonus = bonusCalculatingServiceLocal.calculateBonusProd(idEmployee);
			
			bonusCrudServiceLocal.addBonus(employee, BonusType.bonus_attend, attendBonus);
			bonusCrudServiceLocal.addBonus(employee, BonusType.bonus_prod, prodBonus);
			
			List<Bonus> employeeBonus = bonusCrudServiceLocal.getBonusByEmployeeId(idEmployee);
			
			employee.getBonuss().addAll(employeeBonus);
		}
	}

	
}
