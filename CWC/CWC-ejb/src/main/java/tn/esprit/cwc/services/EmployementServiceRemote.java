package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.cwc.entities.Employee;

@Remote
public interface EmployementServiceRemote {
	public Boolean createEmployee(Employee EE) ;
	public Boolean updateEmployee( int id ,Employee EE);
	public Boolean deleteEmployee(Employee EE);
	public Employee findById(Integer id);
	public List<Employee> fidAll();
	public Employee authentifcate(String login, String pswd);

}
