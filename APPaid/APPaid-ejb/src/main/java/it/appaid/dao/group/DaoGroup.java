package it.appaid.dao.group;

import it.appaid.model.AppGroup;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Session Bean implementation class DaoGroup
 */
@Stateless
@LocalBean
public class DaoGroup {
	
	@Inject
	private EntityManager em;
	
	
	static final Logger logger = LogManager.getLogger(DaoGroup.class);
    /**
     * Default constructor. 
     */
    public DaoGroup() {
    }
    
    public List<AppGroup> getGroups(){
    	logger.info("BEGIN");
    	try{
    		TypedQuery<AppGroup> query = em.createNamedQuery("AppGroup.findAll", AppGroup.class);
    		List<AppGroup> groupList = query.getResultList();
    		return groupList;
    	}catch(Exception e){
    		logger.error(e.getMessage());
    		throw new EJBException(e);
    	}finally{
    		logger.info("END");
    	}
    }
    
    public List<AppGroup> getGroupsByUser(String userId){
    	logger.info("BEGIN");
    	try{
    		TypedQuery<AppGroup> query = em.createNamedQuery("AppGroup.findAll", AppGroup.class);
    		List<AppGroup> groupList = query.getResultList();
    		return groupList;
    	}catch(Exception e){
    		logger.error(e.getMessage());
    		throw new EJBException(e);
    	}finally{
    		logger.info("END");
    	}
    }

}
