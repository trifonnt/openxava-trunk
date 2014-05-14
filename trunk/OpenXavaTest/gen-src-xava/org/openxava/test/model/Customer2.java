
// File generated by OpenXava: Thu May 08 18:50:41 CEST 2014
// Archivo generado por OpenXava: Thu May 08 18:50:41 CEST 2014

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer2		Entity/Entidad

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
public class Customer2 implements java.io.Serializable, org.openxava.test.model.ICustomer2 {	

	// Constructor
	public Customer2() {
		initMembers();
	} 

	private void initMembers() { 
		setNumber(0); 
		setName(null); 
		setType(0); 
		setPhoto(null); 
		setTelephone(null); 
		setEmail(null); 
		setWebsite(null); 
		setRemarks(null); 
		setRelationWithSeller(null); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter websiteConverter;
	private org.openxava.converters.IConverter getWebsiteConverter() {
		if (websiteConverter == null) {
			try {
				websiteConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("website");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "website"));
			}
			
		}	
		return websiteConverter;
	} 
	private java.lang.String website;
	private java.lang.String get_Website() {
		return website;
	}
	private void set_Website(java.lang.String newWebsite) {
		this.website = newWebsite;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getWebsite() {
		try {
			return (String) getWebsiteConverter().toJava(get_Website());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Website", "Customer2", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setWebsite(String newWebsite) {
		try { 
			set_Website((java.lang.String) getWebsiteConverter().toDB(newWebsite));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Website", "Customer2", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter emailConverter;
	private org.openxava.converters.IConverter getEmailConverter() {
		if (emailConverter == null) {
			try {
				emailConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("email");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "email"));
			}
			
		}	
		return emailConverter;
	} 
	private java.lang.String email;
	private java.lang.String get_Email() {
		return email;
	}
	private void set_Email(java.lang.String newEmail) {
		this.email = newEmail;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getEmail() {
		try {
			return (String) getEmailConverter().toJava(get_Email());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Email", "Customer2", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setEmail(String newEmail) {
		try { 
			set_Email((java.lang.String) getEmailConverter().toDB(newEmail));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Email", "Customer2", "String"));
		}		
	} 
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Customer2", "String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Name", "Customer2", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter remarksConverter;
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Customer2", "java.lang.String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Customer2", "java.lang.String"));
		}		
	} 
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int newNumber) {
		this.number = newNumber;
	} 	
	/**
	 * 
	 * 
	 */
	public boolean isLocal() { 		
		try {			
			org.openxava.test.calculators.IsLocalCustomerCalculator localCalculator= (org.openxava.test.calculators.IsLocalCustomerCalculator)
				getMetaModel().getMetaProperty("local").getMetaCalculator().createCalculator(); 
			return ((Boolean) localCalculator.calculate()).booleanValue();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references
			return false; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "Local", "Customer2", ex.getLocalizedMessage()));
		} 		
	}
	public void setLocal(boolean newLocal) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
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
	private java.lang.Integer type;
	private java.lang.Integer get_Type() {
		return type;
	}
	private void set_Type(java.lang.Integer newType) {
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Type", "Customer2", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setType(int newType) {
		try { 
			set_Type((java.lang.Integer) getTypeConverter().toDB(new Integer(newType)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Type", "Customer2", "int"));
		}		
	} 
	private static org.openxava.converters.IConverter telephoneConverter;
	private org.openxava.converters.IConverter getTelephoneConverter() {
		if (telephoneConverter == null) {
			try {
				telephoneConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("telephone");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "telephone"));
			}
			
		}	
		return telephoneConverter;
	} 
	private java.lang.String telephone;
	private java.lang.String get_Telephone() {
		return telephone;
	}
	private void set_Telephone(java.lang.String newTelephone) {
		this.telephone = newTelephone;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getTelephone() {
		try {
			return (String) getTelephoneConverter().toJava(get_Telephone());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Telephone", "Customer2", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setTelephone(String newTelephone) {
		try { 
			set_Telephone((java.lang.String) getTelephoneConverter().toDB(newTelephone));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Telephone", "Customer2", "String"));
		}		
	} 
	private static org.openxava.converters.IConverter photoConverter;
	private org.openxava.converters.IConverter getPhotoConverter() {
		if (photoConverter == null) {
			try {
				photoConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("photo");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "photo"));
			}
			
		}	
		return photoConverter;
	} 
	private byte[] photo;
	private byte[] get_Photo() {
		return photo;
	}
	private void set_Photo(byte[] newPhoto) {
		this.photo = newPhoto;
	} 	
	
	/**
	 * 
	 * 
	 */
	public byte[] getPhoto() {
		try {
			return (byte[]) getPhotoConverter().toJava(get_Photo());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Photo", "Customer2", "byte[]"));
		}
	}
	
	/**
	 * 
	 */
	public void setPhoto(byte[] newPhoto) {
		try { 
			set_Photo((byte[]) getPhotoConverter().toDB(newPhoto));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Photo", "Customer2", "byte[]"));
		}		
	} 
	private static org.openxava.converters.IConverter relationWithSellerConverter;
	private org.openxava.converters.IConverter getRelationWithSellerConverter() {
		if (relationWithSellerConverter == null) {
			try {
				relationWithSellerConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("relationWithSeller");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "relationWithSeller"));
			}
			
		}	
		return relationWithSellerConverter;
	} 
	private java.lang.String relationWithSeller;
	private java.lang.String get_RelationWithSeller() {
		return relationWithSeller;
	}
	private void set_RelationWithSeller(java.lang.String newRelationWithSeller) {
		this.relationWithSeller = newRelationWithSeller;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getRelationWithSeller() {
		try {
			return (String) getRelationWithSellerConverter().toJava(get_RelationWithSeller());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "RelationWithSeller", "Customer2", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setRelationWithSeller(String newRelationWithSeller) {
		try { 
			set_RelationWithSeller((java.lang.String) getRelationWithSellerConverter().toDB(newRelationWithSeller));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "RelationWithSeller", "Customer2", "String"));
		}		
	} 	
	/**
	 * 
	 * 
	 */
	public String getCity() { 		
		try {			
			org.openxava.calculators.ConcatCalculator cityCalculator= (org.openxava.calculators.ConcatCalculator)
				getMetaModel().getMetaProperty("city").getMetaCalculator().createCalculator(); 
			return (String) cityCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "City", "Customer2", ex.getLocalizedMessage()));
		} 		
	}
	public void setCity(String newCity) {
		// for it is in value object
		// para que aparezca en los value objects
	} 

	// References/Referencias 

	private org.openxava.test.model.ISeller alternateSeller; 	
	public org.openxava.test.model.ISeller getAlternateSeller() {
		if (alternateSeller != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				alternateSeller.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return alternateSeller;
	}
	public void setAlternateSeller(org.openxava.test.model.ISeller newSeller) {
		if (newSeller != null && !(newSeller instanceof org.openxava.test.model.Seller)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.alternateSeller = newSeller; 
	} 

	private org.openxava.test.model.ISeller2 seller; 	
	public org.openxava.test.model.ISeller2 getSeller() {
		if (seller != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				seller.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return seller;
	}
	public void setSeller(org.openxava.test.model.ISeller2 newSeller2) {
		if (newSeller2 != null && !(newSeller2 instanceof org.openxava.test.model.Seller2)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.seller = newSeller2; 
	} 

	// Colecciones/Collections 

	// Methods/Metodos 
	/**
	 * @ejb:interface-method
	 */
	public void calculateShippingAndHandling()  { 		
		try {			
			org.openxava.test.calculators.ShippingAndHandlingCalculator calculateShippingAndHandlingCalculator = (org.openxava.test.calculators.ShippingAndHandlingCalculator)
				getMetaModel().getMetaMethod("calculateShippingAndHandling").getMetaCalculator().createCalculator(); 
			calculateShippingAndHandlingCalculator.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("method_execution_error", "calculateShippingAndHandling", "Customer2"));
		} 
		
	} 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static Customer2 findByNumber(int number) throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Customer2 as o where o.number = :arg0"); 
			query.setParameter("arg0", new Integer(number)); 
 			try {
				return (Customer2) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Customer2"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			}  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Customer2 as o where o.number = :arg0"); 
			query.setParameter("arg0", new Integer(number)); 
			Customer2 r = (Customer2) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "Customer2"));
			}
			return r; 
 		}
 	} 	
 	public static Collection findByNameLike(java.lang.String name)  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Customer2 as o where o.name like :arg0 order by o.name desc"); 
			query.setParameter("arg0", name); 
 			return query.getResultList();  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Customer2 as o where o.name like :arg0 order by o.name desc"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Customer2 as o where o.name like :arg0"); 
			query.setParameter("arg0", name); 
			sizeQuery.setParameter("arg0", name); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Collection findByNameLikeAndrelationWithSeller(java.lang.String name, java.lang.String relationWithSeller)  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Customer2 as o where o.name like :arg0 and relationWithSeller = :arg1 order by o.name desc"); 
			query.setParameter("arg0", name); 
			query.setParameter("arg1", relationWithSeller); 
 			return query.getResultList();  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Customer2 as o where o.name like :arg0 and relationWithSeller = :arg1 order by o.name desc"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Customer2 as o where o.name like :arg0 and relationWithSeller = :arg1"); 
			query.setParameter("arg0", name); 
			sizeQuery.setParameter("arg0", name); 
			query.setParameter("arg1", relationWithSeller); 
			sizeQuery.setParameter("arg1", relationWithSeller); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Collection findNormalOnes()  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Customer2 as o where o.type = 0"); 
 			return query.getResultList();  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Customer2 as o where o.type = 0"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Customer2 as o where o.type = 0"); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Collection findSteadyOnes()  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Customer2 as o where o.type = 1"); 
 			return query.getResultList();  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Customer2 as o where o.type = 1"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Customer2 as o where o.type = 1"); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 	
 	public static Collection findAll()  {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from Customer2 as o"); 
 			return query.getResultList();  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from Customer2 as o"); 
 			org.hibernate.Query sizeQuery = org.openxava.hibernate.XHibernate.getSession().createQuery("select count(*) from Customer2 as o"); 
 			return new org.openxava.hibernate.impl.FastSizeList(query, sizeQuery); 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Customer2").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "Customer2"));
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