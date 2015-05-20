
package it.appaid.service.payment;

import it.appaid.dao.payment.DaoPayment;
import it.appaid.interfaces.payment.EjbPaymentLocal;
import it.appaid.interfaces.payment.EjbPaymentRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Session Bean implementation class EjbGroupImpl
 */
@Stateless
public class EjbPaymentImpl implements EjbPaymentRemote, EjbPaymentLocal {

	@EJB
	private DaoPayment dao;
	
	static final Logger logger = LogManager.getLogger(EjbPaymentImpl.class);
	
    /**
     * Default constructor. 
     */
    public EjbPaymentImpl() {
        // TODO Auto-generated constructor stub
    }

}
