package it.appaid.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="app_user")

@NamedQueries(value = {
		@NamedQuery(name="AppUser.findOwned", query="select u, o from AppUser u join u.appOwneds o where u.idUser = :userId")
})
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USER")
	private int idUser;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_REGISTRATION")
	private Date dateRegistration;

	private String email;

	@Column(name="FLAG_DELETED")
	private String flagDeleted;

	private String image;

	private String name;

	@Column(name="NICK_NAME")
	private String nickName;

	private String password;

	private String surname;

	//bi-directional many-to-one association to AppOwned
	@OneToMany(mappedBy="appUser")
	private List<AppOwned> appOwneds;

	//bi-directional many-to-one association to AppPayment
	@OneToMany(mappedBy="appUser")
	private List<AppPayment> appPayments;

	//bi-directional many-to-one association to AppPaymentDetail
	@OneToMany(mappedBy="appUser")
	private List<AppPaymentDetail> appPaymentDetails;

	public AppUser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getDateRegistration() {
		return this.dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFlagDeleted() {
		return this.flagDeleted;
	}

	public void setFlagDeleted(String flagDeleted) {
		this.flagDeleted = flagDeleted;
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

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<AppOwned> getAppOwneds() {
		return this.appOwneds;
	}

	public void setAppOwneds(List<AppOwned> appOwneds) {
		this.appOwneds = appOwneds;
	}

	public AppOwned addAppOwned(AppOwned appOwned) {
		getAppOwneds().add(appOwned);
		appOwned.setAppUser(this);

		return appOwned;
	}

	public AppOwned removeAppOwned(AppOwned appOwned) {
		getAppOwneds().remove(appOwned);
		appOwned.setAppUser(null);

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
		appPayment.setAppUser(this);

		return appPayment;
	}

	public AppPayment removeAppPayment(AppPayment appPayment) {
		getAppPayments().remove(appPayment);
		appPayment.setAppUser(null);

		return appPayment;
	}

	public List<AppPaymentDetail> getAppPaymentDetails() {
		return this.appPaymentDetails;
	}

	public void setAppPaymentDetails(List<AppPaymentDetail> appPaymentDetails) {
		this.appPaymentDetails = appPaymentDetails;
	}

	public AppPaymentDetail addAppPaymentDetail(AppPaymentDetail appPaymentDetail) {
		getAppPaymentDetails().add(appPaymentDetail);
		appPaymentDetail.setAppUser(this);

		return appPaymentDetail;
	}

	public AppPaymentDetail removeAppPaymentDetail(AppPaymentDetail appPaymentDetail) {
		getAppPaymentDetails().remove(appPaymentDetail);
		appPaymentDetail.setAppUser(null);

		return appPaymentDetail;
	}

}