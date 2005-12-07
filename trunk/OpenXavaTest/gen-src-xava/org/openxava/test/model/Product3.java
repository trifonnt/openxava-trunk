
// File generated by OpenXava: Wed Dec 07 17:51:22 CET 2005
// Archivo generado por OpenXava: Wed Dec 07 17:51:22 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Product3		Entity/Entidad

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
public class Product3 implements java.io.Serializable, org.openxava.test.model.IProduct3 {	
	
	// Properties/Propiedades 
	private org.openxava.converters.TrimStringConverter commentsConverter;
	private org.openxava.converters.TrimStringConverter getCommentsConverter() {
		if (commentsConverter == null) {
			try {
				commentsConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("comments");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "comments"));
			}
			
		}	
		return commentsConverter;
	} 
	private java.lang.String _comments;
	private java.lang.String get_Comments() {
		return _comments;
	}
	private void set_Comments(java.lang.String newComments) {
		this._comments = newComments;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.lang.String getComments() {
		try {
			return (java.lang.String) getCommentsConverter().toJava(get_Comments());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Comments", "Product3", "java.lang.String"));
		}
	}
	
	/**
	 * 
	 */
	public void setComments(java.lang.String newComments) {
		try { 
			set_Comments((java.lang.String) getCommentsConverter().toDB(newComments));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Comments", "Product3", "java.lang.String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Product3", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Product3", "String"));
		}		
	} 
	private long number;
	public long getNumber() {
		return number;
	}
	public void setNumber(long newNumber) {
		this.number = newNumber;
	} 

	// References/Referencias  	
	// Subfamily1 : Aggregate/Agregado 
	public org.openxava.test.model.SubfamilyInfo getSubfamily1() {
		org.openxava.test.model.SubfamilyInfo r = new org.openxava.test.model.SubfamilyInfo(); 
		r.setFamily(getSubfamily1_family()); 
		r.setSubfamily(getSubfamily1_subfamily());		
		return r;
	} 	 
	public void setSubfamily1(org.openxava.test.model.SubfamilyInfo newSubfamily1) { 	
		if (newSubfamily1 == null) newSubfamily1 = new org.openxava.test.model.SubfamilyInfo();		
		setSubfamily1_family(newSubfamily1.getFamily());		
		setSubfamily1_subfamily(newSubfamily1.getSubfamily());			
	} 
	private org.openxava.test.model.IFamily2 subfamily1_family;
	public org.openxava.test.model.IFamily2 getSubfamily1_family() {
		return subfamily1_family;
	}
	public void setSubfamily1_family(org.openxava.test.model.IFamily2 newFamily2) {
		this.subfamily1_family = newFamily2;
	} 
	private org.openxava.test.model.ISubfamily2 subfamily1_subfamily;
	public org.openxava.test.model.ISubfamily2 getSubfamily1_subfamily() {
		return subfamily1_subfamily;
	}
	public void setSubfamily1_subfamily(org.openxava.test.model.ISubfamily2 newSubfamily2) {
		this.subfamily1_subfamily = newSubfamily2;
	} 
	private org.openxava.test.model.IFamily family;
	public org.openxava.test.model.IFamily getFamily() {
		return family;
	}
	public void setFamily(org.openxava.test.model.IFamily newFamily) {
		this.family = newFamily;
	}  	
	// Subfamily2 : Aggregate/Agregado 
	public org.openxava.test.model.SubfamilyInfo getSubfamily2() {
		org.openxava.test.model.SubfamilyInfo r = new org.openxava.test.model.SubfamilyInfo(); 
		r.setFamily(getSubfamily2_family()); 
		r.setSubfamily(getSubfamily2_subfamily());		
		return r;
	} 	 
	public void setSubfamily2(org.openxava.test.model.SubfamilyInfo newSubfamily2) { 	
		if (newSubfamily2 == null) newSubfamily2 = new org.openxava.test.model.SubfamilyInfo();		
		setSubfamily2_family(newSubfamily2.getFamily());		
		setSubfamily2_subfamily(newSubfamily2.getSubfamily());			
	} 
	private org.openxava.test.model.IFamily2 subfamily2_family;
	public org.openxava.test.model.IFamily2 getSubfamily2_family() {
		return subfamily2_family;
	}
	public void setSubfamily2_family(org.openxava.test.model.IFamily2 newFamily2) {
		this.subfamily2_family = newFamily2;
	} 
	private org.openxava.test.model.ISubfamily2 subfamily2_subfamily;
	public org.openxava.test.model.ISubfamily2 getSubfamily2_subfamily() {
		return subfamily2_subfamily;
	}
	public void setSubfamily2_subfamily(org.openxava.test.model.ISubfamily2 newSubfamily2) {
		this.subfamily2_subfamily = newSubfamily2;
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Product3").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "Product3::" + number;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}