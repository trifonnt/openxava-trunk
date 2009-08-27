
// File generated by OpenXava: Wed Aug 26 12:46:58 CEST 2009
// Archivo generado por OpenXava: Wed Aug 26 12:46:58 CEST 2009

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Aggregate/Agregado: Receptionist

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
 * @ejb:bean name="Receptionist" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Receptionist" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IReceptionist"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Receptionist" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByDeliveryPlace(int oid)" query="SELECT OBJECT(o) FROM Receptionist o WHERE o._DeliveryPlace_oid = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByDeliveryPlace(int oid)" query="SELECT OBJECT(o) FROM Receptionist o WHERE o._DeliveryPlace_oid = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Collection findAll()" query="SELECT OBJECT(o) FROM Receptionist o" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findAll()" query="SELECT OBJECT(o) FROM Receptionist o" 
 * 
 * @jboss:table-name "XAVATEST.RECEPTIONIST"
 *
 * @author Javier Paniza
 */
abstract public class ReceptionistBean extends EJBReplicableBase 
			implements org.openxava.test.model.IReceptionist, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.ReceptionistKey ejbCreate(org.openxava.test.model.DeliveryPlaceRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		org.openxava.test.model.DeliveryPlaceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.DeliveryPlaceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Customer", "Receptionist"));
		} 
		setDeliveryPlace_oid(containerKey.oid); 
		try { 	
			org.openxava.calculators.NextIntegerCalculator oidCalculator = (org.openxava.calculators.NextIntegerCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setConnectionProvider(getPortableContext()); 
			setOid(((Integer) oidCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Receptionist", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryPlaceRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.ReceptionistKey ejbCreate(org.openxava.test.model.DeliveryPlaceKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		executeSets(values); 
		setDeliveryPlace_oid(containerKey.oid); 
		try { 	
			org.openxava.calculators.NextIntegerCalculator oidCalculator = (org.openxava.calculators.NextIntegerCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setConnectionProvider(getPortableContext()); 
			setOid(((Integer) oidCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Receptionist", ex.getLocalizedMessage()));
		} 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.model.DeliveryPlaceKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.ReceptionistKey ejbCreate(org.openxava.test.model.DeliveryPlaceRemote container, int counter, org.openxava.test.model.ReceptionistData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		org.openxava.test.model.DeliveryPlaceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.DeliveryPlaceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Customer", "Receptionist"));
		} 
		setDeliveryPlace_oid(containerKey.oid); 
		try { 	
			org.openxava.calculators.NextIntegerCalculator oidCalculator= (org.openxava.calculators.NextIntegerCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setConnectionProvider(getPortableContext()); 
			setOid(((Integer) oidCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Receptionist", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryPlaceRemote container, int counter, org.openxava.test.model.ReceptionistData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.ReceptionistKey ejbCreate(org.openxava.test.model.DeliveryPlaceRemote container, int counter, org.openxava.test.model.ReceptionistValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setReceptionistValue(value); 
		setOid(value.getOid()); 
		org.openxava.test.model.DeliveryPlaceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.DeliveryPlaceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Customer", "Receptionist"));
		} 
		setDeliveryPlace_oid(containerKey.oid); 
		try { 	
			org.openxava.calculators.NextIntegerCalculator oidCalculator = (org.openxava.calculators.NextIntegerCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setConnectionProvider(getPortableContext()); 
			setOid(((Integer) oidCalculator.calculate()).intValue()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Receptionist", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryPlaceRemote container, int counter, org.openxava.test.model.ReceptionistValue value) 
		throws
			CreateException,
			ValidationException { 			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.ReceptionistKey ejbCreate(org.openxava.test.model.DeliveryPlaceKey containerKey, int counter, org.openxava.test.model.ReceptionistValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		setReceptionistValue(value); 
		setOid(value.getOid());
		setDeliveryPlace_oid(containerKey.oid); 
		try { 
			org.openxava.calculators.NextIntegerCalculator oidCalculator= (org.openxava.calculators.NextIntegerCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setConnectionProvider(getPortableContext()); 
			setOid(((Integer) oidCalculator.calculate()).intValue());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "Receptionist", ex.getLocalizedMessage()));
		} 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryPlaceKey containerKey, int counter, org.openxava.test.model.ReceptionistValue value)	
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
	public abstract int getOid();
	/**
	  * 
	  */
	public abstract void setOid(int newOid); 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Receptionist", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Receptionist", "String"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// DeliveryPlace : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IDeliveryPlace getDeliveryPlace() {
		try {		
			return getDeliveryPlaceHome().findByPrimaryKey(getDeliveryPlaceKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "DeliveryPlace", "Receptionist"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DeliveryPlaceRemote getDeliveryPlaceRemote() {
		return (org.openxava.test.model.DeliveryPlaceRemote) getDeliveryPlace();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDeliveryPlace(org.openxava.test.model.IDeliveryPlace newDeliveryPlace) { 
		this.modified = true; 
		try {	
			if (newDeliveryPlace == null) setDeliveryPlaceKey(null);
			else {
				if (newDeliveryPlace instanceof org.openxava.test.model.DeliveryPlace) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.DeliveryPlaceRemote remote = (org.openxava.test.model.DeliveryPlaceRemote) newDeliveryPlace;
				setDeliveryPlaceKey((org.openxava.test.model.DeliveryPlaceKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "DeliveryPlace", "Receptionist"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DeliveryPlaceKey getDeliveryPlaceKey() {				
		org.openxava.test.model.DeliveryPlaceKey key = new org.openxava.test.model.DeliveryPlaceKey(); 
		key.oid = getDeliveryPlace_oid();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setDeliveryPlaceKey(org.openxava.test.model.DeliveryPlaceKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.DeliveryPlaceKey(); 
			setDeliveryPlace_oid(key.oid);					
		}
		else { 
			setDeliveryPlace_oid(key.oid);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DELIVERYPLACE"
	 */
	public abstract int get_DeliveryPlace_oid();
	public abstract void set_DeliveryPlace_oid(int newDeliveryPlace_oid);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getDeliveryPlace_oid() { 
		return get_DeliveryPlace_oid(); 
	}
	public void setDeliveryPlace_oid(int newDeliveryPlace_oid) { 
		set_DeliveryPlace_oid(newDeliveryPlace_oid); 	
	} 

	private org.openxava.test.model.DeliveryPlaceHome deliveryPlaceHome;	
	private org.openxava.test.model.DeliveryPlaceHome getDeliveryPlaceHome() throws Exception{
		if (deliveryPlaceHome == null) {
			deliveryPlaceHome = (org.openxava.test.model.DeliveryPlaceHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/DeliveryPlace"),
			 		org.openxava.test.model.DeliveryPlaceHome.class);			 		
		}
		return deliveryPlaceHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Customer").getMetaAggregate("Receptionist"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.ReceptionistData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.ReceptionistData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.ReceptionistValue getReceptionistValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setReceptionistValue(org.openxava.test.model.ReceptionistValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setOid(0); 
		setName(null); 
		setDeliveryPlaceKey(null); 	
	} 		
}