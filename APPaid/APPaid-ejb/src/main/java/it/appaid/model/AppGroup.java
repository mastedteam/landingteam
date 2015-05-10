package it.appaid.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_group database table.
 * 
 */
@Entity
@Table(name="app_group")
@NamedQuery(name="AppGroup.findAll", query="SELECT a FROM AppGroup a")

public class AppGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_GROUP")
	private int idGroup;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATION")
	private Date dateCreation;

	@Column(name="FLAG_DELETED")
	private String flagDeleted;

	@Column(name="ID_USER_CREATION")
	private String idUserCreation;

	private String image;

	private String name;

	//bi-directional many-to-one association to AppOwned
	@OneToMany(mappedBy="appGroup")
	private List<AppOwned> appOwneds;

	//bi-directional many-to-one association to AppPayment
	@OneToMany(mappedBy="appGroup")
	private List<AppPayment> appPayments;

	public AppGroup() {
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getFlagDeleted() {
		return this.flagDeleted;
	}

	public void setFlagDeleted(String flagDeleted) {
		this.flagDeleted = flagDeleted;
	}

	public String getIdUserCreation() {
		return this.idUserCreation;
	}

	public void setIdUserCreation(String idUserCreation) {
		this.idUserCreation = idUserCreation;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppOwned> getAppOwneds() {
		return this.appOwneds;
	}

	public void setAppOwneds(List<AppOwned> appOwneds) {
		this.appOwneds = appOwneds;
	}

	public AppOwned addAppOwned(AppOwned appOwned) {
		getAppOwneds().add(appOwned);
		appOwned.setAppGroup(this);

		return appOwned;
	}

	public AppOwned removeAppOwned(AppOwned appOwned) {
		getAppOwneds().remove(appOwned);
		appOwned.setAppGroup(null);

		return appOwned;
	}

	public List<AppPayment> getAppPayments() {
		return this.appPayments;
	}

	public void setAppPayments(List<AppPayment> appPayments) {
		this.appPayments = appPayments;
	}

	public AppPayment addAppPayment(AppPayment appPayment) {
		getAppPayments().add(appPayment);
		appPayment.setAppGroup(this);

		return appPayment;
	}

	public AppPayment removeAppPayment(AppPayment appPayment) {
		getAppPayments().remove(appPayment);
		appPayment.setAppGroup(null);

		return appPayment;
	}

}