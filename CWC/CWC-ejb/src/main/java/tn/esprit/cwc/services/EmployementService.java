package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Project;
import tn.esprit.cwc.entities.Team;

/**
 * Session Bean implementation class EmployementService
 */
@Stateless
public class EmployementService implements EmployementServiceRemote, EmployementServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	public EmployementService() {

		// TODO Auto-generated constructor stub
	}

	public Boolean createEmployee(Employee EE) {
		try {
			em.persist(EE);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean updateEmployee(int id, Employee EE) {

		em.merge(EE);

		return true;
	}

	@Override
	public Boolean deleteEmployee(Employee EE) {
		try {
			em.remove(em.merge(EE));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Employee findById(Integer id) {
		Employee EE = em.find(Employee.class, id);
		return EE;
	}

	public void affectProjectToEmployee(Project a, Employee f) {
		// f est le maitre
		// f.assigneProject(a);
		// em.merge(f);

	}

	public List<Employee> fidAll() {
		Query q = em.createQuery("select f from Employee f");
		return q.getResultList();
	}

	@Override
	public Employee authentifcate(String login, String pswd) {
		Employee emp = null;
		Query q = em.createQuery("select emp from Employee emp where emp.login=:p1 and emp.pswd=:p2");
		q.setParameter("p1", login);
		q.setParameter("p2", pswd);
		try {
			emp = (Employee) q.getSingleResult();
		} catch (NoResultException e) {

		}
		return emp;
	}

	@Override
	public Team findTeamById(int id) {
		return em.find(Team.class, id);
	}

}
