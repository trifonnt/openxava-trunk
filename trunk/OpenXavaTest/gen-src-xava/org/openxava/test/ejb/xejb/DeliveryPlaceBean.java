
// File generated by OpenXava: Mon Apr 18 09:24:45 CEST 2005
// Archivo generado por OpenXava: Mon Apr 18 09:24:45 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Aggregate/Agregado: DeliveryPlace

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
 * @ejb:bean name="DeliveryPlace" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/DeliveryPlace" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.IDeliveryPlace"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="DeliveryPlace" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByCustomer(int number)" query="SELECT OBJECT(o) FROM DeliveryPlace o WHERE o.customer_number = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByCustomer(int number)" query="SELECT OBJECT(o) FROM DeliveryPlace o WHERE o.customer_number = ?1 " 	
 * @ejb:finder signature="Collection findByPreferredWarehouse(java.lang.Integer number, int zoneNumber)" query="SELECT OBJECT(o) FROM DeliveryPlace o WHERE o.preferredWarehouse_number = ?1 AND o.preferredWarehouse_zoneNumber = ?2" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByPreferredWarehouse(java.lang.Integer number, int zoneNumber)" query="SELECT OBJECT(o) FROM DeliveryPlace o WHERE o.preferredWarehouse_number = ?1 AND o.preferredWarehouse_zoneNumber = ?2 " 
 * 
 * @jboss:table-name "XAVATEST_DELIVERYPLACE"
 *
 * @author Javier Paniza
 */
