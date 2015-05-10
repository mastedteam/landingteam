package it.appaid.model;

import java.io.Serializable;


public class OwnedId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8994097621565504178L;
	private int appGroup;;
	private int appUser;
	
	
	public OwnedId() {
		super();
	}


	public OwnedId(int appGroup, int appUser) {
		super();
		this.appGroup = appGroup;
		this.appUser = appUser;
	}


	public int getAppGroup() {
		return appGroup;
	}


	public void setAppGroup(int appGroup) {
		this.appGroup = appGroup;
	}


	public int getAppUser() {
		return appUser;
	}


	public void setAppUser(int appUser) {
		this.appUser = appUser;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appGroup;
		result = prime * result + appUser;
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
		OwnedId other = (OwnedId) obj;
		if (appGroup != other.appGroup)
			return false;
		if (appUser != other.appUser)
			return false;
		return true;
	}

	
	
}
