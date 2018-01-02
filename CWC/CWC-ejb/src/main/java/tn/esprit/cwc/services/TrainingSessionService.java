package tn.esprit.cwc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Traning_Session;


/**
 * Session Bean implementation class TrainingSessionService
 */
@Stateless
public class TrainingSessionService implements TrainingSessionServiceRemote, TrainingSessionServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public TrainingSessionService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Boolean createTraningSession(Traning_Session tr) {
		try{
			em.persist(tr);
			}catch(Exception e){
				return false;
			}
			return true;
	}
	@Override
	public Boolean updateTraningSession(Traning_Session tr) {
		try{
			em.merge(tr);
			}catch(Exception e){
				return false;
			}
			return true;
	}
	@Override
	public Boolean deleteTraningSession(Traning_Session tr) {
		try{
			em.remove(em.merge(tr));
			}catch(Exception e){
				return false;
			}
			return true;
	}
	@Override
	public Traning_Session findById(Integer id) {
	Traning_Session tr = em.find(Traning_Session.class, id);
	return tr;
	}
	@Override
	public List<Traning_Session> findAll() {
		Query q=em.createQuery("select tr from Traning_Session tr ");
		return q.getResultList();
		
		
	}
	public List<Employee> showEmployeeByTraningSession(Integer id) {
		// TODO Auto-generated method stub
		List<Employee> listE=new ArrayList<>();
		String jpql = "select e from Employee e join e.Id_Traning t where t.id_Traning=:x";
		TypedQuery<Employee> query=em.createQuery(jpql, Employee.class);
		query.setParameter("x", id);
		listE=query.getResultList();
		return listE;
	}
	@Override
	public List<Employee> getEmployeesInitTrainingSession() {
		return em.createQuery("SELECT e FROM Employee e JOIN FETCH e.emp_sessions").getResultList();
	}

	

	

	

	}


