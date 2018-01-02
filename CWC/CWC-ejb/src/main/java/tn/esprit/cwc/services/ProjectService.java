package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.cwc.entities.Project;


@Stateless
public class ProjectService implements  ProjectServiceLocal,ProjectServiceRemote {

	 /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
	
    public ProjectService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean createProject(Project p) {
		try{
			em.persist(p);
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Boolean updateProject(Project p) {
		try{
			em.merge(p);
			}catch(Exception e){
				return false;
			}
			return true;
	
	}

	@Override
	public Boolean deleteProject(Project p) {
		try{
			em.remove(em.merge(p));
			}catch(Exception e){
				return false;
			}
			return true;
	}

	@Override
	public Project findById(Integer id) {
		Project p = em.find(Project.class, id);
		return p;
	}

	@Override
	public List<Project> findAll() {
			Query q=em.createQuery("select p from Project p ");
			return q.getResultList();
	}

}
