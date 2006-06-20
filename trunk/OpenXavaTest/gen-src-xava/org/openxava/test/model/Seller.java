
// File generated by OpenXava: Tue Jun 20 13:11:37 CEST 2006
// Archivo generado por OpenXava: Tue Jun 20 13:11:37 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Seller		Entity/Entidad

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
public class Seller implements java.io.Serializable, org.openxava.test.model.ISeller {	

	// Constructor
	public Seller() {
		initMembers();
	} 

	private void initMembers() { 
		setNumber(0); 
		setName(null); 
		setRegions(null); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter nameConverter;
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Seller", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Seller", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter regionsConverter;
	private org.openxava.converters.IConverter getRegionsConverter() {
		if (regionsConverter == null) {
			try {
				regionsConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("regions");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "regions"));
			}
			
		}	
		return regionsConverter;
	} 
	private java.lang.String regions;
	private java.lang.String get_Regions() {
		return regions;
	}
	private void set_Regions(java.lang.String newRegions) {
		this.regions = newRegions;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String [] getRegions() {
		try {
			return (String []) getRegionsConverter().toJava(get_Regions());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Regions", "Seller", "String []"));
		}
	}
	
	/**
	 * 
	 */
	public void setRegions(String [] newRegions) {
		try { 
			set_Regions((java.lang.String) getRegionsConverter().toDB(newRegions));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Regions", "Seller", "String []"));
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

	private org.openxava.test.model.ISellerLevel level; 	
	public org.openxava.test.model.ISellerLevel getLevel() {
		if (level != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				level.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return level;
	}
	public void setLevel(org.openxava.test.model.ISellerLevel newSellerLevel) {
		if (newSellerLevel != null && !(newSellerLevel instanceof org.openxava.test.model.SellerLevel)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.level = newSellerLevel; 
	} 

	private org.openxava.test.model.ISeller boss; 	
	public org.openxava.test.model.ISeller getBoss() {
		if (boss != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				boss.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return boss;
	}
	public void setBoss(org.openxava.test.model.ISeller newSeller) {
		if (newSeller != null && !(newSeller instanceof org.openxava.test.model.Seller)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.boss = newSeller; 
	} 

	// Colecciones/Collections 
	private java.util.Collection customers;
	public java.util.Collection getCustomers() {
		return customers;
	}
	public void setCustomers(java.util.Collection customers) {
		this.customers = customers;
	} 
	
	public void addToCustomers(org.openxava.test.model.ICustomer newElement) throws RemoteException {
		this.getCustomers().add(newElement);
		newElement.setSeller(this);
	}
	public void removeFromCustomers(org.openxava.test.model.ICustomer toRemove) throws RemoteException {
		this.getCustomers().remove(toRemove);
		toRemove.setSeller(null);
	} 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Collection findAll()  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) {
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Seller as o where 1 = 1"); 
 			return query.getResultList(); 
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Seller as o where 1 = 1"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Seller as o where 1 = 1"); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Seller findByNumber(int number) throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) {
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Seller as o where o.number = :arg0"); 
			query.setParameter("arg0", new Integer(number)); 
 			try {
				return (Seller) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Seller"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			} 
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Seller as o where o.number = :arg0"); 
			query.setParameter("arg0", new Integer(number)); 
			Seller r = (Seller) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Seller"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Seller").getMetaEntity(); 	
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