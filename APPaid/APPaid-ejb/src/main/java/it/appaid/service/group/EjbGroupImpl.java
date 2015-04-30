<<<<<<< HEAD
package it.appaid.service.group;

import it.appaid.interfaces.group.EjbGroupLocal;
import it.appaid.interfaces.group.EjbGroupRemote;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class EjbGroupImpl
 */
@Stateless
public class EjbGroupImpl implements EjbGroupRemote, EjbGroupLocal {

    /**
     * Default constructor. 
     */
    public EjbGroupImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getGroupList() {
		return "lista gruppi";
	}

}
=======
package it.appaid.service.group;

import java.rmi.RemoteException;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class EjbGroupImpl
 */
@Stateless
public class EjbGroupImpl {

    /**
     * Default constructor. 
     */
    public EjbGroupImpl() {
        // TODO Auto-generated constructor stub
    }

	
	public String getTestString(){
		
		return "sto cazzo";
	}

}
>>>>>>> branch 'develop' of https://github.com/mastedteam/landingteam.git
