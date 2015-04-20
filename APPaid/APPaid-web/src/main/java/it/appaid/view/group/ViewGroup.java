package it.appaid.view.group;


import it.appaid.controller.group.ControllerGroup;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Path("/groups")
@RequestScoped
public class ViewGroup {

	@Inject
	private ControllerGroup controller;
	
	static final Logger logger = LogManager.getLogger(ControllerGroup.class);

	@GET
	@Produces("text/json")
	public String listAllMembers() {
		logger.info("provaaa");
		logger.debug("prova debug");
	   return controller.getTestString();
   }

//   @GET
//   @Path("/{id:[0-9][0-9]*}")
//   @Produces("text/xml")
//   public Member lookupMemberById(@PathParam("id") long id) {
//      return em.find(Member.class, id);
//   }
   
}
