
// File generated by OpenXava: Sat Mar 05 14:15:45 CET 2005
// Archivo generado por OpenXava: Sat Mar 05 14:15:45 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Subfamily		Entity/Entidad

package org.openxava.test.model;

import java.util.*;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.*;

/**
 * 
 * @author MCarmen Gimeno
 */
public class Subfamily implements java.io.Serializable {	
	
	// Properties/Propiedades 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getFamily() {
		try { 		
			org.openxava.calculators.EmptyStringCalculator familyCalculator= (org.openxava.calculators.EmptyStringCalculator)
				getMetaModel().getMetaProperty("family").getMetaCalculator().getCalculator(); 
			return (String) familyCalculator.calculate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "Family", "Subfamily", ex.getLocalizedMessage()));
		}
	}
	public void setFamily(String newFamily) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
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
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getFamilyNumber() {
		try {
			return ((Integer) getFamilyNumberConverter().toJava(get_FamilyNumber())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "FamilyNumber", "Subfamily", "int"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setFamilyNumber(int newFamilyNumber) {
		try {
			set_FamilyNumber((java.lang.Integer) getFamilyNumberConverter().toDB(new Integer(newFamilyNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "FamilyNumber", "Subfamily", "int"));
		}		
	} 
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
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.lang.String getRemarks() {
		try {
			return (java.lang.String) getRemarksConverter().toJava(get_Remarks());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Subfamily", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setRemarks(java.lang.String newRemarks) {
		try {
			set_Remarks((java.lang.String) getRemarksConverter().toDB(newRemarks));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Subfamily", "java.lang.String"));
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
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getDescription() {
		try {
			return (String) getDescriptionConverter().toJava(get_Description());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Subfamily", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDescription(String newDescription) {
		try {
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Subfamily", "String"));
		}		
	} 
	private org.openxava.converters.IntegerNumberConverter numberConverter;
	private org.openxava.converters.IntegerNumberConverter getNumberConverter() {
		if (numberConverter == null) {
			try {
				numberConverter = (org.openxava.converters.IntegerNumberConverter) 
					getMetaModel().getMapping().getConverter("number");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "number"));
			}
			
		}	
		return numberConverter;
	} 
	private java.lang.Integer _number;
	private java.lang.Integer get_Number() {
		return _number;
	}
	private void set_Number(java.lang.Integer newNumber) {
		this._number = newNumber;
	} 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getNumber() {
		try {
			return ((Integer) getNumberConverter().toJava(get_Number())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Number", "Subfamily", "int"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setNumber(int newNumber) {
		try {
			set_Number((java.lang.Integer) getNumberConverter().toDB(new Integer(newNumber)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Number", "Subfamily", "int"));
		}		
	} 

	// References/Referencias 

	// Colecciones/Collections 
	
	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Subfamily").getMetaEntity(); 	
		}
		return metaModel;
	}
}