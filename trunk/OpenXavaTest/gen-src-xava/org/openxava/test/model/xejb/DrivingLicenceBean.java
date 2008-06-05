
// File generated by OpenXava: Wed Jun 04 12:16:08 CEST 2008
// Archivo generado por OpenXava: Wed Jun 04 12:16:08 CEST 2008

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: DrivingLicence		Entity/Entidad

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
 * @ejb:bean name="DrivingLicence" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/DrivingLicence" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IDrivingLicence"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="DrivingLicence" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="DrivingLicence findByTypeLevel(java.lang.String type,int level)" query="SELECT OBJECT(o) FROM DrivingLicence o WHERE o.type = ?1 and o.level = ?2" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="DrivingLicence findByTypeLevel(java.lang.String type,int level)" query="SELECT OBJECT(o) FROM DrivingLicence o WHERE o.type = ?1 and o.level = ?2" 
 * 
 * @jboss:table-name "XAVATEST.DRIVINGLICENCE"
 *
 * @author Javier Paniza
 */
abstract public class DrivingLicenceBean extends EJBReplicableBase 
			implements org.openxava.test.model.IDrivingLicence, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DrivingLicenceKey ejbCreate(Map values) 
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
	public org.openxava.test.model.DrivingLicenceKey ejbCreate(org.openxava.test.model.DrivingLicenceData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setType(data.getType()); 
		setLevel(data.getLevel()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DrivingLicenceData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DrivingLicenceKey ejbCreate(org.openxava.test.model.DrivingLicenceValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setDrivingLicenceValue(value); 
		setType(value.getType()); 
		setLevel(value.getLevel()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DrivingLicenceValue value) 
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
	 * @jboss:column-name "LEVEL"
	 */
	public abstract int getLevel();
	/**
	  * 
	  */
	public abstract void setLevel(int newLevel); 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "DrivingLicence", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "DrivingLicence", "String"));
		}		
	} 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "TYPE"
	 */
	public abstract String getType();
	/**
	  * 
	  */
	public abstract void setType(String newType); 

	// Colecciones/Collections		

	// References/Referencias 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("DrivingLicence").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DrivingLicenceData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.DrivingLicenceData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DrivingLicenceValue getDrivingLicenceValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setDrivingLicenceValue(org.openxava.test.model.DrivingLicenceValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setType(null); 
		setLevel(0); 
		setDescription(null); 	
	} 		
}