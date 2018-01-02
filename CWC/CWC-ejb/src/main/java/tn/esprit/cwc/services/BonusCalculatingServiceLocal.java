package tn.esprit.cwc.services;

import javax.ejb.Local;

@Local
public interface BonusCalculatingServiceLocal {
	public Integer calculateBonusAttend(Integer id_employee);
	
	public Integer calculateBonusProd(Integer id_employee);
}


