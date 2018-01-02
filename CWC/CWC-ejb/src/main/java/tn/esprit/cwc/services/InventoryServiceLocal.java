package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Inventory;
import tn.esprit.cwc.entities.Traning_Session;

@Local
public interface InventoryServiceLocal {
	public Boolean createI(Inventory I);
	public Boolean updateI(Inventory I);
	public Boolean deleteI(Inventory I);
	public Inventory findById(Integer id);
	public List<Inventory> findAll();
}
