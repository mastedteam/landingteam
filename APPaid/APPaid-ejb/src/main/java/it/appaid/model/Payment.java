package it.appaid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table
public class Payment implements Serializable {
   /** Default value included to remove warning. Remove or modify at will. **/
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Integer id_payment;
   
   @NotNull
   @NotEmpty
   private Integer id_user;
   
   @NotNull
   @NotEmpty
   private Integer id_group;

   private String description;
   
   @NotNull
   @NotEmpty
   private Float amount;

   @NotNull
   @NotEmpty
   private String flag_deleted;
   
   @NotNull
   @NotEmpty
   private String date_payment;
   
   @NotNull
   @NotEmpty
   private String note;

public Integer getId_payment() {
	return id_payment;
}

public void setId_payment(Integer id_payment) {
	this.id_payment = id_payment;
}

public Integer getId_user() {
	return id_user;
}

public void setId_user(Integer id_user) {
	this.id_user = id_user;
}

public Integer getId_group() {
	return id_group;
}

public void setId_group(Integer id_group) {
	this.id_group = id_group;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Float getAmount() {
	return amount;
}

public void setAmount(Float amount) {
	this.amount = amount;
}

public String getFlag_deleted() {
	return flag_deleted;
}

public void setFlag_deleted(String flag_deleted) {
	this.flag_deleted = flag_deleted;
}

public String getDate_payment() {
	return date_payment;
}

public void setDate_payment(String date_payment) {
	this.date_payment = date_payment;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}


}