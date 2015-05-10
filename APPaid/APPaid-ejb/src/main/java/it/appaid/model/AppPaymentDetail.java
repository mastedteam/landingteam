package it.appaid.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the app_payment_detail database table.
 * 
 */
@Entity
@Table(name="app_payment_detail")
@NamedQuery(name="AppPaymentDetail.findAll", query="SELECT a FROM AppPaymentDetail a")
public class AppPaymentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PAYDET")
	private int idPaydet;

	@Temporal(TemporalType.DATE)
	private Date amount;

	@Column(name="FLAG_DELETED")
	private String flagDeleted;

	private String note;

	//bi-directional many-to-one association to AppPayment
	@ManyToOne
	@JoinColumn(name="ID_PAYMENT")
	private AppPayment appPayment;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private AppUser appUser;

	public AppPaymentDetail() {
	}

	public int getIdPaydet() {
		return this.idPaydet;
	}

	public void setIdPaydet(int idPaydet) {
		this.idPaydet = idPaydet;
	}

	public Date getAmount() {
		return this.amount;
	}

	public void setAmount(Date amount) {
		this.amount = amount;
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

	public AppPayment getAppPayment() {
		return this.appPayment;
	}

	public void setAppPayment(AppPayment appPayment) {
		this.appPayment = appPayment;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}