package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cwc.entities.Planing;

@Remote
public interface PlanningServiceRemote {
	public Boolean createPlanning(Planing p) ;
	public Boolean updatePlanning(Planing p);
	public Boolean deletePlanning(Planing p);
	public Planing findById(Integer id);
	public List<Planing> fidAll();

}
