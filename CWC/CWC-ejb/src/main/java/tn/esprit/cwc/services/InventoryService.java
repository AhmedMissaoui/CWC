package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cwc.entities.Inventory;
import tn.esprit.cwc.entities.Traning_Session;

/**
 * Session Bean implementation class InventoryService
 */
@Stateless
public class InventoryService implements InventoryServiceRemote, InventoryServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public InventoryService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean createI(Inventory I) {
		try{
			em.persist(I);
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Boolean updateI(Inventory I) {
		try{
			em.merge(I);
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Boolean deleteI(Inventory I) {
		try{
			em.remove(em.merge(I));
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Inventory findById(Integer id) {
		Inventory I = em.find(Inventory.class, id);
		return I;
	}

	@Override
	public List<Inventory> findAll() {
		Query q=em.createQuery("select i from Inventory i ");
		return q.getResultList();
	}

}
