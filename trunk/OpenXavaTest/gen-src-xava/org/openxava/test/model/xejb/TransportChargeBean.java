
// File generated by OpenXava: Tue Feb 28 13:36:04 CET 2006
// Archivo generado por OpenXava: Tue Feb 28 13:36:04 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: TransportCharge		Entity/Entidad

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
 * @ejb:bean name="TransportCharge" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/TransportCharge" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ITransportCharge"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="TransportCharge" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByDelivery(int number, int type_number, int invoice_year, int invoice_number)" query="SELECT OBJECT(o) FROM TransportCharge o WHERE o._Delivery_number = ?1 AND o._Delivery_type_number = ?2 AND o._Delivery_invoice_year = ?3 AND o._Delivery_invoice_number = ?4 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByDelivery(int number, int type_number, int invoice_year, int invoice_number)" query="SELECT OBJECT(o) FROM TransportCharge o WHERE o._Delivery_number = ?1 AND o._Delivery_type_number = ?2 AND o._Delivery_invoice_year = ?3 AND o._Delivery_invoice_number = ?4 " 	
 * @ejb:finder signature="Collection findAll()" query="SELECT OBJECT(o) FROM TransportCharge o" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findAll()" query="SELECT OBJECT(o) FROM TransportCharge o" 
 * 
 * @jboss:table-name "XAVATEST_TRANSPORTCHARGE"
 *
 * @author Javier Paniza
 */
abstract public class TransportChargeBean extends EJBReplicableBase 
			implements org.openxava.test.model.ITransportCharge, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.TransportChargeKey ejbCreate(Map values) 
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
	public org.openxava.test.model.TransportChargeKey ejbCreate(org.openxava.test.model.TransportChargeData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data);  
		set_Delivery_number(data.get_Delivery_number());  
		set_Delivery_type_number(data.get_Delivery_type_number());  
		set_Delivery_invoice_year(data.get_Delivery_invoice_year());  
		set_Delivery_invoice_number(data.get_Delivery_invoice_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.TransportChargeData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.TransportChargeKey ejbCreate(org.openxava.test.model.TransportChargeValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setTransportChargeValue(value); 
		setDelivery_number(value.getDelivery_number()); 
		setDelivery_type_number(value.getDelivery_type_number()); 
		setDelivery_invoice_year(value.getDelivery_invoice_year()); 
		setDelivery_invoice_number(value.getDelivery_invoice_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.TransportChargeValue value) 
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
	private org.openxava.converters.IConverter amountConverter;
	private org.openxava.converters.IConverter getAmountConverter() {
		if (amountConverter == null) {
			try {
				amountConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("amount");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "amount"));
			}
			
		}	
		return amountConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "AMOUNT"
	 */
	public abstract java.math.BigDecimal get_Amount();
	public abstract void set_Amount(java.math.BigDecimal newAmount); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.math.BigDecimal getAmount() {
		try {
			return (java.math.BigDecimal) getAmountConverter().toJava(get_Amount());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Amount", "TransportCharge", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAmount(java.math.BigDecimal newAmount) {
		try { 
			this.modified = true; 
			set_Amount((java.math.BigDecimal) getAmountConverter().toDB(newAmount));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Amount", "TransportCharge", "java.math.BigDecimal"));
		}		
	} 

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
			throw new EJBException(XavaResources.getString("get_reference_error", "Delivery", "TransportCharge"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DeliveryRemote getDeliveryRemote() {
		return (org.openxava.test.model.DeliveryRemote) getDelivery();
	}
	
	/**
	 * 
	 */
	public void setDelivery(org.openxava.test.model.IDelivery newDelivery) { 
		this.modified = true; 
		try {	
			if (newDelivery == null) setDeliveryKey(null);
			else {
				org.openxava.test.model.DeliveryRemote remote = (org.openxava.test.model.DeliveryRemote) newDelivery;
				setDeliveryKey((org.openxava.test.model.DeliveryKey) remote.getPrimaryKey());
			}	
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Delivery", "TransportCharge"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.DeliveryKey getDeliveryKey() {				
		org.openxava.test.model.DeliveryKey key = new org.openxava.test.model.DeliveryKey(); 
		key.number = getDelivery_number(); 
		key._Type_number = getDelivery_type_number(); 
		key._Invoice_year = getDelivery_invoice_year(); 
		key._Invoice_number = getDelivery_invoice_number();		
		return key;
	}	
	
	/**
	 * 
	 */
	public void setDeliveryKey(org.openxava.test.model.DeliveryKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.DeliveryKey();
		} 
		setDelivery_number(key.number); 
		setDelivery_type_number(key._Type_number); 
		setDelivery_invoice_year(key._Invoice_year); 
		setDelivery_invoice_number(key._Invoice_number);		
		
	}
	/**		
	 * @ejb:persistent-field
	 * @ejb:pk-field
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
	 * @ejb:pk-field
	 * @jboss:column-name "DELIVERY_TYPE"
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
	 * @ejb:pk-field
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
	 * @ejb:pk-field
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

	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("TransportCharge").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.TransportChargeData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.TransportChargeData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.TransportChargeValue getTransportChargeValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setTransportChargeValue(org.openxava.test.model.TransportChargeValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setAmount(null); 
		setDeliveryKey(null); 	
	} 		
}