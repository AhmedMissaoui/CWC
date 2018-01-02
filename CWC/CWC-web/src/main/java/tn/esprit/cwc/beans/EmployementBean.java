package tn.esprit.cwc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Team;
import tn.esprit.cwc.entities.Traning_Session;
import tn.esprit.cwc.services.EmployementServiceLocal;
import tn.esprit.cwc.services.TeamService;
import tn.esprit.cwc.services.TeamServiceLocal;
import tn.esprit.cwc.services.*;

@ManagedBean
@ViewScoped
public class EmployementBean {
	@EJB
	EmployementServiceLocal local;
	private Employee f = new Employee();
	private Boolean test = false;
	private List<Employee> employees = new ArrayList<Employee>();
	@EJB
	TeamServiceLocal localteam;
	private List<Team> Teams = new ArrayList<Team>();

	public EmployementServiceLocal getLocal() {
		return local;
	}

	public void setLocal(EmployementServiceLocal local) {
		this.local = local;
	}

	public Employee getF() {
		return f;
	}

	public void setF(Employee f) {
		this.f = f;
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

	public List<Team> getTeams() {
		return Teams;
	}

	public void setTeams(List<Team> teams) {
		Teams = teams;
	}

	public String AddEmploye() {
		local.createEmployee(f);
		init();
		return null;
	}

	private String teamId; 
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	public String updateEmploye() {
		Team team =  local.findTeamById(Integer.parseInt(teamId));
		f.setTeam(team);
		
		local.updateEmployee(team.getId_Team_Leader(), f);
		init();
		return null;
	}

	public String deleteEmploye(Employee E) {

		local.deleteEmployee(E);
		init();
		return null;
	}

	@PostConstruct
	public void init() {
		f = new Employee();
		f.setTeam(new Team());
		employees = local.fidAll();
		test = false;

	}

	public String initialiser() {
		test = true;

		return null;

	}

	public List<Team> TeamList() {

		return localteam.findAll();
	}

	public TeamServiceLocal getLocalteam() {
		return localteam;
	}

	public void setLocalteam(TeamServiceLocal localteam) {
		this.localteam = localteam;
	}

}
