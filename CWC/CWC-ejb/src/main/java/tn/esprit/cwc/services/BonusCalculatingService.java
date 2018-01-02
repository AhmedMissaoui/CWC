
package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.cwc.entities.Bonus;
import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Project;
import tn.esprit.cwc.entities.Task;
/**
 * Session Bean implementation class BonusCalculatingService
 */
@Stateless
public class BonusCalculatingService implements BonusCalculatingServiceRemote, BonusCalculatingServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public BonusCalculatingService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Integer calculateBonusAttend(Integer id_employee) {
    	Employee employee = entityManager.find(Employee.class, id_employee);
    	Integer attendBonus = 0;
    	
    	Integer supHours = calculateSupHours(employee);
    	
    	attendBonus = supHours*20;
    	
    	return attendBonus;
	}
    @Override
	public Integer calculateBonusProd(Integer id_employee) {
    	
		Employee employee = entityManager.find(Employee.class, id_employee);
		Integer nbrTasksForEmployee = getNbrTasksForEmployee(employee);
		Integer nbrTasksAcomplishedForEmployee = getNbrTasksAcomplishedForEmployee(employee);
		
		Integer prodBonus = calculFinalProdBonus(nbrTasksForEmployee,nbrTasksAcomplishedForEmployee);
		
		return prodBonus;
		
	}
    
    private Integer calculFinalProdBonus(Integer nbrTasks,Integer nbrTaskAccomplished){
    	Integer moyAvancement = (nbrTaskAccomplished/nbrTasks)*10;
    	Integer prodBonus = 0;
    	if (moyAvancement<9 && moyAvancement>= 8){
    		prodBonus = 100;
    	}else if(moyAvancement>=9 && moyAvancement<=10){
    		prodBonus=250;
    	}    	
    	return prodBonus;
    }
	
	private Integer getNbrTasksForEmployee(Employee employee){
		Integer nbrTasksForEmployee = 0;
		List<Project> employeeProjects = employee.getProjects();
		
		for (Project project : employeeProjects){
			 {
				for(Task task : project.getTasks()){
					if(task.getId_employee().equals(employee.getId_Employee())){
						nbrTasksForEmployee = nbrTasksForEmployee + 1;
					}
				}
			}
		}
		return nbrTasksForEmployee;		
	}
	
	private Integer getNbrTasksAcomplishedForEmployee(Employee employee){
		
		Integer nbrTaskAcomplishedForEmployee = 0;
		List<Project> employeeProjects = employee.getProjects();
		
		for (Project project : employeeProjects){
			
				for(Task task : project.getTasks()){
					if(task.getId_employee().equals(employee.getId_Employee()) && task.isAcomplished()){
						nbrTaskAcomplishedForEmployee = nbrTaskAcomplishedForEmployee + 1;
					}
				}
			}
		
		return nbrTaskAcomplishedForEmployee;
		
}

	private Integer calculateSupHours(Employee employee){
		
		Integer nb_Hours = employee.getNb_horaire();
		Integer supHours = nb_Hours*30-160;
		
		if (supHours <= 0 ){
			supHours = 0;
		}
		
		return supHours;
	  }


	}