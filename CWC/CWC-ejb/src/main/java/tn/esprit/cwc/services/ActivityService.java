package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cwc.entities.Activity;
import tn.esprit.cwc.entities.Conference;
import tn.esprit.cwc.entities.Workshop;

/**
 * Session Bean implementation class ActivitySessionBean
 */
@Stateless
public class ActivityService implements ActivityServiceRemote, ActivityServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public ActivityService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean createActivity(Activity a) {
		try{
			em.persist(a);
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Boolean updateActivity(Activity a) {
		try{
			em.merge(a);
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Boolean deleteActivity(Activity a) {
		try{
			em.remove(em.merge(a));
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Activity findById(Integer id) {
		Activity a = em.find(Activity.class, id);
		return a;
	}

	@Override
	public List<Workshop> findAll() {
		Query q=em.createQuery("select w from Workshop w ");
		return q.getResultList();
	}

	@Override
	public List<Conference> FindAll1() {
		Query q=em.createQuery("select c from Conference c ");
		return q.getResultList();
	}

}
