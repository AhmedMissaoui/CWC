package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Activity;
import tn.esprit.cwc.entities.Conference;
import tn.esprit.cwc.entities.Workshop;


@Local
public interface ActivityServiceLocal {
	public Boolean createActivity (Activity a);
	public Boolean updateActivity(Activity a);
	public Boolean deleteActivity(Activity a);
	public Activity findById(Integer id);
	public List<Workshop> findAll();
	public List<Conference> FindAll1();
}
