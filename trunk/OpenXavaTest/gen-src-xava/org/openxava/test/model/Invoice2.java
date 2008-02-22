
// File generated by OpenXava: Thu Feb 21 17:30:28 CET 2008
// Archivo generado por OpenXava: Thu Feb 21 17:30:28 CET 2008

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice2		Entity/Entidad

package org.openxava.test.model;

import java.util.*;
import java.math.*;
import java.rmi.RemoteException;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.*;

/**
 * 
 * @author MCarmen Gimeno
 */
public class Invoice2 implements java.io.Serializable, org.openxava.test.model.IInvoice2 {	

	// Constructor
	public Invoice2() {
		initMembers();
	} 

	private void initMembers() { 
		setYear(0); 
		setNumber(0); 
		setDate(null); 
		setVatPercentage(null); 	
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "vatPercentage"));
			}
			
		}	
		return vatPercentageConverter;
	} 
	private java.math.BigDecimal vatPercentage;
	private java.math.BigDecimal get_VatPercentage() {
		return vatPercentage;
	}
	private void set_VatPercentage(java.math.BigDecimal newVatPercentage) {
		this.vatPercentage = newVatPercentage;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.math.BigDecimal getVatPercentage() {
		try {
			return (java.math.BigDecimal) getVatPercentageConverter().toJava(get_VatPercentage());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "VatPercentage", "Invoice2", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * 
	 */
	public void setVatPercentage(java.math.BigDecimal newVatPercentage) {
		try { 
			set_VatPercentage((java.math.BigDecimal) getVatPercentageConverter().toDB(newVatPercentage));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "VatPercentage", "Invoice2", "java.math.BigDecimal"));
		}		
	} 
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int newNumber) {
		this.number = newNumber;
	} 
	private int year;
	public int getYear() {
		return year;
	}
	public void setYear(int newYear) {
		this.year = newYear;
	} 
	private static org.openxava.converters.IConverter dateConverter;
	private org.openxava.converters.IConverter getDateConverter() {
		if (dateConverter == null) {
			try {
				dateConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("date");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	private java.sql.Date date;
	private java.sql.Date get_Date() {
		return date;
	}
	private void set_Date(java.sql.Date newDate) {
		this.date = newDate;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.util.Date getDate() {
		try {
			return (java.util.Date) getDateConverter().toJava(get_Date());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Invoice2", "java.util.Date"));
		}
	}
	
	/**
	 * 
	 */
	public void setDate(java.util.Date newDate) {
		try { 
			set_Date((java.sql.Date) getDateConverter().toDB(newDate));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Invoice2", "java.util.Date"));
		}		
	} 

	// References/Referencias 

	private org.openxava.test.model.ICustomer customer; 	
	public org.openxava.test.model.ICustomer getCustomer() {
		if (customer != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				customer.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return customer;
	}
	public void setCustomer(org.openxava.test.model.ICustomer newCustomer) {
		if (newCustomer != null && !(newCustomer instanceof org.openxava.test.model.Customer)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.customer = newCustomer; 
	} 

	// Colecciones/Collections 
	private java.util.Collection details;
	public java.util.Collection getDetails() {
		return details;
	}
	public void setDetails(java.util.Collection details) {
		this.details = details;
	} 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Invoice2 findByYearNumber(int year,int number) throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Invoice2 as o where o.year = :arg0 and number = :arg1"); 
			query.setParameter("arg0", new Integer(year)); 
			query.setParameter("arg1", new Integer(number)); 
 			try {
				return (Invoice2) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Invoice2"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			}  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Invoice2 as o where o.year = :arg0 and number = :arg1"); 
			query.setParameter("arg0", new Integer(year)); 
			query.setParameter("arg1", new Integer(number)); 
			Invoice2 r = (Invoice2) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Invoice2"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Invoice2").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "Invoice2"));
			return super.toString();
		}		
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}