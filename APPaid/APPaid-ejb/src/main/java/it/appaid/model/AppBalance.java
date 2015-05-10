package it.appaid.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the app_balance database table.
 * 
 */
@Entity
@Table(name="app_balance")
@IdClass(BalanceId.class)
@NamedQuery(name="AppBalance.findAll", query="SELECT a FROM AppBalance a")
public class AppBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal balance;
	
	@Id
	@Column(name="ID_GROUP")
	private int idGroup;

	@Id
	@Column(name="ID_USER")
	private int idUser;

	private String note;

	public AppBalance() {
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}