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
