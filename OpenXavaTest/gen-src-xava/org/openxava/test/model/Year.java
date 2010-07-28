
// File generated by OpenXava: Wed Jul 28 10:01:07 CEST 2010
// Archivo generado por OpenXava: Wed Jul 28 10:01:07 CEST 2010

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Year		Entity/Entidad

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
public class Year implements java.io.Serializable, org.openxava.test.model.IYear {	

	// Constructor
	public Year() {
		initMembers();
	} 

	private void initMembers() { 
		setYear(0); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter yearConverter;
	private org.openxava.converters.IConverter getYearConverter() {
		if (yearConverter == null) {
			try {
				yearConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("year");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "year"));
			}
			
		}	
		return yearConverter;
	} 
	private java.lang.Integer year;
	private java.lang.Integer get_Year() {
		return year;
	}
	private void set_Year(java.lang.Integer newYear) {
		this.year = newYear;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getYear() {
		try {
			return ((Integer) getYearConverter().toJava(get_Year())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Year", "Year", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setYear(int newYear) {
		try { 
			set_Year((java.lang.Integer) getYearConverter().toDB(new Integer(newYear)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Year", "Year", "int"));
		}		
	} 

	// References/Referencias 

	// Colecciones/Collections 
	public java.util.Collection getMonths() { 
		try { 		
			org.openxava.test.calculators.MonthsCalculator monthsCalculator= (org.openxava.test.calculators.MonthsCalculator)
				getMetaModel().getMetaCollection("months").getMetaCalculator().createCalculator(); 
			return (java.util.Collection) monthsCalculator.calculate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "months", "Year", ex.getLocalizedMessage()));
		} 				
	} 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Year findBy() throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Year as o"); 
 			try {
				return (Year) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Year"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			}  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Year as o"); 
			Year r = (Year) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Year"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Year").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "Year"));
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