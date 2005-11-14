
// File generated by OpenXava: Fri Nov 11 17:15:20 CET 2005
// Archivo generado por OpenXava: Fri Nov 11 17:15:20 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Aggregate/Agregado: DeliveryPlace

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
public class DeliveryPlace implements java.io.Serializable, org.openxava.test.model.IDeliveryPlace {	
	
	// Properties/Propiedades 
	private String oid;
	public String getOid() {
		return oid;
	}
	public void setOid(String newOid) {
		this.oid = newOid;
	} 
	private org.openxava.converters.TrimStringConverter remarksConverter;
	private org.openxava.converters.TrimStringConverter getRemarksConverter() {
		if (remarksConverter == null) {
			try {
				remarksConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("remarks");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "remarks"));
			}
			
		}	
		return remarksConverter;
	} 
	private java.lang.String _remarks;
	private java.lang.String get_Remarks() {
		return _remarks;
	}
	private void set_Remarks(java.lang.String newRemarks) {
		this._remarks = newRemarks;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getRemarks() {
		try {
			return (String) getRemarksConverter().toJava(get_Remarks());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "DeliveryPlace", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setRemarks(String newRemarks) {
		try { 
			set_Remarks((java.lang.String) getRemarksConverter().toDB(newRemarks));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "DeliveryPlace", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter addressConverter;
	private org.openxava.converters.TrimStringConverter getAddressConverter() {
		if (addressConverter == null) {
			try {
				addressConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("address");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "address"));
			}
			
		}	
		return addressConverter;
	} 
	private java.lang.String _address;
	private java.lang.String get_Address() {
		return _address;
	}
	private void set_Address(java.lang.String newAddress) {
		this._address = newAddress;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getAddress() {
		try {
			return (String) getAddressConverter().toJava(get_Address());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Address", "DeliveryPlace", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setAddress(String newAddress) {
		try { 
			set_Address((java.lang.String) getAddressConverter().toDB(newAddress));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Address", "DeliveryPlace", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "DeliveryPlace", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "DeliveryPlace", "String"));
		}		
	} 

	// References/Referencias 
	private org.openxava.test.model.ICustomer customer;
	public org.openxava.test.model.ICustomer getCustomer() {
		return customer;
	}
	public void setCustomer(org.openxava.test.model.ICustomer newCustomer) {
		this.customer = newCustomer;
	} 
	private org.openxava.test.model.IWarehouse preferredWarehouse;
	public org.openxava.test.model.IWarehouse getPreferredWarehouse() {
		return preferredWarehouse;
	}
	public void setPreferredWarehouse(org.openxava.test.model.IWarehouse newWarehouse) {
		this.preferredWarehouse = newWarehouse;
	} 

	// Colecciones/Collections 
	private java.util.Collection receptionists;
	public java.util.Collection getReceptionists() {
		return receptionists;
	}
	public void setReceptionists(java.util.Collection receptionists) {
		this.receptionists = receptionists;
	} 

	// Methods/Metodos 	

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Customer").getMetaAggregate("DeliveryPlace"); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "DeliveryPlace::" + oid;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}