
// File generated by OpenXava: Fri Nov 10 13:06:22 CET 2006
// Archivo generado por OpenXava: Fri Nov 10 13:06:22 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: CustomerContactPerson		Entity/Entidad

package org.openxava.test.model.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.openxava.ejbx.*;
import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.validators.ValidationException;

import org.openxava.test.model.*;


/**
 * @ejb:bean name="CustomerContactPerson" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/CustomerContactPerson" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ICustomerContactPerson"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="CustomerContactPerson" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByCustomer(int number)" query="SELECT OBJECT(o) FROM CustomerContactPerson o WHERE o._Customer_number = ?1 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByCustomer(int number)" query="SELECT OBJECT(o) FROM CustomerContactPerson o WHERE o._Customer_number = ?1 " 
 * 
 * @jboss:table-name "XAVATEST_CUSTOMERCONTACTPERSON"
 *
 * @author Javier Paniza
 */
abstract public class CustomerContactPersonBean extends EJBReplicableBase 
			implements org.openxava.test.model.ICustomerContactPerson, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CustomerContactPersonKey ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
			
		return null;
	} 
	public void ejbPostCreate(Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CustomerContactPersonKey ejbCreate(org.openxava.test.model.CustomerContactPersonData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data);  
		set_Customer_number(data.get_Customer_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.CustomerContactPersonData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CustomerContactPersonKey ejbCreate(org.openxava.test.model.CustomerContactPersonValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setCustomerContactPersonValue(value); 
		setCustomer_number(value.getCustomer_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.CustomerContactPersonValue value) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	public void ejbLoad() {
		creating = false;
		modified = false; 
	}
	
	public void ejbStore() {
		if (creating) {
			creating = false;
			return;
		}
		if (!modified) return; 
		
		modified = false;
	} 	
	

	public void ejbRemove() throws RemoveException { 						
	} 	
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter nameConverter;
	private org.openxava.converters.IConverter getNameConverter() {
		if (nameConverter == null) {
			try {
				nameConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("name");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "name"));
			}
			
		}	
		return nameConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "NAME"
	 */
	public abstract java.lang.String get_Name();
	public abstract void set_Name(java.lang.String newName); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getName() {
		try {
			return (String) getNameConverter().toJava(get_Name());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "CustomerContactPerson", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setName(String newName) {
		try { 
			this.modified = true; 
			set_Name((java.lang.String) getNameConverter().toDB(newName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "CustomerContactPerson", "String"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// Customer : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.ICustomer getCustomer() {
		try {		
			return getCustomerHome().findByPrimaryKey(getCustomerKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Customer", "CustomerContactPerson"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.CustomerRemote getCustomerRemote() {
		return (org.openxava.test.model.CustomerRemote) getCustomer();
	}
	
	/**
	 * 
	 */
	public void setCustomer(org.openxava.test.model.ICustomer newCustomer) { 
		this.modified = true; 
		try {	
			if (newCustomer == null) setCustomerKey(null);
			else {
				if (newCustomer instanceof org.openxava.test.model.Customer) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.CustomerRemote remote = (org.openxava.test.model.CustomerRemote) newCustomer;
				setCustomerKey((org.openxava.test.model.CustomerKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Customer", "CustomerContactPerson"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.CustomerKey getCustomerKey() {				
		org.openxava.test.model.CustomerKey key = new org.openxava.test.model.CustomerKey(); 
		key.number = getCustomer_number();		
		return key;
	}	
	
	/**
	 * 
	 */
	public void setCustomerKey(org.openxava.test.model.CustomerKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.CustomerKey(); 
			setCustomer_number(key.number);					
		}
		else { 
			setCustomer_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @jboss:column-name "CUSTOMER_NUMBER"
	 */
	public abstract int get_Customer_number();
	public abstract void set_Customer_number(int newCustomer_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getCustomer_number() { 
		return get_Customer_number(); 
	}
	public void setCustomer_number(int newCustomer_number) { 
		set_Customer_number(newCustomer_number); 	
	} 

	private org.openxava.test.model.CustomerHome customerHome;	
	private org.openxava.test.model.CustomerHome getCustomerHome() throws Exception{
		if (customerHome == null) {
			customerHome = (org.openxava.test.model.CustomerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Customer"),
			 		org.openxava.test.model.CustomerHome.class);			 		
		}
		return customerHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("CustomerContactPerson").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CustomerContactPersonData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.CustomerContactPersonData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CustomerContactPersonValue getCustomerContactPersonValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setCustomerContactPersonValue(org.openxava.test.model.CustomerContactPersonValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setName(null); 
		setCustomerKey(null); 	
	} 		
}