package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Project;


@Local
public interface ProjectServiceLocal {
	
	public Boolean createProject(Project p);
	public Boolean updateProject(Project p);
	public Boolean deleteProject(Project p);
	public Project findById(Integer id);
	public List<Project> findAll();
}
