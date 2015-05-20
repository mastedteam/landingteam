package it.appaid.dao.payment;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Session Bean implementation class DaoGroup
 */
@Stateless
@LocalBean
public class DaoPayment {
	
	static final Logger logger = LogManager.getLogger(DaoPayment.class);
    /**
     * Default constructor. 
     */
    public DaoPayment() {
    }
    

}
