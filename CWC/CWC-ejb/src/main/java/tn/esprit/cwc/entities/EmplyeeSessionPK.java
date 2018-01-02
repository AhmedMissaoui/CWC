package tn.esprit.cwc.entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmplyeeSessionPK
 *
 */
@Embeddable

public class EmplyeeSessionPK implements Serializable {

	
	private Integer Id_Emp;
	private Integer Id_Tran;
	private static final long serialVersionUID = 1L;

	public EmplyeeSessionPK() {
		super();
	}

	public Integer getId_Emp() {
		return Id_Emp;
	}

	public void setId_Emp(Integer id_Emp) {
		Id_Emp = id_Emp;
	}

	public Integer getId_Tran() {
		return Id_Tran;
	}

	public void setId_Tran(Integer id_Tran) {
		Id_Tran = id_Tran;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Emp == null) ? 0 : Id_Emp.hashCode());
		result = prime * result + ((Id_Tran == null) ? 0 : Id_Tran.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmplyeeSessionPK other = (EmplyeeSessionPK) obj;
		if (Id_Emp == null) {
			if (other.Id_Emp != null)
				return false;
		} else if (!Id_Emp.equals(other.Id_Emp))
			return false;
		if (Id_Tran == null) {
			if (other.Id_Tran != null)
				return false;
		} else if (!Id_Tran.equals(other.Id_Tran))
			return false;
		return true;
	}   
	
}
