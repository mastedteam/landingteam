
package it.appaid.service.group;

import it.appaid.dao.group.DaoGroup;
import it.appaid.dto.DtoGroup;
import it.appaid.interfaces.group.EjbGroupLocal;
import it.appaid.interfaces.group.EjbGroupRemote;
import it.appaid.model.AppGroup;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Session Bean implementation class EjbGroupImpl
 */
@Stateless
public class EjbGroupImpl implements EjbGroupRemote, EjbGroupLocal {

	@EJB
	private DaoGroup dao;
	
	static final Logger logger = LogManager.getLogger(EjbGroupImpl.class);
	
    /**
     * Default constructor. 
     */
    public EjbGroupImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<DtoGroup> getGroupList() {
		try{
		logger.info("BEGIN");
		
//		TypedQuery<AppGroup> query = em.createNamedQuery("AppGroup.findAll", AppGroup.class);
//			  List<AppGroup> groupList = query.getResultList();
		List<AppGroup> groupList = dao.getGroups();
	      
	      List<DtoGroup> result = new ArrayList<DtoGroup>();
	      if(groupList!=null && !groupList.isEmpty()){
	    	  for(AppGroup group : groupList){
	    		  result.add(wrapModelToDto(group));	    		  
	    	  }
	    	  
	      }
		
		
		return result;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new EJBException(e);
		}
		finally{
			logger.info("END");
		}
	}
	
	private DtoGroup wrapModelToDto(AppGroup model){
		DtoGroup dto = new DtoGroup();
		if(model != null){
			dto.setId_user_creation(model.getIdUserCreation());
			dto.setId_group(new Long(model.getIdGroup()));
			dto.setName(model.getName());
			dto.setImage(model.getImage());
			dto.setDate_creation(model.getDateCreation());
			dto.setFlag_deleted(model.getFlagDeleted());
		}
		return dto;
	}

}
