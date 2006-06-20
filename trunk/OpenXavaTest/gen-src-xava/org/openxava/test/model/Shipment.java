
// File generated by OpenXava: Tue Jun 20 13:11:38 CEST 2006
// Archivo generado por OpenXava: Tue Jun 20 13:11:38 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Shipment		Entity/Entidad

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
public class Shipment implements java.io.Serializable, org.openxava.test.model.IShipment {	

	// Constructor
	public Shipment() {
		initMembers();
	} 

	private void initMembers() { 
		setType(0); 
		setMode(0); 
		setNumber(0); 
		setDescription(null); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter typeConverter;
	private org.openxava.converters.IConverter getTypeConverter() {
		if (typeConverter == null) {
			try {
				typeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("type");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "type"));
			}
			
		}	
		return typeConverter;
	} 
	private java.lang.String type;
	private java.lang.String get_Type() {
		return type;
	}
	private void set_Type(java.lang.String newType) {
		this.type = newType;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getType() {
		try {
			return ((Integer) getTypeConverter().toJava(get_Type())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Type", "Shipment", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setType(int newType) {
		try { 
			set_Type((java.lang.String) getTypeConverter().toDB(new Integer(newType)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Type", "Shipment", "int"));
		}		
	} 
	private static org.openxava.converters.IConverter descriptionConverter;
	private org.openxava.converters.IConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("description");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "description"));
			}
			
		}	
		return descriptionConverter;
	} 
	private java.lang.String description;
	private java.lang.String get_Description() {
		return description;
	}
	private void set_Description(java.lang.String newDescription) {
		this.description = newDescription;
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Shipment", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Shipment", "String"));
		}		
	} 
	private int mode;
	public int getMode() {
		return mode;
	}
	public void setMode(int newMode) {
		this.mode = newMode;
	} 
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int newNumber) {
		this.number = newNumber;
	} 

	// References/Referencias 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Collection findByMode(int mode)  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) {
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Shipment as o where o.mode = :arg0"); 
			query.setParameter("arg0", new Integer(mode)); 
 			return query.getResultList(); 
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Shipment as o where o.mode = :arg0"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Shipment as o where o.mode = :arg0"); 
			query.setParameter("arg0", new Integer(mode)); 
			sizeQuery.setParameter("arg0", new Integer(mode)); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Collection findAll()  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) {
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Shipment as o"); 
 			return query.getResultList(); 
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Shipment as o"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Shipment as o"); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Shipment findByTypeModeNumber(java.lang.String type,int mode,int number) throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) {
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Shipment as o where o.type = :arg0 and mode = :arg1 and number = :arg2"); 
			query.setParameter("arg0", type); 
			query.setParameter("arg1", new Integer(mode)); 
			query.setParameter("arg2", new Integer(number)); 
 			try {
				return (Shipment) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Shipment"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			} 
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Shipment as o where o.type = :arg0 and mode = :arg1 and number = :arg2"); 
			query.setParameter("arg0", type); 
			query.setParameter("arg1", new Integer(mode)); 
			query.setParameter("arg2", new Integer(number)); 
			Shipment r = (Shipment) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Shipment"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Shipment").getMetaEntity(); 	
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