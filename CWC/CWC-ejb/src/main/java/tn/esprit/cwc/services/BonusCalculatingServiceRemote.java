package tn.esprit.cwc.services;

import javax.ejb.Remote;

@Remote
public interface BonusCalculatingServiceRemote {
	public Integer calculateBonusAttend(Integer id_employee);
	
	public Integer calculateBonusProd(Integer id_employee);
}



