package org.openxava.hibernate;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.event.*;
import org.openxava.mapping.*;
import org.openxava.model.meta.*;
import org.openxava.util.*;

/**
 * Allows to work easily with hibernate inside OpenXava applications. <p>
 * 
 * You can use this class in any part of your OpenXava application:
 * calculators, validators, actions, junit tests, etc.<br>
 * To use hibernate with this class you can write something as:
 * <pre>
 * Invoice invoice = new Invoice();
 * XHibernate.getSession().save(invoice);
 * </pre>
 * 
 * And no more.<br>
 * The method getSession() create a session and transaction the first time 
 * in the thread, and the OpenXava close the session at the end of action execution.<br>
 * Also the next code is legal:
 * <pre>
 * Invoice invoice = new Invoice();
 * XHibernate.getSession().save(invoice);
 * XHibernate.commit(); // In this way you commit and close manually.
 * ...
 * XHibernate.getSession().save(customer); // As session has been closed, a new one is created
 * </pre> 
 * 
 * @author Javier Paniza
 */

public class XHibernate {

	private static SessionFactory sessionFactory;	
	private static String configurationFile = "/hibernate.cfg.xml";	
	private static ThreadLocal currentSession = new ThreadLocal();	
	private static ThreadLocal currentTransaction = new ThreadLocal();


	/**
	 * Session associated to current thread. <p>
	 * 
	 * If no session exists or it's closed, then create a new one, and start a transaction.<br>
	 *
	 * @return Not null
	 */
	public static Session getSession() {
		Session s = (Session) currentSession.get();
		if (s == null || !s.isOpen()) {
			s = openSession();
		}
		return s;
	}
	
	private static Session openSession() {
		Session s = getSessionFactory().openSession();
		currentTransaction.set(s.beginTransaction());
		currentSession.set(s);
		return s;
	}
	
	/**
	 * Commits changes and closes the session associated to current thread. <p>
	 * 
	 * If no session or the it is closed this method does nothing.<br>
	 * In most cases this method is called by OpenXava automatically, 
	 * hence the programmer that uses hibernate APIs does not need to call it.
	 */
	public static void commit() {
		Session s = (Session) currentSession.get();
		if (s == null) return;
		if (s.isOpen()) {
			Transaction t = (Transaction) currentTransaction.get();
			t.commit();
			s.close();
		}
		if (!s.isOpen()) {			
			currentTransaction.set(null);
			currentSession.set(null);			
		}
	}
	
	/**
	 * Rollback changes and closes the session associated to current thread. <p>
	 * 
	 * If no session or the it is closed this method does nothing.<br>
	 */
	public static void rollback() {
		Session s = (Session) currentSession.get();
		if (s == null) return;
		if (s.isOpen()) {
			Transaction t = (Transaction) currentTransaction.get();
			t.rollback();
			s.close();
		}
		if (!s.isOpen()) {			
			currentTransaction.set(null);
			currentSession.set(null);			
		}
	}	
	
	private static SessionFactory createSessionFactory(String hibernateCfg) throws HibernateException {
		try {
			Configuration configuration = new Configuration().configure(hibernateCfg);			
			
			for (Iterator it = MetaModel.getAllGenerated().iterator(); it.hasNext();) {
				MetaModel model = (MetaModel) it.next();
				try {
					configuration.addResource(model.getName() + ".hbm.xml");
				}
				catch (Exception ex) {
					ex.printStackTrace();
					System.err.println(XavaResources.getString("hibernate_mapping_not_loaded_warning", model.getName())); 
				}
			}
			
				
			ReferenceConverterToDBListener referenceConverterToDBListener = new ReferenceConverterToDBListener();
			PreInsertEventListener [] preInsertListener = null;
			PreUpdateEventListener [] preUpdateListener = null;
			if (ReferenceMappingDetail.someMappingUsesConverters()) {
				// toJava conversion is not enabled because in references it's useless thus we avoid an unnecessary overload
				preInsertListener = new PreInsertEventListener [] { 
					referenceConverterToDBListener,
					new DefaultCalculatorsListener()
				};
				preUpdateListener = new PreUpdateEventListener [] { 
					referenceConverterToDBListener 
				};
			}
			else {
				preInsertListener = new PreInsertEventListener [] { 					
					new DefaultCalculatorsListener()
				};
				preUpdateListener = new PreUpdateEventListener [] {  
				};				
			}						
			configuration.getEventListeners().setPreInsertEventListeners(preInsertListener);
			configuration.getEventListeners().setPreUpdateEventListeners(preUpdateListener);
			
			return configuration.buildSessionFactory();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			throw new HibernateException(XavaResources.getString("hibernate_session_factory_creation_error"));
		}
	}

	private static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory(getConfigurationFile());
		}
		return sessionFactory; 
	}

	/**
	 * By default is <code>/hibernate.cfg.xml</code>. <p>
	 * 
	 * You must set value to this property before use any othe method of this class. 
	 */
	public static String getConfigurationFile() {
		return configurationFile;
	}

	/**
	 * By default is <code>/hibernate.cfg.xml</code>. <p>
	 * 
	 * You must set value to this property before use any othe method of this class. 
	 */	
	public static void setConfigurationFile(String configurationFile) {
		XHibernate.configurationFile = configurationFile;
	}
	
}
