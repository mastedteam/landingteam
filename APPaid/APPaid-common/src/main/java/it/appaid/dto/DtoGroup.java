package it.appaid.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoGroup implements Serializable {
   
   private static final long serialVersionUID = 1L;

   private Long id_group;

   private String name;

   private String image;
   
   private String flag_deleted;
   
   private Date date_creation;

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

public Date getDate_creation() {
	return date_creation;
}

public void setDate_creation(Date date_creation) {
	this.date_creation = date_creation;
}

public String getId_user_creation() {
	return id_user_creation;
}

public void setId_user_creation(String id_user_creation) {
	this.id_user_creation = id_user_creation;
}
   
}