package org.openxava.test.ejb.xejb;

import java.util.*;
import javax.ejb.*;

import org.openxava.calculators.*;
import org.openxava.test.ejb.*;
import org.openxava.test.ejb.*;

/**
 * @ejb:bean name="Family" type="CMP" jndi-name="OpenXavaTest/ejb/openxava.test/Family" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 * 
 * @jboss:table-name "XAVATEST@separator@FAMILY"
 *
 * @author Javier Paniza
 */
abstract public class FamilyBean
	extends org.openxava.ejbx.EJBReplicableBase
	implements javax.ejb.EntityBean {
		
	private UUIDCalculator oidCalculator = new UUIDCalculator();
	
	
	/**
	  * @ejb:interface-method
	  * @ejb:pk-field
	  * @ejb:persistent-field
	  *
	  * @jboss:column-name "OID"
	  */
	public abstract String getOid();
	public abstract void setOid(String nuevoOid);
	
	/**
    * @ejb:interface-method
	  * @ejb:persistent-field
	  *
	  * @jboss:column-name "NUMBER"
	  */
	public abstract int getNumber();
	/**
	 * @ejb:interface-method
	 */
	public abstract void setNumber(int newNumber);

	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 *
	 * @jboss:column-name "DESCRIPTION"
	 */
	public abstract String getDescription();
	/**
	  * @ejb:interface-method
	  */
	public abstract void setDescription(String newDescription);	
	
	/**
	 * @ejb:create-method
	 */
	public FamilyKey ejbCreate(Map properties)
		throws
			javax.ejb.CreateException,
			org.openxava.validators.ValidationException,
			java.rmi.RemoteException {
		executeSets(properties);
		try {				
			setOid((String)oidCalculator.calculate());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException("Impossible to create Family because:\n" + ex.getLocalizedMessage());
		}			
		return null;
	}
	
	public void ejbPostCreate(Map properties) throws javax.ejb.CreateException {
	}
	
	

}