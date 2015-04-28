package it.appaid.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table
public class User implements Serializable {
   /** Default value included to remove warning. Remove or modify at will. **/
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Integer id_user;

   @NotNull
   @Size(min = 1, max = 25)
   @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
   private String name;
   
   @NotNull
   @Size(min = 1, max = 25)
   @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
   private String surname;

   private String image;
   
   @NotNull
   @NotEmpty
   @Email
   private String email;
   
   private String nick_name;
   
   @NotNull
   @NotEmpty
   private String flag_deleted;
   
   @NotNull
   @NotEmpty
   private String password;
   
   @NotNull
   @NotEmpty
   private String date_registration;

public Integer getId_user() {
	return id_user;
}

public void setId_user(Integer id_user) {
	this.id_user = id_user;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNick_name() {
	return nick_name;
}

public void setNick_name(String nick_name) {
	this.nick_name = nick_name;
}

public String getFlag_deleted() {
	return flag_deleted;
}

public void setFlag_deleted(String flag_deleted) {
	this.flag_deleted = flag_deleted;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getDate_registration() {
	return date_registration;
}

public void setDate_registration(String date_registration) {
	this.date_registration = date_registration;
}


   
}