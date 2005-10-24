
// File generated by OpenXava: Mon Oct 24 11:48:05 CEST 2005
// Archivo generado por OpenXava: Mon Oct 24 11:48:05 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Office		Entity/Entidad

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
public class Office implements java.io.Serializable, org.openxava.test.model.IOffice {	
	
	// Properties/Propiedades 
	private org.openxava.converters.IntegerNumberConverter receptionistConverter;
	private org.openxava.converters.IntegerNumberConverter getReceptionistConverter() {
		if (receptionistConverter == null) {
			try {
				receptionistConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("receptionist");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "receptionist"));
			}
			
		}	
		return receptionistConverter;
	} 
	private java.lang.Integer _receptionist;
	private java.lang.Integer get_Receptionist() {
		return _receptionist;
	}
	private void set_Receptionist(java.lang.Integer newReceptionist) {
		this._receptionist = newReceptionist;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getReceptionist() {
		try {
			return ((Integer) getReceptionistConverter().toJava(get_Receptionist())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Receptionist", "Office", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setReceptionist(int newReceptionist) {
		try { 
			set_Receptionist((java.lang.Integer) getReceptionistConverter().toDB(new Integer(newReceptionist)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Receptionist", "Office", "int"));
		}		
	} 
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Office", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Office", "String"));
		}		
	} 
	private org.openxava.converters.IntegerNumberConverter zoneNumberConverter;
	private org.openxava.converters.IntegerNumberConverter getZoneNumberConverter() {
		if (zoneNumberConverter == null) {
			try {
				zoneNumberConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("zoneNumber");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "zoneNumber"));
			}
			
		}	
		return zoneNumberConverter;
	} 
	private java.lang.Integer _zoneNumber;
	private java.lang.Integer get_ZoneNumber() {
		return _zoneNumber;
	}
	private void set_ZoneNumber(java.lang.Integer newZoneNumber) {
		this._zoneNumber = newZoneNumber;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getZoneNumber() {
		try {
			return ((Integer) getZoneNumberConverter().toJava(get_ZoneNumber())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "ZoneNumber", "Office", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setZoneNumber(int newZoneNumber) {
		try { 
			set_ZoneNumber((java.lang.Integer) getZoneNumberConverter().toDB(new Integer(newZoneNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "ZoneNumber", "Office", "int"));
		}		
	} 
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int newNumber) {
		this.number = newNumber;
	} 

	// References/Referencias 
	private org.openxava.test.model.IClerk officeManager;
	public org.openxava.test.model.IClerk getOfficeManager() {
		return officeManager;
	}
	public void setOfficeManager(org.openxava.test.model.IClerk newClerk) {
		this.officeManager = newClerk;
	} 
	private org.openxava.test.model.ICarrier defaultCarrier;
	public org.openxava.test.model.ICarrier getDefaultCarrier() {
		return defaultCarrier;
	}
	public void setDefaultCarrier(org.openxava.test.model.ICarrier newCarrier) {
		this.defaultCarrier = newCarrier;
	} 
	private org.openxava.test.model.IWarehouse mainWarehouse;
	public org.openxava.test.model.IWarehouse getMainWarehouse() {
		return mainWarehouse;
	}
	public void setMainWarehouse(org.openxava.test.model.IWarehouse newWarehouse) {
		this.mainWarehouse = newWarehouse;
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Office").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "Office::" + number;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}