package it.appaid.dao.user;

import it.appaid.model.AppOwned;
import it.appaid.model.AppUser;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Session Bean implementation class DaoGroup
 */
@Stateless
@LocalBean
public class DaoUser {
	
	static final Logger logger = LogManager.getLogger(DaoUser.class);
    /**
     * Default constructor. 
     */
    public DaoUser() {
    }
    
    public List<AppUser> getOwned(String userId){
    	
    	
    	
    	return null;
    }

}
