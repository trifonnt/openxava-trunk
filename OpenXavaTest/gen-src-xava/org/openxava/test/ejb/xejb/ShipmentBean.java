
// File generated by OpenXava: Mon Feb 21 11:43:50 CET 2005
// Archivo generado por OpenXava: Mon Feb 21 11:43:50 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Shipment		Entity/Entidad

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
 * @ejb:bean name="Shipment" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/Shipment" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.IShipment"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Shipment" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 
 * 
 * @jboss:table-name "XAVATEST@separator@SHIPMENT"
 *
 * @author Javier Paniza
 */
abstract public class ShipmentBean extends EJBReplicableBase 
			implements org.openxava.test.ejb.IShipment, EntityBean {	
			
	private boolean creating = false;		

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.ShipmentKey ejbCreate(Map values) 
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
	public org.openxava.test.ejb.ShipmentKey ejbCreate(org.openxava.test.ejb.ShipmentData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setData(data);  
		set_Type(data.get_Type()); 
		setNumber(data.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.ShipmentData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.ShipmentKey ejbCreate(org.openxava.test.ejb.ShipmentValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setShipmentValue(value); 
		setType(value.getType()); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.ShipmentValue value) 
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
	private org.openxava.converters.ValidValuesBase0Converter typeConverter;
	private org.openxava.converters.ValidValuesBase0Converter getTypeConverter() {
		if (typeConverter == null) {
			try {
				typeConverter = (org.openxava.converters.ValidValuesBase0Converter) 
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
	 * @ejb:pk-field
	 * @jboss:column-name "TYPE"
	 */
	public abstract java.lang.Integer get_Type();
	public abstract void set_Type(java.lang.Integer newType); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getType() {
		try {
			return ((Integer) getTypeConverter().toJava(get_Type())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Type", "Shipment", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setType(int newType) {
		try {
			set_Type((java.lang.Integer) getTypeConverter().toDB(new Integer(newType)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Type", "Shipment", "int"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter descriptionConverter;
	private org.openxava.converters.TrimStringConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.TrimStringConverter) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Shipment", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDescription(String newDescription) {
		try {
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Shipment", "String"));
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

	// References/Referencias 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Shipment").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.ShipmentData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.ShipmentData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.ShipmentValue getShipmentValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setShipmentValue(org.openxava.test.ejb.ShipmentValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setType(0); 
		setNumber(0); 
		setDescription(null); 
	}
		
}