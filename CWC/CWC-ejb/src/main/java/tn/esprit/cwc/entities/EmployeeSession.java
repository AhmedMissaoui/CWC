package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmployeeSession
 *
 */
@Entity

public class EmployeeSession implements Serializable {
  
	private Traning_Session tr_se;
	private Employee employee ;
	private EmplyeeSessionPK emplyeeSessionPK ;
	private Date StartDate;
	private Date EndDate;
	private Integer NumberParticipants;
	private static final long serialVersionUID = 1L;

	public EmployeeSession() {
		super();
	}   
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public Integer getNumberParticipants() {
		return this.NumberParticipants;
	}

	public void setNumberParticipants(Integer NumberParticipants) {
		this.NumberParticipants = NumberParticipants;
	}
	@EmbeddedId
	public EmplyeeSessionPK getEmplyeeSessionPK() {
		return emplyeeSessionPK;
	}
	public void setEmplyeeSessionPK(EmplyeeSessionPK emplyeeSessionPK) {
		this.emplyeeSessionPK = emplyeeSessionPK;
	}
	@ManyToOne
	@JoinColumn(name="Id_Tran" ,referencedColumnName="Id_Training",insertable=false,updatable=false)
	public Traning_Session getTr_se() {
		return tr_se;
	}
	public void setTr_se(Traning_Session tr_se) {
		this.tr_se = tr_se;
	}
	@ManyToOne
	@JoinColumn(name="Id_Emp" ,referencedColumnName="Id_Employee",insertable=false,updatable=false)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
   
}
