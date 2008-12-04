
// File generated by OpenXava: Tue Dec 02 16:39:39 CET 2008
// Archivo generado por OpenXava: Tue Dec 02 16:39:39 CET 2008

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Journey		Entity/Entidad

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
 * @ejb:bean name="Journey" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Journey" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IJourney"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Journey" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByAverageSpeed(java.lang.String oid)" query="SELECT OBJECT(o) FROM Journey o WHERE o._AverageSpeed_oid = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByAverageSpeed(java.lang.String oid)" query="SELECT OBJECT(o) FROM Journey o WHERE o._AverageSpeed_oid = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Journey findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Journey o WHERE o.oid = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Journey findByOid(java.lang.String oid)" query="SELECT OBJECT(o) FROM Journey o WHERE o.oid = ?1" 
 * 
 * @jboss:table-name "XAVATEST.JOURNEY"
 *
 * @author Javier Paniza
 */
abstract public class JourneyBean extends EJBReplicableBase 
			implements org.openxava.test.model.IJourney, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.JourneyKey ejbCreate(Map values) 
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
	public org.openxava.test.model.JourneyKey ejbCreate(org.openxava.test.model.JourneyData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setOid(data.getOid()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.JourneyData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.JourneyKey ejbCreate(org.openxava.test.model.JourneyValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setJourneyValue(value); 
		setOid(value.getOid()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.JourneyValue value) 
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
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "OID"
	 */
	public abstract String getOid();
	/**
	  * 
	  */
	public abstract void setOid(String newOid); 
	private static org.openxava.converters.IConverter descriptionConverter;
	private org.openxava.converters.IConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("description");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "description"));
			}
			
		}	
		return descriptionConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DESCRIPTION"
	 */
	public abstract java.lang.String get_Description();
	public abstract void set_Description(java.lang.String newDescription); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getDescription() {
		try {
			return (String) getDescriptionConverter().toJava(get_Description());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Journey", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDescription(String newDescription) {
		try { 
			this.modified = true; 
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Journey", "String"));
		}		
	} 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Journey", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Journey", "String"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// AverageSpeed : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IAverageSpeed getAverageSpeed() {
		try {		
			return getAverageSpeedHome().findByPrimaryKey(getAverageSpeedKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "AverageSpeed", "Journey"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.AverageSpeedRemote getAverageSpeedRemote() {
		return (org.openxava.test.model.AverageSpeedRemote) getAverageSpeed();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAverageSpeed(org.openxava.test.model.IAverageSpeed newAverageSpeed) { 
		this.modified = true; 
		try {	
			if (newAverageSpeed == null) setAverageSpeedKey(null);
			else {
				if (newAverageSpeed instanceof org.openxava.test.model.AverageSpeed) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.AverageSpeedRemote remote = (org.openxava.test.model.AverageSpeedRemote) newAverageSpeed;
				setAverageSpeedKey((org.openxava.test.model.AverageSpeedKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "AverageSpeed", "Journey"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.AverageSpeedKey getAverageSpeedKey() {				
		org.openxava.test.model.AverageSpeedKey key = new org.openxava.test.model.AverageSpeedKey(); 
		key.oid = getAverageSpeed_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setAverageSpeedKey(org.openxava.test.model.AverageSpeedKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.AverageSpeedKey(); 
			setAverageSpeed_oid(key.oid);					
		}
		else { 
			setAverageSpeed_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "AVERAGESPEED_OID"
	 */
	public abstract String get_AverageSpeed_oid();
	public abstract void set_AverageSpeed_oid(String newAverageSpeed_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getAverageSpeed_oid() { 
		return get_AverageSpeed_oid(); 
	}
	public void setAverageSpeed_oid(String newAverageSpeed_oid) { 
		set_AverageSpeed_oid(newAverageSpeed_oid); 	
	} 

	private org.openxava.test.model.AverageSpeedHome averageSpeedHome;	
	private org.openxava.test.model.AverageSpeedHome getAverageSpeedHome() throws Exception{
		if (averageSpeedHome == null) {
			averageSpeedHome = (org.openxava.test.model.AverageSpeedHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/AverageSpeed"),
			 		org.openxava.test.model.AverageSpeedHome.class);			 		
		}
		return averageSpeedHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Journey").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.JourneyData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.JourneyData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.JourneyValue getJourneyValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setJourneyValue(org.openxava.test.model.JourneyValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setOid(null); 
		setName(null); 
		setDescription(null); 
		setAverageSpeedKey(null); 	
	} 		
}