package tn.esprit.cwc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Project;
import tn.esprit.cwc.entities.Task;
import tn.esprit.cwc.services.ProjectServiceLocal;
import tn.esprit.cwc.services.TaskServiceLocal;

@ManagedBean
@ViewScoped
public class Taskbean {

	@EJB
	TaskServiceLocal local;
	Task t = new Task();
	List<Employee> employees; 
	
	private List<Task> t_tasks;
	private Boolean test = false;

	
	public Task getT() {
		return t;
	}

	public void setT(Task t) {
		this.t = t;
	}

	public String AddTS() {
		local.addTask(t);
		init();
		return null;
	}

	public String updateTs() {
		local.updateTask(t);
		init();
		return null;
	}

	public String deleteTs(Task T) {

		local.deleteTask(T);
		init();
		return null;
	}

	public List<Task> getT_tasks() {
		return t_tasks;
	}

	public void setT_tasks(List<Task> t_tasks) {
		this.t_tasks = t_tasks;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	@PostConstruct
	public void init() {
		employees = local.loadTask();
		System.out.println(employees);
		t = new Task();
		t_tasks = local.findAll();
		test = false;
	}

	public String inisialiser() {
		test = true;

		return null;
	}

	public void showTaskbystate() {
		t_tasks = new ArrayList<Task>();
		t = new Task();
		t_tasks = local.showTasksByState(t.getState());
		test = false;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
