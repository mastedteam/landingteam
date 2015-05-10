package it.appaid.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_payment database table.
 * 
 */
@Entity
@Table(name="app_payment")
@NamedQuery(name="AppPayment.findAll", query="SELECT a FROM AppPayment a")
public class AppPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PAYMENT")
	private int idPayment;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_PAYMENT")
	private Date datePayment;

	private String description;

	@Column(name="FLAG_DELETED")
	private String flagDeleted;

	private String note;

	//bi-directional many-to-one association to AppGroup
	@ManyToOne
	@JoinColumn(name="ID_GROUP")
	private AppGroup appGroup;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private AppUser appUser;

	//bi-directional many-to-one association to AppPaymentDetail
	@OneToMany(mappedBy="appPayment")
	private List<AppPaymentDetail> appPaymentDetails;

	public AppPayment() {
	}

	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDatePayment() {
		return this.datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlagDeleted() {
		return this.flagDeleted;
	}

	public void setFlagDeleted(String flagDeleted) {
		this.flagDeleted = flagDeleted;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public List<AppPaymentDetail> getAppPaymentDetails() {
		return this.appPaymentDetails;
	}

	public void setAppPaymentDetails(List<AppPaymentDetail> appPaymentDetails) {
		this.appPaymentDetails = appPaymentDetails;
	}

	public AppPaymentDetail addAppPaymentDetail(AppPaymentDetail appPaymentDetail) {
		getAppPaymentDetails().add(appPaymentDetail);
		appPaymentDetail.setAppPayment(this);

		return appPaymentDetail;
	}

	public AppPaymentDetail removeAppPaymentDetail(AppPaymentDetail appPaymentDetail) {
		getAppPaymentDetails().remove(appPaymentDetail);
		appPaymentDetail.setAppPayment(null);

		return appPaymentDetail;
	}

}