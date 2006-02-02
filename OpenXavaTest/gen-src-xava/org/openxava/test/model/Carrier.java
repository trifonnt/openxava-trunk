
// File generated by OpenXava: Thu Feb 02 10:38:07 CET 2006
// Archivo generado por OpenXava: Thu Feb 02 10:38:07 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Carrier		Entity/Entidad

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
public class Carrier implements java.io.Serializable, org.openxava.test.model.ICarrier {	
	
	// Properties/Propiedades 
	private org.openxava.converters.IConverter remarksConverter;
	private org.openxava.converters.IConverter getRemarksConverter() {
		if (remarksConverter == null) {
			try {
				remarksConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("remarks");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "remarks"));
			}
			
		}	
		return remarksConverter;
	} 
	private java.lang.String remarks;
	private java.lang.String get_Remarks() {
		return remarks;
	}
	private void set_Remarks(java.lang.String newRemarks) {
		this.remarks = newRemarks;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.lang.String getRemarks() {
		try {
			return (java.lang.String) getRemarksConverter().toJava(get_Remarks());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Carrier", "java.lang.String"));
		}
	}
	
	/**
	 * 
	 */
	public void setRemarks(java.lang.String newRemarks) {
		try { 
			set_Remarks((java.lang.String) getRemarksConverter().toDB(newRemarks));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Carrier", "java.lang.String"));
		}		
	} 	
	/**
	 * 
	 * 
	 */
	public String getCalculated() {
		try { 		
			org.openxava.calculators.StringCalculator calculatedCalculator= (org.openxava.calculators.StringCalculator)
				getMetaModel().getMetaProperty("calculated").getMetaCalculator().createCalculator(); 
			return (String) calculatedCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "Calculated", "Carrier", ex.getLocalizedMessage()));
		}
	}
	public void setCalculated(String newCalculated) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private org.openxava.converters.IConverter nameConverter;
	private org.openxava.converters.IConverter getNameConverter() {
		if (nameConverter == null) {
			try {
				nameConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("name");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "name"));
			}
			
		}	
		return nameConverter;
	} 
	private java.lang.String name;
	private java.lang.String get_Name() {
		return name;
	}
	private void set_Name(java.lang.String newName) {
		this.name = newName;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getName() {
		try {
			return (String) getNameConverter().toJava(get_Name());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Carrier", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setName(String newName) {
		try { 
			set_Name((java.lang.String) getNameConverter().toDB(newName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Carrier", "String"));
		}		
	} 
	private org.openxava.converters.IConverter numberConverter;
	private org.openxava.converters.IConverter getNumberConverter() {
		if (numberConverter == null) {
			try {
				numberConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("number");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "number"));
			}
			
		}	
		return numberConverter;
	} 
	private java.lang.Integer number;
	private java.lang.Integer get_Number() {
		return number;
	}
	private void set_Number(java.lang.Integer newNumber) {
		this.number = newNumber;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getNumber() {
		try {
			return ((Integer) getNumberConverter().toJava(get_Number())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Number", "Carrier", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setNumber(int newNumber) {
		try { 
			set_Number((java.lang.Integer) getNumberConverter().toDB(new Integer(newNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Number", "Carrier", "int"));
		}		
	} 

	// References/Referencias 
	private org.openxava.test.model.IWarehouse warehouse;
	public org.openxava.test.model.IWarehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(org.openxava.test.model.IWarehouse newWarehouse) {
		this.warehouse = newWarehouse;
	} 
	private org.openxava.test.model.IDrivingLicence drivingLicence;
	public org.openxava.test.model.IDrivingLicence getDrivingLicence() {
		return drivingLicence;
	}
	public void setDrivingLicence(org.openxava.test.model.IDrivingLicence newDrivingLicence) {
		this.drivingLicence = newDrivingLicence;
	} 

	// Colecciones/Collections 
	public java.util.Collection getFellowCarriersCalculated() {		
		try { 		
			org.openxava.test.calculators.FellowCarriersCalculator fellowCarriersCalculatedCalculator= (org.openxava.test.calculators.FellowCarriersCalculator)
				getMetaModel().getMetaCollection("fellowCarriersCalculated").getMetaCalculator().createCalculator(); 
				fellowCarriersCalculatedCalculator.setEntity(this); 
			return (java.util.Collection) fellowCarriersCalculatedCalculator.calculate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "fellowCarriersCalculated", "Carrier", ex.getLocalizedMessage()));
		}
	} 
	public java.util.Collection getFellowCarriers() throws RemoteException {
		org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Carrier as o where 				o.warehouse.zoneNumber = ? AND 				o.warehouse.number = ? AND 				NOT (o.number = ?)			");
		query.setParameter(0, new Integer(getWarehouse().getZoneNumber()));
		query.setParameter(1, new Integer(getWarehouse().getNumber()));
		query.setParameter(2, get_Number()); 
		return query.list();
	} 

	// Methods/Metodos 
	/**
	 * @ejb:interface-method
	 */
	public void translate()  {
		try { 		
			org.openxava.test.calculators.TranslateCarrierNameCalculator translateCalculator = (org.openxava.test.calculators.TranslateCarrierNameCalculator)
				getMetaModel().getMetaMethod("translate").getMetaCalculator().createCalculator(); 
				translateCalculator.setEntity(this); 
			translateCalculator.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("method_execution_error", "translate", "Carrier"));
		}
	} 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Collection findAll() {
 		org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Carrier as o"); 
 		org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Carrier as o"); 
 		return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery);
 	} 


	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Carrier").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		StringBuffer toStringValue = new StringBuffer("[.");
		java.lang.reflect.Field [] fields = getClass().getDeclaredFields();
		Arrays.sort(fields, FieldComparator.getInstance());
		for (int i=0; i < fields.length; i++) {
			try {
				if (getMetaModel().isKey(fields[i].getName())) {
					toStringValue.append(fields[i].get(this)).append('.');
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
				toStringValue.append(" ").append('.');
			}
		}
		toStringValue.append(']');
		return toStringValue.toString();
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}