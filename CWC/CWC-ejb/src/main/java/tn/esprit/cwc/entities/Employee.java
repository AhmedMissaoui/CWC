package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="Employee")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)


public class Employee implements Serializable {
	private List<EmployeeSession> emp_sessions ;
	private List<Traning_Session> tr_sessions;
	private List<Activity> activities ;
	private Planing planing ;
    private List<Project> projects ;
	private Team team ;
	private String login ;
	private String pswd ;
	private String confpswd ;
	private String mail;
	
	
	private List<Bonus>bonuss ;
	private Integer Id_Employee;
	private Integer CIN;
	private String First_name;
	private String Last_name;
	private Date Birthday;
	private Integer Nb_horaire;
	private Boolean Disponipility;


	public Employee() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public Integer getId_Employee() {
		return this.Id_Employee;
	}

	public void setId_Employee(Integer Id_Employee) {
		this.Id_Employee = Id_Employee;
	}   
	public Integer getCIN() {
		return this.CIN;
	}

	public void setCIN(Integer CIN) {
		this.CIN = CIN;
	}   
	public String getFirst_name() {
		return this.First_name;
	}

	public void setFirst_name(String First_name) {
		this.First_name = First_name;
	}   
	public String getLast_name() {
		return this.Last_name;
	}

	public void setLast_name(String Last_name) {
		this.Last_name = Last_name;
	}   
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public Integer getNb_horaire() {
		return this.Nb_horaire;
	}

	public void setNb_horaire(Integer Nb_horaire) {
		this.Nb_horaire = Nb_horaire;
	}   
	public Boolean getDisponipility() {
		return this.Disponipility;
	}

	public void setDisponipility(Boolean Disponipility) {
		this.Disponipility = Disponipility;
	}
	
	
	@ManyToOne
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
    @OneToMany(mappedBy="employee")
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@ManyToOne
	public Planing getPlaning() {
		return planing;
	}
	public void setPlaning(Planing planing) {
		this.planing = planing;
	}
	@ManyToMany
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	@OneToMany(mappedBy="employee")
	public List<EmployeeSession> getEmp_sessions() {
		return emp_sessions;
	}
	public void setEmp_sessions(List<EmployeeSession> emp_sessions) {
		this.emp_sessions = emp_sessions;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getConfpswd() {
		return confpswd;
	}
	public void setConfpswd(String confpswd) {
		this.confpswd = confpswd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@OneToMany(mappedBy="employee")
	
	public List<Bonus> getBonuss() {
		return bonuss;
	}
	public void setBonuss(List<Bonus> bonuss) {
		this.bonuss = bonuss;
	}
	public Employee(List<EmployeeSession> emp_sessions, List<Traning_Session> tr_sessions, List<Activity> activities,
			Planing planing, List<Project> projects, Team team, List<Bonus> premium, Integer id_Employee, Integer cIN,
			String first_name, String last_name, Date birthday, Integer nb_horaire, Boolean disponipility) {
		super();
		this.emp_sessions = emp_sessions;
		this.tr_sessions = tr_sessions;
		this.activities = activities;
		this.planing = planing;
		this.projects = projects;
		this.team = team;
		this.bonuss = premium;
		Id_Employee = id_Employee;
		CIN = cIN;
		First_name = first_name;
		Last_name = last_name;
		Birthday = birthday;
		Nb_horaire = nb_horaire;
		Disponipility = disponipility;
	}
	
	

	
   
}
