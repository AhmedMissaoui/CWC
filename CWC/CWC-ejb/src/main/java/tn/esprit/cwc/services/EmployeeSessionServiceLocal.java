package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.EmployeeSession;
import tn.esprit.cwc.entities.Traning_Session;

@Local
public interface EmployeeSessionServiceLocal {
public Boolean createEmp_Session(EmployeeSession ES);
public Boolean updateEmp_Session(EmployeeSession Es);
public Boolean deleteEmp_Session(EmployeeSession Es);
public Traning_Session findById(Integer id);
public List<EmployeeSession> findAll();
}
