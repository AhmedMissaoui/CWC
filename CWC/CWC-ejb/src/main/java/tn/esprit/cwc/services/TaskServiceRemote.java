package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cwc.entities.Task;



@Remote
public interface TaskServiceRemote {
	
	public Boolean addTask(Task task);
	
	public Boolean updateTask(Task task);
	
	public Boolean deleteTask(Task task);
	
	public Task showTask(Integer id);
	
	public List<Task> findAll();
	
	public List<Task> showTasksByState(String state);
	
	public List<Task> retreiveTasksByEmployee(Integer idEmp);

}