abstract public class DeliveryPlaceBean extends EJBReplicableBase 
			implements org.openxava.test.ejb.IDeliveryPlace, EntityBean {	
			
	private boolean creating = false;		

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.ejb.DeliveryPlaceKey ejbCreate(org.openxava.test.ejb.Customer container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		executeSets(values); 
		org.openxava.test.ejb.CustomerKey containerKey = null;
		try {
			containerKey = (org.openxava.test.ejb.CustomerKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Customer", "DeliveryPlace"));
		} 
		setCustomer_number(containerKey.number); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator = (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setEntity(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryPlace", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Customer container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.ejb.DeliveryPlaceKey ejbCreate(org.openxava.test.ejb.CustomerKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		executeSets(values); 
		setCustomer_number(containerKey.number); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator = (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setEntity(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryPlace", ex.getLocalizedMessage()));
		} 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.ejb.CustomerKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {			
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.ejb.DeliveryPlaceKey ejbCreate(org.openxava.test.ejb.Customer container, int counter, org.openxava.test.ejb.DeliveryPlaceData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setData(data); 
		org.openxava.test.ejb.CustomerKey containerKey = null;
		try {
			containerKey = (org.openxava.test.ejb.CustomerKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Customer", "DeliveryPlace"));
		} 
		setCustomer_number(containerKey.number); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator= (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setEntity(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryPlace", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Customer container, int counter, org.openxava.test.ejb.DeliveryPlaceData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.ejb.DeliveryPlaceKey ejbCreate(org.openxava.test.ejb.Customer container, int counter, org.openxava.test.ejb.DeliveryPlaceValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setDeliveryPlaceValue(value); 
		org.openxava.test.ejb.CustomerKey containerKey = null;
		try {
			containerKey = (org.openxava.test.ejb.CustomerKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Customer", "DeliveryPlace"));
		} 
		setCustomer_number(containerKey.number); 
		try { 	
			org.openxava.calculators.UUIDCalculator oidCalculator = (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setEntity(this); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryPlace", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Customer container, int counter, org.openxava.test.ejb.DeliveryPlaceValue value) 
		throws
			CreateException,
			ValidationException {			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.ejb.DeliveryPlaceKey ejbCreate(org.openxava.test.ejb.CustomerKey containerKey, int counter, org.openxava.test.ejb.DeliveryPlaceValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		setDeliveryPlaceValue(value);
		setCustomer_number(containerKey.number); 
		try { 
			org.openxava.calculators.UUIDCalculator oidCalculator= (org.openxava.calculators.UUIDCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setEntity(this); 
			setOid((String) oidCalculator.calculate());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryPlace", ex.getLocalizedMessage()));
		} 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.ejb.CustomerKey containerKey, int counter, org.openxava.test.ejb.DeliveryPlaceValue value)	
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
	private org.openxava.converters.TrimStringConverter remarksConverter;
	private org.openxava.converters.TrimStringConverter getRemarksConverter() {
		if (remarksConverter == null) {
			try {
				remarksConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("remarks");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "remarks"));
			}
			
		}	
		return remarksConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "REMARKS"
	 */
	public abstract java.lang.String get_Remarks();
	public abstract void set_Remarks(java.lang.String newRemarks); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getRemarks() {
		try {
			return (String) getRemarksConverter().toJava(get_Remarks());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "DeliveryPlace", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setRemarks(String newRemarks) {
		try {
			set_Remarks((java.lang.String) getRemarksConverter().toDB(newRemarks));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "DeliveryPlace", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter addressConverter;
	private org.openxava.converters.TrimStringConverter getAddressConverter() {
		if (addressConverter == null) {
			try {
				addressConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("address");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "address"));
			}
			
		}	
		return addressConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "ADDRESS"
	 */
	public abstract java.lang.String get_Address();
	public abstract void set_Address(java.lang.String newAddress); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getAddress() {
		try {
			return (String) getAddressConverter().toJava(get_Address());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address", "DeliveryPlace", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAddress(String newAddress) {
		try {
			set_Address((java.lang.String) getAddressConverter().toDB(newAddress));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address", "DeliveryPlace", "String"));
		}		
	} 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "DeliveryPlace", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "DeliveryPlace", "String"));
		}		
	} 

	// Colecciones/Collections	

	private org.openxava.test.ejb.ReceptionistHome receptionistsHome; 

	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getReceptionists() {		
		try {
			return getReceptionistsHome().findByDeliveryPlace(getOid());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "Receptionists", "DeliveryPlace"));
		}
	}
		
	private org.openxava.test.ejb.ReceptionistHome getReceptionistsHome() throws Exception{
		if (receptionistsHome == null) {
			receptionistsHome = (org.openxava.test.ejb.ReceptionistHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Receptionist"),
			 		org.openxava.test.ejb.ReceptionistHome.class);			 		
		}
		return receptionistsHome;
	}		

	// References/Referencias 

	// Customer : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Customer getCustomer() {
		try {		
			return getCustomerHome().findByPrimaryKey(getCustomerKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Customer", "DeliveryPlace"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setCustomer(org.openxava.test.ejb.Customer newCustomer) {
		try {	
			if (newCustomer == null) setCustomerKey(null);
			else setCustomerKey((org.openxava.test.ejb.CustomerKey) newCustomer.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Customer", "DeliveryPlace"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.CustomerKey getCustomerKey() {				
			org.openxava.test.ejb.CustomerKey key = new org.openxava.test.ejb.CustomerKey(); 
			key.number = getCustomer_number();		
			return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setCustomerKey(org.openxava.test.ejb.CustomerKey key) {
		if (key == null) {
			key = new org.openxava.test.ejb.CustomerKey();
		} 
		setCustomer_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "CUSTOMER"
	 */
	public abstract int getCustomer_number();
	public abstract void setCustomer_number(int newCustomer_number); 

	private org.openxava.test.ejb.CustomerHome customerHome;	
	private org.openxava.test.ejb.CustomerHome getCustomerHome() throws Exception{
		if (customerHome == null) {
			customerHome = (org.openxava.test.ejb.CustomerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Customer"),
			 		org.openxava.test.ejb.CustomerHome.class);			 		
		}
		return customerHome;
	} 

	// PreferredWarehouse : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Warehouse getPreferredWarehouse() {
		try {		
			return getPreferredWarehouseHome().findByPrimaryKey(getPreferredWarehouseKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "PreferredWarehouse", "DeliveryPlace"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setPreferredWarehouse(org.openxava.test.ejb.Warehouse newPreferredWarehouse) {
		try {	
			if (newPreferredWarehouse == null) setPreferredWarehouseKey(null);
			else setPreferredWarehouseKey((org.openxava.test.ejb.WarehouseKey) newPreferredWarehouse.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "PreferredWarehouse", "DeliveryPlace"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.WarehouseKey getPreferredWarehouseKey() {				
			org.openxava.test.ejb.WarehouseKey key = new org.openxava.test.ejb.WarehouseKey(); 
			key._Number = getPreferredWarehouse_number(); 
			key.zoneNumber = getPreferredWarehouse_zoneNumber();		
			return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setPreferredWarehouseKey(org.openxava.test.ejb.WarehouseKey key) {
		if (key == null) {
			key = new org.openxava.test.ejb.WarehouseKey();
		} 
		setPreferredWarehouse_number(key._Number); 
		setPreferredWarehouse_zoneNumber(key.zoneNumber);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "WAREHOUSE_ZONE"
	 */
	public abstract int getPreferredWarehouse_zoneNumber();
	public abstract void setPreferredWarehouse_zoneNumber(int newPreferredWarehouse_zoneNumber);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "WAREHOUSE_NUMBER"
	 */
	public abstract java.lang.Integer getPreferredWarehouse_number();
	public abstract void setPreferredWarehouse_number(java.lang.Integer newPreferredWarehouse_number); 

	private org.openxava.test.ejb.WarehouseHome preferredWarehouseHome;	
	private org.openxava.test.ejb.WarehouseHome getPreferredWarehouseHome() throws Exception{
		if (preferredWarehouseHome == null) {
			preferredWarehouseHome = (org.openxava.test.ejb.WarehouseHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Warehouse"),
			 		org.openxava.test.ejb.WarehouseHome.class);			 		
		}
		return preferredWarehouseHome;
	} 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Customer").getMetaAggregate("DeliveryPlace"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.DeliveryPlaceData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.DeliveryPlaceData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.DeliveryPlaceValue getDeliveryPlaceValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setDeliveryPlaceValue(org.openxava.test.ejb.DeliveryPlaceValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setOid(null); 
		setName(null); 
		setAddress(null); 
		setRemarks(null); 
	}
		
}