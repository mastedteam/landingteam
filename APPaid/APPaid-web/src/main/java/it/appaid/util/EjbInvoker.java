package it.appaid.util;

import it.appaid.interfaces.group.EjbGroupRemote;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbInvoker {

	private static EjbInvoker instance;
	private Context context;
	private final String moduleName = "APPaid-ejb-1.0-SNAPSHOT";
	private final String distinctName = "";
	private String appName;
	
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
	
	public EjbGroupRemote lookupEjbGroupImpl() throws NamingException{	
		final String beanName = "EjbGroupImpl";
        final String viewClassName = EjbGroupRemote.class.getName();
        EjbGroupRemote ejbRemote = (EjbGroupRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        return ejbRemote;
	}
	
}
