package it.appaid.util;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singleton class to invoke ejb
 * @author manuel
 *
 */
public class EjbInvoker {

	private static EjbInvoker instance;
	private Context context;
	private final String moduleName = "APPaid-ejb-1.0-SNAPSHOT";
	private final String distinctName = "";
	private String appName;
	
	static final Logger logger = LogManager.getLogger(EjbInvoker.class);
	
	private EjbInvoker() throws NamingException{
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        context = new InitialContext(jndiProperties);
        appName = (String) context.lookup("java:app/AppName");
	}
	
	public static EjbInvoker getInstance() throws NamingException{
		if(instance == null){
			instance = new EjbInvoker();
		}
		return instance;
	}
	
//	public EjbGroupRemote lookupEjbGroupImpl() throws NamingException{	
//		final String beanName = "EjbGroupImpl";
//        final String viewClassName = EjbGroupRemote.class.getName();
//        String lookupName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
//        logger.debug("APPaid-web --- lookupName: "+lookupName);
//        EjbGroupRemote ejbRemote = (EjbGroupRemote) context.lookup(lookupName);
//        return ejbRemote;
//	}
	
	public <T> Object lookupEjb(Class<T> ClassType, String beanName) throws NamingException{
		final String viewClassName = ClassType.getName();
		String lookupName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        logger.debug("APPaid-web --- lookupName: "+lookupName);
		return context.lookup(lookupName);
	}
	
}
