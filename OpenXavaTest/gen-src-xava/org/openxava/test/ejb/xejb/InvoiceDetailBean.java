
// File generated by OpenXava: Thu May 05 13:45:35 CEST 2005
// Archivo generado por OpenXava: Thu May 05 13:45:35 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice		Aggregate/Agregado: InvoiceDetail

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
 * @ejb:bean name="InvoiceDetail" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/InvoiceDetail" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.IInvoiceDetail"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="InvoiceDetail" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByProduct(long number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o.product_number = ?1 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByProduct(long number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o.product_number = ?1 " 	
 * @ejb:finder signature="Collection findBySoldBy(int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o.soldBy_number = ?1 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findBySoldBy(int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o.soldBy_number = ?1 " 	
 * @ejb:finder signature="Collection findByInvoice(int year, int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o.invoice_year = ?1 AND o.invoice_number = ?2 ORDER BY o._ServiceType desc" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByInvoice(int year, int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o.invoice_year = ?1 AND o.invoice_number = ?2 ORDER BY o._ServiceType desc" 
 * 
 * @jboss:table-name "XAVATEST_INVOICEDETAIL"
 *
 * @author Javier Paniza
 */
abstract public class InvoiceDetailBean extends EJBReplicableBase 
			implements org.openxava.test.ejb.IInvoiceDetail, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.ejb.InvoiceDetailKey ejbCreate(org.openxava.test.ejb.Invoice container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		org.openxava.test.ejb.InvoiceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.ejb.InvoiceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Invoice", "InvoiceDetail"));
		} 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator = (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setContainerKey(containerKey);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Invoice container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.ejb.InvoiceDetailKey ejbCreate(org.openxava.test.ejb.InvoiceKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		executeSets(values); 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator = (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setContainerKey(containerKey);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.ejb.InvoiceKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException {			
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.ejb.InvoiceDetailKey ejbCreate(org.openxava.test.ejb.Invoice container, int counter, org.openxava.test.ejb.InvoiceDetailData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		org.openxava.test.ejb.InvoiceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.ejb.InvoiceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Invoice", "InvoiceDetail"));
		} 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator= (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setContainerKey(containerKey);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Invoice container, int counter, org.openxava.test.ejb.InvoiceDetailData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.ejb.InvoiceDetailKey ejbCreate(org.openxava.test.ejb.Invoice container, int counter, org.openxava.test.ejb.InvoiceDetailValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setInvoiceDetailValue(value); 
		org.openxava.test.ejb.InvoiceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.ejb.InvoiceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Invoice", "InvoiceDetail"));
		} 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		setOid(value.getOid()); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator = (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setContainerKey(containerKey);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.Invoice container, int counter, org.openxava.test.ejb.InvoiceDetailValue value) 
		throws
			CreateException,
			ValidationException {			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.ejb.InvoiceDetailKey ejbCreate(org.openxava.test.ejb.InvoiceKey containerKey, int counter, org.openxava.test.ejb.InvoiceDetailValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		setInvoiceDetailValue(value);
		setInvoice_year(containerKey.year);
		setInvoice_number(containerKey.number); 
		setOid(value.getOid()); 
		try { 
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator= (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().getCalculator(); 
			oidCalculator.setContainerKey(containerKey);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.ejb.InvoiceKey containerKey, int counter, org.openxava.test.ejb.InvoiceDetailValue value)	
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
	
	// Properties/Propiedades 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.math.BigDecimal getAmount() {
		try { 		
			org.openxava.test.calculators.DetailAmountCalculator amountCalculator= (org.openxava.test.calculators.DetailAmountCalculator)
				getMetaModel().getMetaProperty("amount").getMetaCalculator().getCalculator();  	
			amountCalculator.setUnitPrice(getUnitPrice());  	
			amountCalculator.setQuantity(getQuantity()); 
			return (java.math.BigDecimal) amountCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.calculate_value_error", "Amount", "InvoiceDetail", ex.getLocalizedMessage()));
		}
	}
	public void setAmount(java.math.BigDecimal newAmount) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private org.openxava.converters.BigDecimalNumberConverter unitPriceConverter;
	private org.openxava.converters.BigDecimalNumberConverter getUnitPriceConverter() {
		if (unitPriceConverter == null) {
			try {
				unitPriceConverter = (org.openxava.converters.BigDecimalNumberConverter) 
					getMetaModel().getMapping().getConverter("unitPrice");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "unitPrice"));
			}
			
		}	
		return unitPriceConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "UNITPRICE"
	 */
	public abstract java.math.BigDecimal get_UnitPrice();
	public abstract void set_UnitPrice(java.math.BigDecimal newUnitPrice); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.math.BigDecimal getUnitPrice() {
		try {
			return (java.math.BigDecimal) getUnitPriceConverter().toJava(get_UnitPrice());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UnitPrice", "InvoiceDetail", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setUnitPrice(java.math.BigDecimal newUnitPrice) {
		try { 
			this.modified = true; 
			set_UnitPrice((java.math.BigDecimal) getUnitPriceConverter().toDB(newUnitPrice));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "UnitPrice", "InvoiceDetail", "java.math.BigDecimal"));
		}		
	} 
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
	public java.lang.String getRemarks() {
		try {
			return (java.lang.String) getRemarksConverter().toJava(get_Remarks());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "InvoiceDetail", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setRemarks(java.lang.String newRemarks) {
		try { 
			this.modified = true; 
			set_Remarks((java.lang.String) getRemarksConverter().toDB(newRemarks));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "InvoiceDetail", "java.lang.String"));
		}		
	} 
	private org.openxava.converters.Date3Converter deliveryDateConverter;
	private org.openxava.converters.Date3Converter getDeliveryDateConverter() {
		if (deliveryDateConverter == null) {
			try {
				deliveryDateConverter = (org.openxava.converters.Date3Converter) 
					getMetaModel().getMapping().getMultipleConverter("deliveryDate");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "deliveryDate"));
			}
			
		}	
		return deliveryDateConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * @jboss:column-name "DAYDELIVERY"
	 */		
	public abstract int getDeliveryDate_day();
	public abstract void setDeliveryDate_day(int newValue); 
	/**	 
	 * @ejb:persistent-field
	 * @jboss:column-name "MONTHDELIVERY"
	 */		
	public abstract int getDeliveryDate_month();
	public abstract void setDeliveryDate_month(int newValue); 
	/**	 
	 * @ejb:persistent-field
	 * @jboss:column-name "YEARDELIVERY"
	 */		
	public abstract int getDeliveryDate_year();
	public abstract void setDeliveryDate_year(int newValue); 
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.util.Date getDeliveryDate() {
		try { 
			getDeliveryDateConverter().setDay(getDeliveryDate_day()); 
			getDeliveryDateConverter().setMonth(getDeliveryDate_month()); 
			getDeliveryDateConverter().setYear(getDeliveryDate_year()); 
			return (java.util.Date) getDeliveryDateConverter().toJava();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "DeliveryDate", "InvoiceDetail", "java.util.Date"));
		}
	}

	/**
	 * @ejb:interface-method
	 */
	public void setDeliveryDate(java.util.Date newDeliveryDate) {
		try {
			this.modified = true; 
			getDeliveryDateConverter().toDB(newDeliveryDate); 
			setDeliveryDate_day(getDeliveryDateConverter().getDay()); 
			setDeliveryDate_month(getDeliveryDateConverter().getMonth()); 
			setDeliveryDate_year(getDeliveryDateConverter().getYear()); 			
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_db_error", "DeliveryDate", "InvoiceDetail"));
		}		
	} 
	private org.openxava.converters.IntegerNumberConverter quantityConverter;
	private org.openxava.converters.IntegerNumberConverter getQuantityConverter() {
		if (quantityConverter == null) {
			try {
				quantityConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("quantity");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "quantity"));
			}
			
		}	
		return quantityConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "QUANTITY"
	 */
	public abstract java.lang.Integer get_Quantity();
	public abstract void set_Quantity(java.lang.Integer newQuantity); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getQuantity() {
		try {
			return ((Integer) getQuantityConverter().toJava(get_Quantity())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Quantity", "InvoiceDetail", "int"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setQuantity(int newQuantity) {
		try { 
			this.modified = true; 
			set_Quantity((java.lang.Integer) getQuantityConverter().toDB(new Integer(newQuantity)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Quantity", "InvoiceDetail", "int"));
		}		
	} 
	private org.openxava.converters.IntegerNumberConverter serviceTypeConverter;
	private org.openxava.converters.IntegerNumberConverter getServiceTypeConverter() {
		if (serviceTypeConverter == null) {
			try {
				serviceTypeConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("serviceType");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "serviceType"));
			}
			
		}	
		return serviceTypeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "SERVICETYPE"
	 */
	public abstract java.lang.Integer get_ServiceType();
	public abstract void set_ServiceType(java.lang.Integer newServiceType); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getServiceType() {
		try {
			return ((Integer) getServiceTypeConverter().toJava(get_ServiceType())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "ServiceType", "InvoiceDetail", "int"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setServiceType(int newServiceType) {
		try { 
			this.modified = true; 
			set_ServiceType((java.lang.Integer) getServiceTypeConverter().toDB(new Integer(newServiceType)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "ServiceType", "InvoiceDetail", "int"));
		}		
	} 

	// Colecciones/Collections		

	// References/Referencias 

	// Product : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Product getProduct() {
		try {		
			return getProductHome().findByPrimaryKey(getProductKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Product", "InvoiceDetail"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setProduct(org.openxava.test.ejb.Product newProduct) { 
		this.modified = true; 
		try {	
			if (newProduct == null) setProductKey(null);
			else setProductKey((org.openxava.test.ejb.ProductKey) newProduct.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Product", "InvoiceDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.ProductKey getProductKey() {				
		org.openxava.test.ejb.ProductKey key = new org.openxava.test.ejb.ProductKey(); 
		key.number = getProduct_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setProductKey(org.openxava.test.ejb.ProductKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.ProductKey();
		} 
		setProduct_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "PRODUCT_NUMBER"
	 */
	public abstract long getProduct_number();
	public abstract void setProduct_number(long newProduct_number); 

	private org.openxava.test.ejb.ProductHome productHome;	
	private org.openxava.test.ejb.ProductHome getProductHome() throws Exception{
		if (productHome == null) {
			productHome = (org.openxava.test.ejb.ProductHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Product"),
			 		org.openxava.test.ejb.ProductHome.class);			 		
		}
		return productHome;
	} 

	// SoldBy : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Seller getSoldBy() {
		try {		
			return getSoldByHome().findByPrimaryKey(getSoldByKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "SoldBy", "InvoiceDetail"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setSoldBy(org.openxava.test.ejb.Seller newSoldBy) { 
		this.modified = true; 
		try {	
			if (newSoldBy == null) setSoldByKey(null);
			else setSoldByKey((org.openxava.test.ejb.SellerKey) newSoldBy.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "SoldBy", "InvoiceDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.SellerKey getSoldByKey() {				
		org.openxava.test.ejb.SellerKey key = new org.openxava.test.ejb.SellerKey(); 
		key.number = getSoldBy_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setSoldByKey(org.openxava.test.ejb.SellerKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.SellerKey();
		} 
		setSoldBy_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "SOLDBY_NUMBER"
	 */
	public abstract int getSoldBy_number();
	public abstract void setSoldBy_number(int newSoldBy_number); 

	private org.openxava.test.ejb.SellerHome soldByHome;	
	private org.openxava.test.ejb.SellerHome getSoldByHome() throws Exception{
		if (soldByHome == null) {
			soldByHome = (org.openxava.test.ejb.SellerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Seller"),
			 		org.openxava.test.ejb.SellerHome.class);			 		
		}
		return soldByHome;
	} 

	// Invoice : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Invoice getInvoice() {
		try {		
			return getInvoiceHome().findByPrimaryKey(getInvoiceKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Invoice", "InvoiceDetail"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setInvoice(org.openxava.test.ejb.Invoice newInvoice) { 
		this.modified = true; 
		try {	
			if (newInvoice == null) setInvoiceKey(null);
			else setInvoiceKey((org.openxava.test.ejb.InvoiceKey) newInvoice.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Invoice", "InvoiceDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.InvoiceKey getInvoiceKey() {				
		org.openxava.test.ejb.InvoiceKey key = new org.openxava.test.ejb.InvoiceKey(); 
		key.year = getInvoice_year(); 
		key.number = getInvoice_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setInvoiceKey(org.openxava.test.ejb.InvoiceKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.InvoiceKey();
		} 
		setInvoice_year(key.year); 
		setInvoice_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "INVOICE_YEAR"
	 */
	public abstract int getInvoice_year();
	public abstract void setInvoice_year(int newInvoice_year);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "INVOICE_NUMBER"
	 */
	public abstract int getInvoice_number();
	public abstract void setInvoice_number(int newInvoice_number); 

	private org.openxava.test.ejb.InvoiceHome invoiceHome;	
	private org.openxava.test.ejb.InvoiceHome getInvoiceHome() throws Exception{
		if (invoiceHome == null) {
			invoiceHome = (org.openxava.test.ejb.InvoiceHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Invoice"),
			 		org.openxava.test.ejb.InvoiceHome.class);			 		
		}
		return invoiceHome;
	} 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Invoice").getMetaAggregate("InvoiceDetail"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.InvoiceDetailData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.InvoiceDetailData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.InvoiceDetailValue getInvoiceDetailValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setInvoiceDetailValue(org.openxava.test.ejb.InvoiceDetailValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setOid(null); 
		setServiceType(0); 
		setQuantity(0); 
		setUnitPrice(null); 
		setDeliveryDate(null); 
		setRemarks(null); 
	}
		
}