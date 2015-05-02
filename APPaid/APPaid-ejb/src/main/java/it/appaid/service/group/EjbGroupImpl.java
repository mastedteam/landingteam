
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
