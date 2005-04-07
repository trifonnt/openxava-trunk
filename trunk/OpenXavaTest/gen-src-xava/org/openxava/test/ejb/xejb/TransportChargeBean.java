
// File generated by OpenXava: Thu Apr 07 11:10:37 CEST 2005
// Archivo generado por OpenXava: Thu Apr 07 11:10:37 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: TransportCharge		Entity/Entidad

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
 * @ejb:bean name="TransportCharge" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/TransportCharge" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.ITransportCharge"
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
 * @ejb:finder signature="Collection findByDelivery(int number, int type_number, int invoice_year, int invoice_number)" query="SELECT OBJECT(o) FROM TransportCharge o WHERE o.delivery_number = ?1 AND o.delivery_type_number = ?2 AND o.delivery_invoice_year = ?3 AND o.delivery_invoice_number = ?4" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByDelivery(int number, int type_number, int invoice_year, int invoice_number)" query="SELECT OBJECT(o) FROM TransportCharge o WHERE o.delivery_number = ?1 AND o.delivery_type_number = ?2 AND o.delivery_invoice_year = ?3 AND o.delivery_invoice_number = ?4 " 	
 * @ejb:finder signature="Collection findAll()" query="SELECT OBJECT(o) FROM TransportCharge o" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findAll()" query="SELECT OBJECT(o) FROM TransportCharge o" 
 * 
 * @jboss:table-name "XAVATEST_TRANSPORTCHARGE"
 *
 * @author Javier Paniza
 */
abstract public class TransportChargeBean extends EJBReplicableBase 
			implements org.openxava.test.ejb.ITransportCharge, EntityBean {	
			
	private boolean creating = false;		

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.TransportChargeKey ejbCreate(Map values) 
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
	public org.openxava.test.ejb.TransportChargeKey ejbCreate(org.openxava.test.ejb.TransportChargeData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setData(data); 
		setDelivery_number(data.getDelivery_number()); 
		setDelivery_type_number(data.getDelivery_type_number()); 
		setDelivery_invoice_year(data.getDelivery_invoice_year()); 
		setDelivery_invoice_number(data.getDelivery_invoice_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.TransportChargeData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.TransportChargeKey ejbCreate(org.openxava.test.ejb.TransportChargeValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		setTransportChargeValue(value); 
		setDelivery_number(value.getDelivery_number()); 
		setDelivery_type_number(value.getDelivery_type_number()); 
		setDelivery_invoice_year(value.getDelivery_invoice_year()); 
		setDelivery_invoice_number(value.getDelivery_invoice_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.TransportChargeValue value) 
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
	private org.openxava.converters.BigDecimalNumberConverter amountConverter;
	private org.openxava.converters.BigDecimalNumberConverter getAmountConverter() {
		if (amountConverter == null) {
			try {
				amountConverter = (org.openxava.converters.BigDecimalNumberConverter) 
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
	public org.openxava.test.ejb.Delivery getDelivery() {
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
	 * 
	 */
	public void setDelivery(org.openxava.test.ejb.Delivery newDelivery) {
		try {	
			if (newDelivery == null) setDeliveryKey(null);
			else setDeliveryKey((org.openxava.test.ejb.DeliveryKey) newDelivery.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Delivery", "TransportCharge"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.DeliveryKey getDeliveryKey() {				
			org.openxava.test.ejb.DeliveryKey key = new org.openxava.test.ejb.DeliveryKey(); 
			key.number = getDelivery_number(); 
			key.type_number = getDelivery_type_number(); 
			key.invoice_year = getDelivery_invoice_year(); 
			key.invoice_number = getDelivery_invoice_number();		
			return key;
	}	
	
	/**
	 * 
	 */
	public void setDeliveryKey(org.openxava.test.ejb.DeliveryKey key) {
		if (key == null) {
			key = new org.openxava.test.ejb.DeliveryKey();
		} 
		setDelivery_number(key.number); 
		setDelivery_type_number(key.type_number); 
		setDelivery_invoice_year(key.invoice_year); 
		setDelivery_invoice_number(key.invoice_number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "DELIVERY_NUMBER"
	 */
	public abstract int getDelivery_number();
	public abstract void setDelivery_number(int newDelivery_number);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "DELIVERY_TYPE"
	 */
	public abstract int getDelivery_type_number();
	public abstract void setDelivery_type_number(int newDelivery_type_number);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "DELIVERY_INVOICE_YEAR"
	 */
	public abstract int getDelivery_invoice_year();
	public abstract void setDelivery_invoice_year(int newDelivery_invoice_year);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "DELIVERY_INVOICE_NUMBER"
	 */
	public abstract int getDelivery_invoice_number();
	public abstract void setDelivery_invoice_number(int newDelivery_invoice_number); 

	private org.openxava.test.ejb.DeliveryHome deliveryHome;	
	private org.openxava.test.ejb.DeliveryHome getDeliveryHome() throws Exception{
		if (deliveryHome == null) {
			deliveryHome = (org.openxava.test.ejb.DeliveryHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Delivery"),
			 		org.openxava.test.ejb.DeliveryHome.class);			 		
		}
		return deliveryHome;
	} 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("TransportCharge").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.TransportChargeData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.TransportChargeData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.TransportChargeValue getTransportChargeValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setTransportChargeValue(org.openxava.test.ejb.TransportChargeValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setAmount(null); 
	}
		
}