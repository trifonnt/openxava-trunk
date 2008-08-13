
// File generated by OpenXava: Tue Aug 12 19:44:04 CEST 2008
// Archivo generado por OpenXava: Tue Aug 12 19:44:04 CEST 2008

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Driver		Entity/Entidad

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
 * @ejb:bean name="Driver" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Driver" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IDriver"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Driver" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByDrivingLicence(java.lang.String type, int level)" query="SELECT OBJECT(o) FROM Driver o WHERE o._Type = ?1 AND o._DrivingLicence_level = ?2 ORDER BY o._Number" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByDrivingLicence(java.lang.String type, int level)" query="SELECT OBJECT(o) FROM Driver o WHERE o._Type = ?1 AND o._DrivingLicence_level = ?2 ORDER BY o._Number" 	
 * @ejb:finder signature="Driver findByNumber(java.lang.Integer number)" query="SELECT OBJECT(o) FROM Driver o WHERE o._Number = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Driver findByNumber(java.lang.Integer number)" query="SELECT OBJECT(o) FROM Driver o WHERE o._Number = ?1" 
 * 
 * @jboss:table-name "XAVATEST.DRIVER"
 *
 * @author Javier Paniza
 */
abstract public class DriverBean extends EJBReplicableBase 
			implements org.openxava.test.model.IDriver, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DriverKey ejbCreate(Map values) 
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
	public org.openxava.test.model.DriverKey ejbCreate(org.openxava.test.model.DriverData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data);  
		set_Number(data.get_Number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DriverData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DriverKey ejbCreate(org.openxava.test.model.DriverValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setDriverValue(value); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DriverValue value) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Driver", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Driver", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter numberConverter;
	private org.openxava.converters.IConverter getNumberConverter() {
		if (numberConverter == null) {
			try {
				numberConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("number");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "number"));
			}
			
		}	
		return numberConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @jboss:column-name "NUMBER"
	 */
	public abstract java.lang.Integer get_Number();
	public abstract void set_Number(java.lang.Integer newNumber); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getNumber() {
		try {
			return ((Integer) getNumberConverter().toJava(get_Number())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Number", "Driver", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setNumber(int newNumber) {
		try { 
			this.modified = true; 
			set_Number((java.lang.Integer) getNumberConverter().toDB(new Integer(newNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Number", "Driver", "int"));
		}		
	} 
	private static org.openxava.converters.IConverter typeConverter;
	private org.openxava.converters.IConverter getTypeConverter() {
		if (typeConverter == null) {
			try {
				typeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("type");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "type"));
			}
			
		}	
		return typeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "TYPE"
	 */
	public abstract java.lang.String get_Type();
	public abstract void set_Type(java.lang.String newType); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getType() {
		try {
			return (String) getTypeConverter().toJava(get_Type());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Type", "Driver", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setType(String newType) {
		try { 
			this.modified = true; 
			set_Type((java.lang.String) getTypeConverter().toDB(newType));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Type", "Driver", "String"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// DrivingLicence : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IDrivingLicence getDrivingLicence() {
		try {		
			return getDrivingLicenceHome().findByPrimaryKey(getDrivingLicenceKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "DrivingLicence", "Driver"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DrivingLicenceRemote getDrivingLicenceRemote() {
		return (org.openxava.test.model.DrivingLicenceRemote) getDrivingLicence();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDrivingLicence(org.openxava.test.model.IDrivingLicence newDrivingLicence) { 
		this.modified = true; 
		try {	
			if (newDrivingLicence == null) setDrivingLicenceKey(null);
			else {
				if (newDrivingLicence instanceof org.openxava.test.model.DrivingLicence) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.DrivingLicenceRemote remote = (org.openxava.test.model.DrivingLicenceRemote) newDrivingLicence;
				setDrivingLicenceKey((org.openxava.test.model.DrivingLicenceKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "DrivingLicence", "Driver"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DrivingLicenceKey getDrivingLicenceKey() {				
		org.openxava.test.model.DrivingLicenceKey key = new org.openxava.test.model.DrivingLicenceKey(); 
		key.type = getDrivingLicence_type(); 
		key.level = getDrivingLicence_level();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setDrivingLicenceKey(org.openxava.test.model.DrivingLicenceKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.DrivingLicenceKey(); 
			setDrivingLicence_type(key.type); 
			setDrivingLicence_level(key.level);					
		}
		else { 
			setDrivingLicence_type(key.type); 
			setDrivingLicence_level(key.level);		
		}
	}
	/**		
	 * @ejb:interface-method
	 *
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getDrivingLicence_type() {
		return getType();
	}
	public void setDrivingLicence_type(String DrivingLicence_type) {
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DRIVINGLICENCE_LEVEL"
	 */
	public abstract int get_DrivingLicence_level();
	public abstract void set_DrivingLicence_level(int newDrivingLicence_level);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getDrivingLicence_level() { 
		return get_DrivingLicence_level(); 
	}
	public void setDrivingLicence_level(int newDrivingLicence_level) { 
		set_DrivingLicence_level(newDrivingLicence_level); 	
	} 

	private org.openxava.test.model.DrivingLicenceHome drivingLicenceHome;	
	private org.openxava.test.model.DrivingLicenceHome getDrivingLicenceHome() throws Exception{
		if (drivingLicenceHome == null) {
			drivingLicenceHome = (org.openxava.test.model.DrivingLicenceHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/DrivingLicence"),
			 		org.openxava.test.model.DrivingLicenceHome.class);			 		
		}
		return drivingLicenceHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Driver").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DriverData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.DriverData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DriverValue getDriverValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setDriverValue(org.openxava.test.model.DriverValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setNumber(0); 
		setName(null); 
		setType(null); 
		setDrivingLicenceKey(null); 	
	} 		
}