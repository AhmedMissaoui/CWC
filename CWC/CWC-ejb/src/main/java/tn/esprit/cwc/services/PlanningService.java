package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import tn.esprit.cwc.entities.Planing;


/**
 * Session Bean implementation class PlanningService
 */
@Stateless
public class PlanningService implements PlanningServiceRemote, PlanningServiceLocal {

    /**
     * Default constructor. 
     */
    public PlanningService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext
	EntityManager em;
    
    
    	public Boolean createPlanning(Planing p) {
    		try{
    		em.persist(p);
    		}catch(Exception e){
    			return false;
    		}
    		return true;
    	}
    	
    	public Boolean updatePlaning(Planing p) {
    		try{
    			em.merge(p);
    			}catch(Exception e){
    				return false;
    			}
    			return true;
    		}
    	
    	public Boolean deletePlanning(Planing p) {
    		try{
    			em.remove(em.merge(p));
    			}catch(Exception e){
    				return false;
    			}
    			return true;
    		}
    	public Planing findById(Integer id) {
    		Planing EE=em.find(Planing.class,id);
    		return EE;
    	}
    	
    	public List<Planing> fidAll() {
    		Query q=em.createQuery("select p from Planing p");
    		return q.getResultList();
    	}

		@Override
		public Boolean updatePlanning(Planing p) {
			// TODO Auto-generated method stub
			return null;
		}
    	

}
