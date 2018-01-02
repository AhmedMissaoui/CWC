package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.cwc.entities.Planing;

@Local
public interface PlanningServiceLocal {
	public Boolean createPlanning(Planing p) ;
	public Boolean updatePlanning(Planing p);
	public Boolean deletePlanning(Planing p);
	public Planing findById(Integer id);
	public List<Planing> fidAll();

}
