package tn.esprit.cwc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import tn.esprit.cwc.entities.Bonus;
import tn.esprit.cwc.entities.BonusType;
import tn.esprit.cwc.entities.Employee;


/**
 * Session Bean implementation class BonusCrudService
 */
@Stateless
public class BonusCrudService implements BonusCrudServiceRemote, BonusCrudServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public BonusCrudService() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void addBonus(Employee employee, BonusType category, Integer value) {
		
		Bonus bonus = new Bonus();
		
		bonus.setCategory(category);
		bonus.setValue(value);
		bonus.setEmployee(employee);
		entityManager.persist(bonus);
		
	}
    @Override
	public Boolean updateBonus(Bonus b) {
		try{
			entityManager.merge(b);
			}catch(Exception e){
				return false;
			}
			return true;
	}
	@Override
	public Boolean removeBonus(Bonus b) {
		try{
			entityManager.remove(entityManager.merge(b));
			}catch(Exception e){
				return false;
			}
			return true;
	}
	

	@Override
	public void updateBonusById(Integer idBonus,Integer value) {
		
		Bonus bonus = entityManager.find(Bonus.class, idBonus);
		if (bonus == null){
			throw new IllegalArgumentException("Not such bonus with given Id !!");		
		} else {
			bonus.setValue(value);			
		}		
	}

	@Override
	public void deleteBonusById(Integer idBonus) {
		Bonus bonus = entityManager.find(Bonus.class, idBonus);
        entityManager.remove(bonus);
	}
	
	@SuppressWarnings("unchecked")

	@Override
	public List<Bonus> getAllBonuss() {
		Query q = entityManager.createQuery (" select b From Bonus b");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")

    @Override
    public List<Employee> getAllEmployees() {
    	Query q = entityManager.createQuery(" select e From Employee e");
    	return q.getResultList();
    }
    
    @Override
    public List<Bonus> getBonusByEmployeeId(Integer idEmployee) {
    	
        List<Bonus> bonusList = new ArrayList<>();
        
        for (Bonus bonus : getAllBonuss()){
        	if (bonus.getEmployee().getId_Employee().equals(idEmployee)){
        		bonusList.add(bonus);
        	}
        }
      	return bonusList;
    }

}
