package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Bonus;
import tn.esprit.cwc.entities.BonusType;
import tn.esprit.cwc.entities.Employee;

@Local
public interface BonusCrudServiceLocal {
	void addBonus(Employee employee,BonusType category,Integer value);
	
	void updateBonusById(Integer id_prime,Integer value);
	
	void deleteBonusById(Integer id_prime);
	
	List<Bonus> getAllBonuss();
	
	List<Employee> getAllEmployees();
	
	List<Bonus> getBonusByEmployeeId(Integer idEmployee);

	Boolean updateBonus(Bonus b);

	Boolean removeBonus(Bonus b);

}
