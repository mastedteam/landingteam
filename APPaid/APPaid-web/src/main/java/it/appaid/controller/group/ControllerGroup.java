package it.appaid.controller.group;

import it.appaid.service.group.EjbGroupImpl;

import javax.inject.Inject;

public class ControllerGroup {

	 @Inject
	 private EjbGroupImpl service;
	 
	 public String getTestString(){
		 return service.getTestString();
	 }
	 
}
