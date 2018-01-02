package tn.esprit.cwc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.QuotaAwareStore;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Project;
import tn.esprit.cwc.entities.Task;



/**
 * Session Bean implementation class TaskService
 */
@Stateless
@LocalBean
public class TaskService implements TaskServiceRemote, TaskServiceLocal {

	@PersistenceContext
    EntityManager tm;
	
    public TaskService() {
    	
    }

	@Override
	public Boolean addTask(Task t) {
		try {
			tm.persist(t);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean updateTask(Task t) {
		try {
			tm.merge(t);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteTask(Task t) {
		try {
			tm.remove(tm.merge(t));
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

	@Override
	public Task showTask(Integer id) {
		return tm.find(Task.class, id);
	}

	@Override
	public List<Task> showTasksByState(String state) {
		List<Task> tasks = new ArrayList<>();
		String jpql = "Select t from Task t where t.state=:x";
		TypedQuery<Task> query = tm.createQuery(jpql, Task.class);
		query.setParameter("x", state);
		tasks=  query.getResultList();
		return tasks;
	}

	@Override
	public List<Task> retreiveTasksByEmployee(Integer idEmp) {
	
		TypedQuery<Task> query = tm.createQuery("SELECT t FROM Task t WHERE t.id_employee :idEmployee", Task.class);
		query.setParameter("idEmployee", String.valueOf(idEmp));
		return query.getResultList();
	}

	@Override
	public List<Task> findAll() {
		Query q=tm.createQuery("select t from Task t");
		return q.getResultList();
	}
	
	public void affectTasktoEmp(Task t,Employee e,Project p){
		t.AssignTaskToEmloyee(e, p);
		tm.merge(t);
	}

	@Override
	public List<Employee> loadTask(){
		return tm.createQuery("SELECT DISTINCT e FROM Employee e "
				+ "JOIN FETCH e.projects p "
				+ "JOIN FETCH p.tasks")
				.getResultList();
	}

	
}
