package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Task;



@Local
public interface TaskServiceLocal {
	
	public Boolean addTask(Task t);
	
	public Boolean updateTask(Task t);
	
	public Boolean deleteTask(Task t);
	
	public Task showTask(Integer id);
	
	public List<Task> findAll();
	
	public List<Task> showTasksByState(String state);
	
	public List<Task> retreiveTasksByEmployee(Integer idEmp);

	List<Employee> loadTask();
	
	

}
