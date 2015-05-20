package it.appaid.rest;


import it.appaid.dto.DtoGroup;
import it.appaid.interfaces.group.EjbGroupRemote;
import it.appaid.util.EjbInvoker;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 

@Path("/groups")
@RequestScoped
public class GroupRS {

	static final Logger logger = LogManager.getLogger(GroupRS.class);
	
	private EjbGroupRemote service;

	@GET
	@Produces("text/json")
	@Path("/all")
	public List<DtoGroup> listAllMembers() throws Exception {
		try{
		logger.info("BEGIN");
		List<DtoGroup> group = null;
		try {
//			service = EjbInvoker.getInstance().lookupEjbGroupImpl();
			service = (EjbGroupRemote)EjbInvoker.getInstance().lookupEjb(EjbGroupRemote.class, "EjbGroupImpl");
			group = service.getGroupList();
		} catch (NamingException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		
		return group;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			throw e;
		}finally{
			logger.info("END");
		}
		 
   }

//   @GET
//   @Path("/{id:[0-9][0-9]*}")
//   @Produces("text/xml")
//   public Member lookupMemberById(@PathParam("id") long id) {
//      return em.find(Member.class, id);
//   }
	

}
