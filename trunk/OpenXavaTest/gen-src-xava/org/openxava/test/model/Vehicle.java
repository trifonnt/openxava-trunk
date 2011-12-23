
// File generated by OpenXava: Tue Dec 13 12:49:16 CET 2011
// Archivo generado por OpenXava: Tue Dec 13 12:49:16 CET 2011

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Vehicle		Entity/Entidad

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
public class Vehicle implements java.io.Serializable, org.openxava.test.model.IVehicle {	

	// Constructor
	public Vehicle() {
		initMembers();
	} 

	private void initMembers() { 
		setOid(null); 
		setCode(null); 
		setModel(null); 
		setMake(null); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter codeConverter;
	private org.openxava.converters.IConverter getCodeConverter() {
		if (codeConverter == null) {
			try {
				codeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("code");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "code"));
			}
			
		}	
		return codeConverter;
	} 
	private java.lang.String code;
	private java.lang.String get_Code() {
		return code;
	}
	private void set_Code(java.lang.String newCode) {
		this.code = newCode;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getCode() {
		try {
			return (String) getCodeConverter().toJava(get_Code());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Code", "Vehicle", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setCode(String newCode) {
		try { 
			set_Code((java.lang.String) getCodeConverter().toDB(newCode));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Code", "Vehicle", "String"));
		}		
	} 
	private String oid;
	public String getOid() {
		return oid;
	}
	public void setOid(String newOid) {
		this.oid = newOid;
	} 
	private static org.openxava.converters.IConverter makeConverter;
	private org.openxava.converters.IConverter getMakeConverter() {
		if (makeConverter == null) {
			try {
				makeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("make");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "make"));
			}
			
		}	
		return makeConverter;
	} 
	private java.lang.String make;
	private java.lang.String get_Make() {
		return make;
	}
	private void set_Make(java.lang.String newMake) {
		this.make = newMake;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getMake() {
		try {
			return (String) getMakeConverter().toJava(get_Make());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Make", "Vehicle", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setMake(String newMake) {
		try { 
			set_Make((java.lang.String) getMakeConverter().toDB(newMake));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Make", "Vehicle", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter modelConverter;
	private org.openxava.converters.IConverter getModelConverter() {
		if (modelConverter == null) {
			try {
				modelConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("model");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "model"));
			}
			
		}	
		return modelConverter;
	} 
	private java.lang.String model;
	private java.lang.String get_Model() {
		return model;
	}
	private void set_Model(java.lang.String newModel) {
		this.model = newModel;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getModel() {
		try {
			return (String) getModelConverter().toJava(get_Model());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Model", "Vehicle", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setModel(String newModel) {
		try { 
			set_Model((java.lang.String) getModelConverter().toDB(newModel));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Model", "Vehicle", "String"));
		}		
	} 

	// References/Referencias 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Vehicle findByOid(java.lang.String oid) throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Vehicle as o where o.oid = :arg0"); 
			query.setParameter("arg0", oid); 
 			try {
				return (Vehicle) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Vehicle"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			}  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Vehicle as o where o.oid = :arg0"); 
			query.setParameter("arg0", oid); 
			Vehicle r = (Vehicle) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Vehicle"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Vehicle").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "Vehicle"));
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