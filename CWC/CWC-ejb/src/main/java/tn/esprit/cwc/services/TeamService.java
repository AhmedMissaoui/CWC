package tn.esprit.cwc.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.cwc.entities.Employee;
import tn.esprit.cwc.entities.Project;
import tn.esprit.cwc.entities.Task;
import tn.esprit.cwc.entities.Team;
import tn.esprit.cwc.entities.TeamLeader;

/**
 * Session Bean implementation class TeamService
 */
@Stateless
public class TeamService implements TeamServiceRemote, TeamServiceLocal {

	@PersistenceContext
    EntityManager tm;
    
    public TeamService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		tm.persist(team);
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		tm.merge(team);
	}

	@Override
	public void DeleteTeam(Team team) {
		// TODO Auto-generated method stub
		tm.remove(tm.merge(team));
	}

	@Override
	public TeamLeader showTeamLeaderOfTheTeam(Integer id) {
		// TODO Auto-generated method stub
		TeamLeader teamLeader = new TeamLeader();
		String jpql = "Select tm from TeamLeader tm join tm.team t where t.Id_team=:x";
		Query q=tm.createQuery(jpql,TeamLeader.class);
		q.setParameter("x", id);
		return teamLeader;
	}

	@Override
	public List<Employee> showEmployeesByTeamId(Integer id) {
		// TODO Auto-generated method stub
		List<Employee> listE=new ArrayList<>();
		String jpql = "Select e from Employee e join e.team t where t.Id_Team=:e.Id_Team AND t.Id_team:=p.Id_team AND p.Id_project:=x";
		TypedQuery<Employee> query=tm.createQuery(jpql, Employee.class);
		query.setParameter("x", id);
		listE=query.getResultList();
		return listE;
	}

	@Override
	public Team showTeamByCategory(String category) {
		// TODO Auto-generated method stub
		Team t = new Team();
		String jpql = "Select t from Team t t.category=:x";
		TypedQuery<Team> query=tm.createQuery(jpql, Team.class);
		query.setParameter("x", category);
		t=query.getSingleResult();
		return t;
	}

	@Override
	public List<Employee> showTeamByProject(Project project) {
		// TODO Auto-generated method stub
		List<Employee> listEmp=new ArrayList<>();
		String jpql = "Select e from Employee e join e.team t join t.project p where t.Id_TeamLeader=:x";
		TypedQuery<Employee> query=tm.createQuery(jpql, Employee.class);
		query.setParameter("x", project.getId_project());
		listEmp=query.getResultList();
		return listEmp;
	}

	@Override
	public Integer showTotalWorkloadByTeam(Integer id) {
		// TODO Auto-generated method stub
		Integer total = null;
		String jpql = "Select SUM(t.workload) from Task t join t.project p join p.team tm where t.Id_Project:=p.Id_Project AND p.Id_Team:=x";
		Query query=tm.createQuery(jpql, Task.class);
		query.setParameter("x", id);
		query.getSingleResult();
		return total;
	}

	@Override
	public List<Team> findAll() {
		// TODO Auto-generated method stub
		Query q = tm.createQuery("Select t from Team t");
		return q.getResultList();
	}

}
