
// File generated by OpenXava: Fri Jul 14 13:15:32 CEST 2006
// Archivo generado por OpenXava: Fri Jul 14 13:15:32 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice		Aggregate/Agregado: InvoiceDetail

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
 * @ejb:bean name="InvoiceDetail" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/InvoiceDetail" reentrant="true" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IInvoiceDetail"
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
 * @ejb:finder signature="Collection findByProduct(long number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o._Product_number = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByProduct(long number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o._Product_number = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Collection findBySoldBy(int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o._SoldBy_number = ?1 ORDER BY o.oid" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findBySoldBy(int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o._SoldBy_number = ?1 ORDER BY o.oid" 	
 * @ejb:finder signature="Collection findByInvoice(int year, int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o._Invoice_year = ?1 AND o._Invoice_number = ?2 ORDER BY o._ServiceType desc" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByInvoice(int year, int number)" query="SELECT OBJECT(o) FROM InvoiceDetail o WHERE o._Invoice_year = ?1 AND o._Invoice_number = ?2 ORDER BY o._ServiceType desc" 
 * 
 * @jboss:table-name "XAVATEST_INVOICEDETAIL"
 *
 * @author Javier Paniza
 */
abstract public class InvoiceDetailBean extends EJBReplicableBase 
			implements org.openxava.test.model.IInvoiceDetail, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.InvoiceDetailKey ejbCreate(org.openxava.test.model.InvoiceRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
		org.openxava.test.model.InvoiceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.InvoiceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Invoice", "InvoiceDetail"));
		} 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator = (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setContainer(container);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.InvoiceRemote container, int counter, Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.InvoiceDetailKey ejbCreate(org.openxava.test.model.InvoiceKey containerKey, int counter, Map values)	
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
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			Object container = InvoiceUtil.getHome().findByPrimaryKey(containerKey);
			oidCalculator.setContainer(container);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	}

	public void ejbPostCreate(org.openxava.test.model.InvoiceKey containerKey, int counter, Map values)	
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.InvoiceDetailKey ejbCreate(org.openxava.test.model.InvoiceRemote container, int counter, org.openxava.test.model.InvoiceDetailData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		org.openxava.test.model.InvoiceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.InvoiceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Invoice", "InvoiceDetail"));
		} 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator= (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setContainer(container);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.InvoiceRemote container, int counter, org.openxava.test.model.InvoiceDetailData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */ 
	public org.openxava.test.model.InvoiceDetailKey ejbCreate(org.openxava.test.model.InvoiceRemote container, int counter, org.openxava.test.model.InvoiceDetailValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setInvoiceDetailValue(value); 
		setOid(value.getOid()); 
		org.openxava.test.model.InvoiceKey containerKey = null;
		try {
			containerKey = (org.openxava.test.model.InvoiceKey) container.getPrimaryKey();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("obtain_primary_key_error_on_create", "Invoice", "InvoiceDetail"));
		} 
		setInvoice_year(containerKey.year); 
		setInvoice_number(containerKey.number); 
		try { 	
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator = (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			oidCalculator.setContainer(container);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate()); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.InvoiceRemote container, int counter, org.openxava.test.model.InvoiceDetailValue value) 
		throws
			CreateException,
			ValidationException { 			
	}	 
	/**
	 * @ejb:create-method
	 */
	public org.openxava.test.model.InvoiceDetailKey ejbCreate(org.openxava.test.model.InvoiceKey containerKey, int counter, org.openxava.test.model.InvoiceDetailValue value)
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;
		modified = false;
		setInvoiceDetailValue(value); 
		setOid(value.getOid());
		setInvoice_year(containerKey.year);
		setInvoice_number(containerKey.number); 
		try { 
			org.openxava.test.calculators.InvoiceDetailOidCalculator oidCalculator= (org.openxava.test.calculators.InvoiceDetailOidCalculator)
				getMetaModel().getMetaProperty("oid").getMetaCalculatorDefaultValue().createCalculator(); 
			Object container = InvoiceUtil.getHome().findByPrimaryKey(containerKey);
			oidCalculator.setContainer(container);
			oidCalculator.setCounter(counter); 
			setOid((String) oidCalculator.calculate());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "InvoiceDetail", ex.getLocalizedMessage()));
		} 
		return null;					

	} 
	public void ejbPostCreate(org.openxava.test.model.InvoiceKey containerKey, int counter, org.openxava.test.model.InvoiceDetailValue value)	
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
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.math.BigDecimal getAmount() { 
		boolean cmtActivated = false;
		if (!org.openxava.hibernate.XHibernate.isCmt()) {
			org.openxava.hibernate.XHibernate.setCmt(true);
			cmtActivated = true;
		} 		
		try {			
			org.openxava.test.calculators.DetailAmountCalculator amountCalculator= (org.openxava.test.calculators.DetailAmountCalculator)
				getMetaModel().getMetaProperty("amount").getMetaCalculator().createCalculator();  	
			
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
		finally {
			if (cmtActivated) {
				org.openxava.hibernate.XHibernate.setCmt(false);
			}
		} 		
	}
	public void setAmount(java.math.BigDecimal newAmount) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private static org.openxava.converters.IConverter unitPriceConverter;
	private org.openxava.converters.IConverter getUnitPriceConverter() {
		if (unitPriceConverter == null) {
			try {
				unitPriceConverter = (org.openxava.converters.IConverter) 
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
	private static org.openxava.converters.IConverter remarksConverter;
	private org.openxava.converters.IConverter getRemarksConverter() {
		if (remarksConverter == null) {
			try {
				remarksConverter = (org.openxava.converters.IConverter) 
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
	private static org.openxava.converters.Date3Converter deliveryDateConverter;
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
	private static org.openxava.converters.IConverter quantityConverter;
	private org.openxava.converters.IConverter getQuantityConverter() {
		if (quantityConverter == null) {
			try {
				quantityConverter = (org.openxava.converters.IConverter) 
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
	private static org.openxava.converters.IConverter serviceTypeConverter;
	private org.openxava.converters.IConverter getServiceTypeConverter() {
		if (serviceTypeConverter == null) {
			try {
				serviceTypeConverter = (org.openxava.converters.IConverter) 
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
	public org.openxava.test.model.IProduct getProduct() {
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
	public org.openxava.test.model.ProductRemote getProductRemote() {
		return (org.openxava.test.model.ProductRemote) getProduct();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setProduct(org.openxava.test.model.IProduct newProduct) { 
		this.modified = true; 
		try {	
			if (newProduct == null) setProductKey(null);
			else {
				if (newProduct instanceof org.openxava.test.model.Product) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.ProductRemote remote = (org.openxava.test.model.ProductRemote) newProduct;
				setProductKey((org.openxava.test.model.ProductKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Product", "InvoiceDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.ProductKey getProductKey() {				
		org.openxava.test.model.ProductKey key = new org.openxava.test.model.ProductKey(); 
		key.number = getProduct_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setProductKey(org.openxava.test.model.ProductKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.ProductKey(); 
			setProduct_number(key.number);					
		}
		else { 
			setProduct_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "PRODUCT_NUMBER"
	 */
	public abstract long get_Product_number();
	public abstract void set_Product_number(long newProduct_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public long getProduct_number() { 
		return get_Product_number(); 
	}
	public void setProduct_number(long newProduct_number) { 
		set_Product_number(newProduct_number); 	
	} 

	private org.openxava.test.model.ProductHome productHome;	
	private org.openxava.test.model.ProductHome getProductHome() throws Exception{
		if (productHome == null) {
			productHome = (org.openxava.test.model.ProductHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Product"),
			 		org.openxava.test.model.ProductHome.class);			 		
		}
		return productHome;
	} 

	// SoldBy : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.ISeller getSoldBy() {
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
	public org.openxava.test.model.SellerRemote getSoldByRemote() {
		return (org.openxava.test.model.SellerRemote) getSoldBy();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setSoldBy(org.openxava.test.model.ISeller newSoldBy) { 
		this.modified = true; 
		try {	
			if (newSoldBy == null) setSoldByKey(null);
			else {
				if (newSoldBy instanceof org.openxava.test.model.Seller) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.SellerRemote remote = (org.openxava.test.model.SellerRemote) newSoldBy;
				setSoldByKey((org.openxava.test.model.SellerKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "SoldBy", "InvoiceDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.SellerKey getSoldByKey() {				
		org.openxava.test.model.SellerKey key = new org.openxava.test.model.SellerKey(); 
		key.number = getSoldBy_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setSoldByKey(org.openxava.test.model.SellerKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.SellerKey(); 
			setSoldBy_number(key.number);					
		}
		else { 
			setSoldBy_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "SOLDBY_NUMBER"
	 */
	public abstract int get_SoldBy_number();
	public abstract void set_SoldBy_number(int newSoldBy_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getSoldBy_number() { 
		return get_SoldBy_number(); 
	}
	public void setSoldBy_number(int newSoldBy_number) { 
		set_SoldBy_number(newSoldBy_number); 	
	} 

	private org.openxava.test.model.SellerHome soldByHome;	
	private org.openxava.test.model.SellerHome getSoldByHome() throws Exception{
		if (soldByHome == null) {
			soldByHome = (org.openxava.test.model.SellerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Seller"),
			 		org.openxava.test.model.SellerHome.class);			 		
		}
		return soldByHome;
	} 

	// Invoice : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IInvoice getInvoice() {
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
	public org.openxava.test.model.InvoiceRemote getInvoiceRemote() {
		return (org.openxava.test.model.InvoiceRemote) getInvoice();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setInvoice(org.openxava.test.model.IInvoice newInvoice) { 
		this.modified = true; 
		try {	
			if (newInvoice == null) setInvoiceKey(null);
			else {
				if (newInvoice instanceof org.openxava.test.model.Invoice) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.InvoiceRemote remote = (org.openxava.test.model.InvoiceRemote) newInvoice;
				setInvoiceKey((org.openxava.test.model.InvoiceKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Invoice", "InvoiceDetail"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.InvoiceKey getInvoiceKey() {				
		org.openxava.test.model.InvoiceKey key = new org.openxava.test.model.InvoiceKey(); 
		key.year = getInvoice_year(); 
		key.number = getInvoice_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setInvoiceKey(org.openxava.test.model.InvoiceKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.InvoiceKey(); 
			setInvoice_year(key.year); 
			setInvoice_number(key.number);					
		}
		else { 
			setInvoice_year(key.year); 
			setInvoice_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "INVOICE_YEAR"
	 */
	public abstract int get_Invoice_year();
	public abstract void set_Invoice_year(int newInvoice_year);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getInvoice_year() { 
		return get_Invoice_year(); 
	}
	public void setInvoice_year(int newInvoice_year) { 
		set_Invoice_year(newInvoice_year); 	
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "INVOICE_NUMBER"
	 */
	public abstract int get_Invoice_number();
	public abstract void set_Invoice_number(int newInvoice_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getInvoice_number() { 
		return get_Invoice_number(); 
	}
	public void setInvoice_number(int newInvoice_number) { 
		set_Invoice_number(newInvoice_number); 	
	} 

	private org.openxava.test.model.InvoiceHome invoiceHome;	
	private org.openxava.test.model.InvoiceHome getInvoiceHome() throws Exception{
		if (invoiceHome == null) {
			invoiceHome = (org.openxava.test.model.InvoiceHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Invoice"),
			 		org.openxava.test.model.InvoiceHome.class);			 		
		}
		return invoiceHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Invoice").getMetaAggregate("InvoiceDetail"); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.InvoiceDetailData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.InvoiceDetailData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.InvoiceDetailValue getInvoiceDetailValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setInvoiceDetailValue(org.openxava.test.model.InvoiceDetailValue value);
	
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
		setProductKey(null); 
		setSoldByKey(null); 
		setInvoiceKey(null); 	
	} 		
}