package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Traning_Session;


@Local
public interface TrainingSessionServiceLocal {
public Boolean createTraningSession(Traning_Session tr);
public Boolean updateTraningSession(Traning_Session tr);
public Boolean deleteTraningSession(Traning_Session tr);
public Traning_Session findById(Integer id);
public List<Traning_Session> findAll();
List<Employee> showEmployeeByTraningSession(Integer id);
public List<Employee> getEmployeesInitTrainingSession();


}
