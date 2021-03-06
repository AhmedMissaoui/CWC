package tn.esprit.cwc.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cwc.entities.Team;
import tn.esprit.cwc.entities.TeamLeader;
import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Project;;

@Local
public interface TeamServiceLocal {
	
	public void addTeam(Team team);
	
	public void updateTeam(Team team);
	
	public void DeleteTeam(Team team);
	
	public List<Team> findAll();
	
	public TeamLeader showTeamLeaderOfTheTeam(Integer id);
	
	public List<Employee> showEmployeesByTeamId(Integer id);
	
	public Team showTeamByCategory(String category);
	
	public List<Employee> showTeamByProject(Project project);
	
	public Integer showTotalWorkloadByTeam(Integer id);
	
	

}
