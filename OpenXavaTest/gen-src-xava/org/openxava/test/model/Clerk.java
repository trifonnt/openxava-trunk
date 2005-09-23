
// File generated by OpenXava: Fri Sep 23 17:12:44 CEST 2005
// Archivo generado por OpenXava: Fri Sep 23 17:12:44 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Clerk		Entity/Entidad

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
public class Clerk implements java.io.Serializable, org.openxava.test.model.IClerk {	
	
	// Properties/Propiedades 
	private org.openxava.converters.TrimStringConverter nameConverter;
	private org.openxava.converters.TrimStringConverter getNameConverter() {
		if (nameConverter == null) {
			try {
				nameConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("name");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "name"));
			}
			
		}	
		return nameConverter;
	} 
	private java.lang.String _name;
	private java.lang.String get_Name() {
		return _name;
	}
	private void set_Name(java.lang.String newName) {
		this._name = newName;
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Clerk", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Clerk", "String"));
		}		
	} 
	private int officeNumber;
	public int getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(int newOfficeNumber) {
		this.officeNumber = newOfficeNumber;
	} 
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int newNumber) {
		this.number = newNumber;
	} 
	private int zoneNumber;
	public int getZoneNumber() {
		return zoneNumber;
	}
	public void setZoneNumber(int newZoneNumber) {
		this.zoneNumber = newZoneNumber;
	} 

	// References/Referencias 

	// Colecciones/Collections 

	// Methods/Metodos 	

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Clerk").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "Clerk::" + zoneNumber + "::" + officeNumber + "::" + number;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}