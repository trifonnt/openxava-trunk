
// File generated by OpenXava: Tue Apr 05 09:23:46 CEST 2005
// Archivo generado por OpenXava: Tue Apr 05 09:23:46 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Seller		Entity/Entidad

package org.openxava.test.ejb.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.openxava.ejbx.*;
import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.validators.ValidationException;

import org.openxava.test.ejb.*;


/**
 * @ejb:bean name="Seller" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/Seller" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.ISeller"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Seller" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByLevel(java.lang.String id)" query="SELECT OBJECT(o) FROM Seller o WHERE o.level_id = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByLevel(java.lang.String id)" query="SELECT OBJECT(o) FROM Seller o WHERE o.level_id = ?1 " 	
 * @ejb:finder signature="Collection findAll()" query="SELECT OBJECT(o) FROM Seller o WHERE 1 = 1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findAll()" query="SELECT OBJECT(o) FROM Seller o WHERE 1 = 1" 
 * 
 * @jboss:table-name "XAVATEST_SELLER"
 *
 * @author Javier Paniza
 */
abstract public class SellerBean extends EJBReplicableBase 
			implements org.openxava.test.ejb.ISeller, EntityBean {	
			
	private boolean creating = false;		

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.SellerKey ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
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
	public org.openxava.test.ejb.SellerKey ejbCreate(org.openxava.test.ejb.SellerData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setData(data); 
		setNumber(data.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.SellerData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.SellerKey ejbCreate(org.openxava.test.ejb.SellerValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setSellerValue(value); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.SellerValue value) 
		throws
			CreateException,
			ValidationException {			
	}
	
	public void ejbLoad() {
		creating = false;
	}
	
	public void ejbStore() {
		if (creating) {
			creating = false;
			return;
		}			
	} 	
	
	// Properties/Propiedades 
	private org.openxava.converters.TrimStringConverter nameConverter;
	private org.openxava.converters.TrimStringConverter getNameConverter() {
		if (nameConverter == null) {
			try {
				nameConverter = (org.openxava.converters.TrimStringConverter) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Seller", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setName(String newName) {
		try {
			set_Name((java.lang.String) getNameConverter().toDB(newName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Seller", "String"));
		}		
	} 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "NUMBER"
	 */
	public abstract int getNumber();
	/**
	  * 
	  */
	public abstract void setNumber(int newNumber); 

	// Colecciones/Collections	

	private org.openxava.test.ejb.CustomerHome customersHome;
	/**
	 * @ejb:interface-method
	 */
	public void addToCustomers(org.openxava.test.ejb.Customer newElement) {
		if (newElement != null) { 
			try {
				newElement.setSellerKey((org.openxava.test.ejb.SellerKey) getEntityContext().getPrimaryKey());
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("add_collection_element_error", "Customer", "Seller"));
			}
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void removeFromCustomers(org.openxava.test.ejb.Customer toRemove) {
		if (toRemove != null) {
			try {
				toRemove.setSellerKey(null);
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("remove_collection_element_error", "Customer", "Seller"));
			}
		}
	} 

	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getCustomers() {		
		try {
			return getCustomersHome().findBySeller(getNumber());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "Customers", "Seller"));
		}
	}
		
	private org.openxava.test.ejb.CustomerHome getCustomersHome() throws Exception{
		if (customersHome == null) {
			customersHome = (org.openxava.test.ejb.CustomerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Customer"),
			 		org.openxava.test.ejb.CustomerHome.class);			 		
		}
		return customersHome;
	}		

	// References/Referencias 

	// Level : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.SellerLevel getLevel() {
		try {		
			return getLevelHome().findByPrimaryKey(getLevelKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Level", "Seller"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setLevel(org.openxava.test.ejb.SellerLevel newLevel) {
		try {	
			if (newLevel == null) setLevelKey(null);
			else setLevelKey((org.openxava.test.ejb.SellerLevelKey) newLevel.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Level", "Seller"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.SellerLevelKey getLevelKey() {				
			org.openxava.test.ejb.SellerLevelKey key = new org.openxava.test.ejb.SellerLevelKey(); 
			key.id = getLevel_id();		
			return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setLevelKey(org.openxava.test.ejb.SellerLevelKey key) {
		if (key == null) {
			key = new org.openxava.test.ejb.SellerLevelKey();
		} 
		setLevel_id(key.id);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "LEVEL"
	 */
	public abstract String getLevel_id();
	public abstract void setLevel_id(String newLevel_id); 

	private org.openxava.test.ejb.SellerLevelHome levelHome;	
	private org.openxava.test.ejb.SellerLevelHome getLevelHome() throws Exception{
		if (levelHome == null) {
			levelHome = (org.openxava.test.ejb.SellerLevelHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/SellerLevel"),
			 		org.openxava.test.ejb.SellerLevelHome.class);			 		
		}
		return levelHome;
	} 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Seller").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.SellerData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.SellerData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.SellerValue getSellerValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setSellerValue(org.openxava.test.ejb.SellerValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setNumber(0); 
		setName(null); 
	}
		
}