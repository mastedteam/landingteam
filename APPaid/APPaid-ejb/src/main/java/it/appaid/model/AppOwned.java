package it.appaid.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the app_owned database table.
 * 
 */
@Entity
@Table(name="app_owned")
@IdClass(OwnedId.class)
@NamedQueries({
	@NamedQuery(name="AppOwned.findAll", query="SELECT a FROM AppOwned a"),
	@NamedQuery(name="AppOwned.selectByUser", query="SELECT a, g FROM AppOwned a JOIN a.appGroup g ")//where A.appUser.idUser = :user")
	
})
public class AppOwned implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_JOIN")
	private Date dateJoin;

	@Column(name="FLAG_DELETED")
	private String flagDeleted;

	@Id
	//bi-directional many-to-one association to AppGroup
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_GROUP")
	private AppGroup appGroup;

	@Id
	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private AppUser appUser;

	public AppOwned() {
	}

	public Date getDateJoin() {
		return this.dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public String getFlagDeleted() {
		return this.flagDeleted;
	}

	public void setFlagDeleted(String flagDeleted) {
		this.flagDeleted = flagDeleted;
	}

	public AppGroup getAppGroup() {
		return this.appGroup;
	}

	public void setAppGroup(AppGroup appGroup) {
		this.appGroup = appGroup;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}