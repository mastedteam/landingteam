
package it.appaid.service.group;

import it.appaid.dto.DtoGroup;
import it.appaid.interfaces.group.EjbGroupLocal;
import it.appaid.interfaces.group.EjbGroupRemote;
import it.appaid.model.AppGroup;
import it.appaid.model.AppOwned;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 * Session Bean implementation class EjbGroupImpl
 */
@Stateless
public class EjbGroupImpl implements EjbGroupRemote, EjbGroupLocal {

	@Inject
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EjbGroupImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<DtoGroup> getGroupList() {
		
		TypedQuery<AppGroup> query =
			      em.createNamedQuery("AppGroup.findAll", AppGroup.class);
			  List<AppGroup> groupList = query.getResultList();
	      
	      List<DtoGroup> result = new ArrayList<DtoGroup>();
	      if(groupList!=null && !groupList.isEmpty()){
	    	  for(AppGroup group : groupList){
	    		  result.add(wrapModelToDto(group));	    		  
	    	  }
	    	  
	      }
		
		
		return result;
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
