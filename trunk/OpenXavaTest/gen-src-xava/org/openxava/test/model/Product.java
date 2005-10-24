
// File generated by OpenXava: Mon Oct 24 11:48:04 CEST 2005
// Archivo generado por OpenXava: Mon Oct 24 11:48:04 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Product		Entity/Entidad

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
public class Product implements java.io.Serializable, org.openxava.test.model.IProduct {	
	
	// Properties/Propiedades 
	private org.openxava.converters.IntegerNumberConverter familyNumberConverter;
	private org.openxava.converters.IntegerNumberConverter getFamilyNumberConverter() {
		if (familyNumberConverter == null) {
			try {
				familyNumberConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("familyNumber");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "familyNumber"));
			}
			
		}	
		return familyNumberConverter;
	} 
	private java.lang.Integer _familyNumber;
	private java.lang.Integer get_FamilyNumber() {
		return _familyNumber;
	}
	private void set_FamilyNumber(java.lang.Integer newFamilyNumber) {
		this._familyNumber = newFamilyNumber;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getFamilyNumber() {
		try {
			return ((Integer) getFamilyNumberConverter().toJava(get_FamilyNumber())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "FamilyNumber", "Product", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setFamilyNumber(int newFamilyNumber) {
		try { 
			set_FamilyNumber((java.lang.Integer) getFamilyNumberConverter().toDB(new Integer(newFamilyNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "FamilyNumber", "Product", "int"));
		}		
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "unitPrice"));
			}
			
		}	
		return unitPriceConverter;
	} 
	private java.math.BigDecimal _unitPrice;
	private java.math.BigDecimal get_UnitPrice() {
		return _unitPrice;
	}
	private void set_UnitPrice(java.math.BigDecimal newUnitPrice) {
		this._unitPrice = newUnitPrice;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.math.BigDecimal getUnitPrice() {
		try {
			return (java.math.BigDecimal) getUnitPriceConverter().toJava(get_UnitPrice());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "UnitPrice", "Product", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * 
	 */
	public void setUnitPrice(java.math.BigDecimal newUnitPrice) {
		try { 
			set_UnitPrice((java.math.BigDecimal) getUnitPriceConverter().toDB(newUnitPrice));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "UnitPrice", "Product", "java.math.BigDecimal"));
		}		
	} 
		public org.openxava.test.model.WarehouseKey getWarehouseKey() {
		org.openxava.test.model.WarehouseKey key = new org.openxava.test.model.WarehouseKey();
		key._Number = getWarehouseNumber();
		key.zoneNumber = getWarehouseZoneNumber();
		return key;
	}

	public void setWarehouseKey(org.openxava.test.model.WarehouseKey warehouseKey) {
		setWarehouseNumber(warehouseKey._Number);
		setWarehouseZoneNumber(warehouseKey.zoneNumber);
	}

	private int warehouseZoneNumber;	
	public int getWarehouseZoneNumber() {
		return warehouseZoneNumber;
	}
	public void setWarehouseZoneNumber(int newWarehouseZoneNumber) {
		warehouseZoneNumber = newWarehouseZoneNumber;
	}
	
	private Integer warehouseNumber;	
	public Integer getWarehouseNumber() {
		return warehouseNumber;
	}
	
	public void setWarehouseNumber(Integer newWarehouseNumber) {
		warehouseNumber = newWarehouseNumber;
	}
	 
	private org.openxava.converters.IntegerNumberConverter subfamilyNumberConverter;
	private org.openxava.converters.IntegerNumberConverter getSubfamilyNumberConverter() {
		if (subfamilyNumberConverter == null) {
			try {
				subfamilyNumberConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("subfamilyNumber");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "subfamilyNumber"));
			}
			
		}	
		return subfamilyNumberConverter;
	} 
	private java.lang.Integer _subfamilyNumber;
	private java.lang.Integer get_SubfamilyNumber() {
		return _subfamilyNumber;
	}
	private void set_SubfamilyNumber(java.lang.Integer newSubfamilyNumber) {
		this._subfamilyNumber = newSubfamilyNumber;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getSubfamilyNumber() {
		try {
			return ((Integer) getSubfamilyNumberConverter().toJava(get_SubfamilyNumber())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "SubfamilyNumber", "Product", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setSubfamilyNumber(int newSubfamilyNumber) {
		try { 
			set_SubfamilyNumber((java.lang.Integer) getSubfamilyNumberConverter().toDB(new Integer(newSubfamilyNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "SubfamilyNumber", "Product", "int"));
		}		
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
	public java.lang.String getRemarks() {
		try {
			return (java.lang.String) getRemarksConverter().toJava(get_Remarks());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Product", "java.lang.String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Product", "java.lang.String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter descriptionConverter;
	private org.openxava.converters.TrimStringConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("description");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "description"));
			}
			
		}	
		return descriptionConverter;
	} 
	private java.lang.String _description;
	private java.lang.String get_Description() {
		return _description;
	}
	private void set_Description(java.lang.String newDescription) {
		this._description = newDescription;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getDescription() {
		try {
			return (String) getDescriptionConverter().toJava(get_Description());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Product", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setDescription(String newDescription) {
		try { 
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Product", "String"));
		}		
	} 	
	/**
	 * 
	 * 
	 */
	public java.math.BigDecimal getUnitPriceInPesetas() {
		try { 		
			org.openxava.test.calculators.EurosToPesetasCalculator unitPriceInPesetasCalculator= (org.openxava.test.calculators.EurosToPesetasCalculator)
				getMetaModel().getMetaProperty("unitPriceInPesetas").getMetaCalculator().getCalculator();  	
			
			unitPriceInPesetasCalculator.setEuros(getUnitPrice()); 
			return (java.math.BigDecimal) unitPriceInPesetasCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "UnitPriceInPesetas", "Product", ex.getLocalizedMessage()));
		}
	}
	public void setUnitPriceInPesetas(java.math.BigDecimal newUnitPriceInPesetas) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private long number;
	public long getNumber() {
		return number;
	}
	public void setNumber(long newNumber) {
		this.number = newNumber;
	} 

	// References/Referencias 

	// Colecciones/Collections 

	// Methods/Metodos 
	/**
	 * @ejb:interface-method
	 */
	public void increasePrice()  {
		try { 		
			org.openxava.test.calculators.IncreasePriceCalculator increasePriceCalculator = (org.openxava.test.calculators.IncreasePriceCalculator)
				getMetaModel().getMetaMethod("increasePrice").getMetaCalculator().getCalculator(); 
				increasePriceCalculator.setEntity(this); 
			increasePriceCalculator.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("method_execution_error", "increasePrice", "Product"));
		}
	} 
	/**
	 * @ejb:interface-method
	 */
	public BigDecimal getPrice(String country, BigDecimal tariff) throws ProductException, PriceException {
		try { 		
			org.openxava.test.calculators.ExportPriceCalculator getPriceCalculator = (org.openxava.test.calculators.ExportPriceCalculator)
				getMetaModel().getMetaMethod("getPrice").getMetaCalculator().getCalculator();  	
			getPriceCalculator.setEuros(getUnitPrice()); 		
			getPriceCalculator.setCountry(country); 		
			getPriceCalculator.setTariff(tariff); 
			return (BigDecimal) getPriceCalculator.calculate(); 
		}
		catch (ProductException ex) {
			throw ex; 
		}
		catch (PriceException ex) {
			throw ex; 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("method_execution_error", "getPrice", "Product"));
		}
	} 	

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Product").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "Product::" + number;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}