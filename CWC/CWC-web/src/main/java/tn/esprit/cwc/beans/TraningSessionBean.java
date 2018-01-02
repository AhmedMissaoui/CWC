package tn.esprit.cwc.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.services.EmployeeSessionServiceLocal;
import tn.esprit.cwc.services.TrainingSessionServiceLocal;
import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.EmployeeSession;
import tn.esprit.cwc.entities.Traning_Session;

@ManagedBean
@ViewScoped
public class TraningSessionBean {

	@EJB
	TrainingSessionServiceLocal local;
	@EJB
	EmployeeSessionServiceLocal l;
	private List<Employee> employees;
	Employee employee = new Employee();
	Traning_Session tr = new Traning_Session();
	private List<Traning_Session> t_sessions;
	private Boolean test = false;

	public Traning_Session getTr() {
		return tr;
	}

	public void setTr(Traning_Session tr) {
		this.tr = tr;
	}

	public String AddTS() {
		local.createTraningSession(tr);
		init();
		return null;
	}

	public String updateTS() {
		local.updateTraningSession(tr);
		init();
		return null;
	}

	public String delete(Traning_Session tr) {

		local.deleteTraningSession(tr);
		init();
		return null;
	}

	public List<Traning_Session> getT_sessions() {
		return t_sessions;
	}

	public void setT_sessions(List<Traning_Session> t_sessions) {
		this.t_sessions = t_sessions;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@PostConstruct
	public void init() {
		tr = new Traning_Session();
		t_sessions = local.findAll();
		employees = local.getEmployeesInitTrainingSession();
		//System.out.println(employees.get(0).getEmp_sessions().get(0).getTr_se().getSession());
		test = false;
	}

	public void show() {
		employee = new Employee();
		//employees = local.showEmployeeByTraningSession(tr.getId_Training());
		test = false;
	}

	public String inisialiser() {
		test = true;

		return null;
	}

	public List<EmployeeSession> EmployeList() {
		return l.findAll();

	}

}
