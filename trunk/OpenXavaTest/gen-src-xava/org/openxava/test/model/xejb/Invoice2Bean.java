
// File generated by OpenXava: Wed Feb 27 16:26:01 CET 2008
// Archivo generado por OpenXava: Wed Feb 27 16:26:01 CET 2008

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice2		Entity/Entidad

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
 * @ejb:bean name="Invoice2" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Invoice2" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IInvoice2"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Invoice2" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByCustomer(int number)" query="SELECT OBJECT(o) FROM Invoice2 o WHERE o._Customer_number = ?1 ORDER BY o.year, o.number" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByCustomer(int number)" query="SELECT OBJECT(o) FROM Invoice2 o WHERE o._Customer_number = ?1 ORDER BY o.year, o.number" 	
 * @ejb:finder signature="Invoice2 findByYearNumber(int year,int number)" query="SELECT OBJECT(o) FROM Invoice2 o WHERE o.year = ?1 and o.number = ?2" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Invoice2 findByYearNumber(int year,int number)" query="SELECT OBJECT(o) FROM Invoice2 o WHERE o.year = ?1 and o.number = ?2" 
 * 
 * @jboss:table-name "XAVATEST.INVOICE"
 *
 * @author Javier Paniza
 */
abstract public class Invoice2Bean extends EJBReplicableBase 
			implements org.openxava.test.model.IInvoice2, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.Invoice2Key ejbCreate(Map values) 
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
	public org.openxava.test.model.Invoice2Key ejbCreate(org.openxava.test.model.Invoice2Data data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setYear(data.getYear()); 
		setNumber(data.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.Invoice2Data data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.Invoice2Key ejbCreate(org.openxava.test.model.Invoice2Value value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setInvoice2Value(value); 
		setYear(value.getYear()); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.Invoice2Value value) 
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
	private static org.openxava.converters.IConverter vatPercentageConverter;
	private org.openxava.converters.IConverter getVatPercentageConverter() {
		if (vatPercentageConverter == null) {
			try {
				vatPercentageConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("vatPercentage");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "vatPercentage"));
			}
			
		}	
		return vatPercentageConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "VATPERCENTAGE"
	 */
	public abstract java.math.BigDecimal get_VatPercentage();
	public abstract void set_VatPercentage(java.math.BigDecimal newVatPercentage); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.math.BigDecimal getVatPercentage() {
		try {
			return (java.math.BigDecimal) getVatPercentageConverter().toJava(get_VatPercentage());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "VatPercentage", "Invoice2", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setVatPercentage(java.math.BigDecimal newVatPercentage) {
		try { 
			this.modified = true; 
			set_VatPercentage((java.math.BigDecimal) getVatPercentageConverter().toDB(newVatPercentage));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "VatPercentage", "Invoice2", "java.math.BigDecimal"));
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
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "YEAR"
	 */
	public abstract int getYear();
	/**
	  * 
	  */
	public abstract void setYear(int newYear); 
	private static org.openxava.converters.IConverter dateConverter;
	private org.openxava.converters.IConverter getDateConverter() {
		if (dateConverter == null) {
			try {
				dateConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("date");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DATE"
	 */
	public abstract java.sql.Date get_Date();
	public abstract void set_Date(java.sql.Date newDate); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.util.Date getDate() {
		try {
			return (java.util.Date) getDateConverter().toJava(get_Date());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Invoice2", "java.util.Date"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDate(java.util.Date newDate) {
		try { 
			this.modified = true; 
			set_Date((java.sql.Date) getDateConverter().toDB(newDate));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Invoice2", "java.util.Date"));
		}		
	} 

	// Colecciones/Collections	

	private org.openxava.test.model.InvoiceDetail2Home detailsHome; 
	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getDetails() {		
		try {
			return getDetailsHome().findByInvoice2(getYear(), getNumber());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "Details", "Invoice2"));
		}
	}
		
	private org.openxava.test.model.InvoiceDetail2Home getDetailsHome() throws Exception{
		if (detailsHome == null) {
			detailsHome = (org.openxava.test.model.InvoiceDetail2Home) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/InvoiceDetail2"),
			 		org.openxava.test.model.InvoiceDetail2Home.class);			 		
		}
		return detailsHome;
	}		

	// References/Referencias 

	// Customer : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.ICustomer getCustomer() {
		try {		
			return getCustomerHome().findByPrimaryKey(getCustomerKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Customer", "Invoice2"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.CustomerRemote getCustomerRemote() {
		return (org.openxava.test.model.CustomerRemote) getCustomer();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setCustomer(org.openxava.test.model.ICustomer newCustomer) { 
		this.modified = true; 
		try {	
			if (newCustomer == null) setCustomerKey(null);
			else {
				if (newCustomer instanceof org.openxava.test.model.Customer) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.CustomerRemote remote = (org.openxava.test.model.CustomerRemote) newCustomer;
				setCustomerKey((org.openxava.test.model.CustomerKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Customer", "Invoice2"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.CustomerKey getCustomerKey() {				
		org.openxava.test.model.CustomerKey key = new org.openxava.test.model.CustomerKey(); 
		key.number = getCustomer_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setCustomerKey(org.openxava.test.model.CustomerKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.CustomerKey(); 
			setCustomer_number(key.number);					
		}
		else { 
			setCustomer_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "CUSTOMER_NUMBER"
	 */
	public abstract int get_Customer_number();
	public abstract void set_Customer_number(int newCustomer_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getCustomer_number() { 
		return get_Customer_number(); 
	}
	public void setCustomer_number(int newCustomer_number) { 
		set_Customer_number(newCustomer_number); 	
	} 

	private org.openxava.test.model.CustomerHome customerHome;	
	private org.openxava.test.model.CustomerHome getCustomerHome() throws Exception{
		if (customerHome == null) {
			customerHome = (org.openxava.test.model.CustomerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Customer"),
			 		org.openxava.test.model.CustomerHome.class);			 		
		}
		return customerHome;
	} 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Invoice2").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.Invoice2Data getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.Invoice2Data data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.Invoice2Value getInvoice2Value();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setInvoice2Value(org.openxava.test.model.Invoice2Value value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setYear(0); 
		setNumber(0); 
		setDate(null); 
		setVatPercentage(null); 
		setCustomerKey(null); 	
	} 		
}