package tn.esprit.cwc.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cwc.entities.EmployeeSession;
import tn.esprit.cwc.services.EmployeeSessionServiceLocal;
import tn.esprit.cwc.entities.EmplyeeSessionPK;
import tn.esprit.cwc.entities.Traning_Session;

@ManagedBean
@ViewScoped
public class EmployeeSessionBean {
    @EJB
	EmployeeSessionServiceLocal local ;

     EmployeeSession ES = new EmployeeSession();
     List<EmployeeSession> emp_sessions ;
     private Boolean test=false;

	public EmployeeSession getES() {
		return ES;
	}

	public void setES(EmployeeSession eS) {
		ES = eS;
	}
	
     
     public String AddES(){
		 EmplyeeSessionPK pk=new EmplyeeSessionPK();
		 pk.setId_Emp(1);
		 pk.setId_Tran(1);
		 pk.setId_Emp(2);
		 pk.setId_Tran(2);
		

		
		 
		 ES.setEmplyeeSessionPK(pk);
    	 local.createEmp_Session(ES);
    	 return null;
     }
     public String updateTS(){
    	 EmplyeeSessionPK pk=new EmplyeeSessionPK();
    	 pk.setId_Emp(1);
		 pk.setId_Tran(1);
		 			local.updateEmp_Session(ES);
			init();
			return null;
		}
     public String delete(EmployeeSession ES){
		 
			local.deleteEmp_Session(ES);
			init();
	        return null;
	   }
     @PostConstruct
 	public void init(){
 		ES =new EmployeeSession();
 		emp_sessions=local.findAll();
 		test=false;
 	}
 	public String inisialiser(){
 		 test=true;
 		
 		
 		return null;
 	}

	public List<EmployeeSession> getEmp_sessions() {
		return emp_sessions;
	}

	public void setEmp_sessions(List<EmployeeSession> emp_sessions) {
		this.emp_sessions = emp_sessions;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}
 	

}
