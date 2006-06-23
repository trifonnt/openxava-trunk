
// File generated by OpenXava: Thu Jun 22 12:45:22 CEST 2006
// Archivo generado por OpenXava: Thu Jun 22 12:45:22 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Delivery		Aggregate/Agregado: DeliveryDetail

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
 * @ejb:bean name="DeliveryDetail" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/DeliveryDetail" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IDeliveryDetail"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="DeliveryDetail" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByDelivery(int invoice_year, int invoice_number, int type_number, int number)" query="SELECT OBJECT(o) FROM DeliveryDetail o WHERE o._Delivery_invoice_year = ?1 AND o._Delivery_invoice_number = ?2 AND o._Delivery_type_number = ?3 AND o._Delivery_number = ?4 ORDER BY o.number" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByDelivery(int invoice_year, int invoice_number, int type_number, int number)" query="SELECT OBJECT(o) FROM DeliveryDetail o WHERE o._Delivery_invoice_year = ?1 AND o._Delivery_invoice_number = ?2 AND o._Delivery_type_number = ?3 AND o._Delivery_number = ?4 ORDER BY o.number" 
 * 
 * @jboss:table-name "XAVATEST_DELIVERYDETAIL"
 *
 * @author Javier Paniza
 */
abstract public class DeliveryDetailBean extends EJBReplicableBase 
			implements org.openxava.test.model.IDeliveryDetail, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.DeliveryDetailKey ejbCreate(org.openxava.test.model.DeliveryRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		org.openxava.test.model.DeliveryKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.DeliveryKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Delivery", "DeliveryDetail"));
		} 
		setDelivery_invoice_year(containerKey._Invoice_year); 
		setDelivery_invoice_number(containerKey._Invoice_number); 
		setDelivery_type_number(containerKey._Type_number); 
		setDelivery_number(containerKey.number); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.DeliveryDetailKey ejbCreate(org.openxava.test.model.DeliveryKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		executeSets(values); 
		setDelivery_invoice_year(containerKey._Invoice_year); 
		setDelivery_invoice_number(containerKey._Invoice_number); 
		setDelivery_type_number(containerKey._Type_number); 
		setDelivery_number(containerKey.number); 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.model.DeliveryKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.DeliveryDetailKey ejbCreate(org.openxava.test.model.DeliveryRemote container, int counter, org.openxava.test.model.DeliveryDetailData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		org.openxava.test.model.DeliveryKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.DeliveryKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Delivery", "DeliveryDetail"));
		} 
		setDelivery_invoice_year(containerKey._Invoice_year); 
		setDelivery_invoice_number(containerKey._Invoice_number); 
		setDelivery_type_number(containerKey._Type_number); 
		setDelivery_number(containerKey.number); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryRemote container, int counter, org.openxava.test.model.DeliveryDetailData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.DeliveryDetailKey ejbCreate(org.openxava.test.model.DeliveryRemote container, int counter, org.openxava.test.model.DeliveryDetailValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setDeliveryDetailValue(value); 
		setNumber(value.getNumber()); 
		org.openxava.test.model.DeliveryKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.DeliveryKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Delivery", "DeliveryDetail"));
		} 
		setDelivery_invoice_year(containerKey._Invoice_year); 
		setDelivery_invoice_number(containerKey._Invoice_number); 
		setDelivery_type_number(containerKey._Type_number); 
		setDelivery_number(containerKey.number); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryRemote container, int counter, org.openxava.test.model.DeliveryDetailValue value) 
		throws
			CreateException,
			ValidationException { 			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.DeliveryDetailKey ejbCreate(org.openxava.test.model.DeliveryKey containerKey, int counter, org.openxava.test.model.DeliveryDetailValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		setDeliveryDetailValue(value); 
		setNumber(value.getNumber());
		setDelivery_invoice_year(containerKey._Invoice_year);
		setDelivery_invoice_number(containerKey._Invoice_number);
		setDelivery_type_number(containerKey._Type_number);
		setDelivery_number(containerKey.number); 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryKey containerKey, int counter, org.openxava.test.model.DeliveryDetailValue value)	
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "DeliveryDetail", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "DeliveryDetail", "String"));
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

	// Delivery : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IDelivery getDelivery() {
		try {		
			return getDeliveryHome().findByPrimaryKey(getDeliveryKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Delivery", "DeliveryDetail"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DeliveryRemote getDeliveryRemote() {
		return (org.openxava.test.model.DeliveryRemote) getDelivery();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDelivery(org.openxava.test.model.IDelivery newDelivery) { 
		this.modified = true; 
		try {	
			if (newDelivery == null) setDeliveryKey(null);
			else {
				if (newDelivery instanceof org.openxava.test.model.Delivery) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.DeliveryRemote remote = (org.openxava.test.model.DeliveryRemote) newDelivery;
				setDeliveryKey((org.openxava.test.model.DeliveryKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Delivery", "DeliveryDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DeliveryKey getDeliveryKey() {				
		org.openxava.test.model.DeliveryKey key = new org.openxava.test.model.DeliveryKey(); 
		key._Invoice_year = get_Delivery_invoice_year(); 
		key._Invoice_number = get_Delivery_invoice_number(); 
		key._Type_number = get_Delivery_type_number(); 
		key.number = getDelivery_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setDeliveryKey(org.openxava.test.model.DeliveryKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.DeliveryKey(); 
			setDelivery_invoice_year(key._Invoice_year); 
			setDelivery_invoice_number(key._Invoice_number); 
			setDelivery_type_number(key._Type_number); 
			setDelivery_number(key.number);					
		}
		else { 
			set_Delivery_invoice_year(key._Invoice_year); 
			set_Delivery_invoice_number(key._Invoice_number); 
			set_Delivery_type_number(key._Type_number); 
			setDelivery_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DELIVERY_NUMBER"
	 */
	public abstract int get_Delivery_number();
	public abstract void set_Delivery_number(int newDelivery_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getDelivery_number() { 
		return get_Delivery_number(); 
	}
	public void setDelivery_number(int newDelivery_number) { 
		set_Delivery_number(newDelivery_number); 	
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DELIVERY_TYPE_NUMBER"
	 */
	public abstract int get_Delivery_type_number();
	public abstract void set_Delivery_type_number(int newDelivery_type_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getDelivery_type_number() { 
		return get_Delivery_type_number(); 
	}
	public void setDelivery_type_number(int newDelivery_type_number) { 
		set_Delivery_type_number(newDelivery_type_number); 	
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DELIVERY_INVOICE_YEAR"
	 */
	public abstract int get_Delivery_invoice_year();
	public abstract void set_Delivery_invoice_year(int newDelivery_invoice_year);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getDelivery_invoice_year() { 
		return get_Delivery_invoice_year(); 
	}
	public void setDelivery_invoice_year(int newDelivery_invoice_year) { 
		set_Delivery_invoice_year(newDelivery_invoice_year); 	
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DELIVERY_INVOICE_NUMBER"
	 */
	public abstract int get_Delivery_invoice_number();
	public abstract void set_Delivery_invoice_number(int newDelivery_invoice_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getDelivery_invoice_number() { 
		return get_Delivery_invoice_number(); 
	}
	public void setDelivery_invoice_number(int newDelivery_invoice_number) { 
		set_Delivery_invoice_number(newDelivery_invoice_number); 	
	} 

	private org.openxava.test.model.DeliveryHome deliveryHome;	
	private org.openxava.test.model.DeliveryHome getDeliveryHome() throws Exception{
		if (deliveryHome == null) {
			deliveryHome = (org.openxava.test.model.DeliveryHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Delivery"),
			 		org.openxava.test.model.DeliveryHome.class);			 		
		}
		return deliveryHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Delivery").getMetaAggregate("DeliveryDetail"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DeliveryDetailData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.DeliveryDetailData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DeliveryDetailValue getDeliveryDetailValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setDeliveryDetailValue(org.openxava.test.model.DeliveryDetailValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setNumber(0); 
		setDescription(null); 
		setDeliveryKey(null); 	
	} 		
}