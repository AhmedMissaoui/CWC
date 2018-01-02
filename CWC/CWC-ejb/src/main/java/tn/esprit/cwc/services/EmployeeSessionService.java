package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cwc.entities.EmployeeSession;
import tn.esprit.cwc.entities.Traning_Session;

/**
 * Session Bean implementation class EmployeeSessionService
 */
@Stateless
public class EmployeeSessionService implements EmployeeSessionServiceRemote, EmployeeSessionServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public EmployeeSessionService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Boolean createEmp_Session(EmployeeSession ES) {
		try{
			em.persist(ES);
			}catch(Exception e){
				return false;
			}
			return true;
	}
	@Override
	public Boolean updateEmp_Session(EmployeeSession Es) {
		try{
			em.merge(Es);
			}catch(Exception e){
				return false;
			}
			return true;
	}
	@Override
	public Boolean deleteEmp_Session(EmployeeSession Es) {
		try{
			em.remove(em.merge(Es));
			}catch(Exception e){
				return false;
			}
			return true;

	}
	@Override
	public Traning_Session findById(Integer id) {
		Traning_Session es  = em.find(Traning_Session.class, id);
		return es;
	}
	@Override
	public List<EmployeeSession> findAll() {
		Query q=em.createQuery("select es from EmployeeSession es ");
		return q.getResultList();
	}

}
