package it.appaid.model;

import java.io.Serializable;


public class BalanceId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6745834773623902060L;
	private int idGroup;
	private int idUser;
	
	public BalanceId() {
		super();
	}
	public BalanceId(int idGroup, int idUser) {
		super();
		this.idGroup = idGroup;
		this.idUser = idUser;
	}
	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGroup;
		result = prime * result + idUser;
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
		BalanceId other = (BalanceId) obj;
		if (idGroup != other.idGroup)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	
}
