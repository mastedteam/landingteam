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
public class Group implements Serializable {
   /** Default value included to remove warning. Remove or modify at will. **/
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id_group;

   @NotNull
   @Size(min = 1, max = 25)
   @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
   private String name;

   private String image;
   
   @NotNull
   @NotEmpty
   private String flag_deleted;
   
   @NotNull
   @NotEmpty
   private String date_creation;

   @NotNull
   @NotEmpty
   private String id_user_creation;

public Long getId_group() {
	return id_group;
}

public void setId_group(Long id_group) {
	this.id_group = id_group;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getFlag_deleted() {
	return flag_deleted;
}

public void setFlag_deleted(String flag_deleted) {
	this.flag_deleted = flag_deleted;
}

public String getDate_creation() {
	return date_creation;
}

public void setDate_creation(String date_creation) {
	this.date_creation = date_creation;
}

public String getId_user_creation() {
	return id_user_creation;
}

public void setId_user_creation(String id_user_creation) {
	this.id_user_creation = id_user_creation;
}
   
}