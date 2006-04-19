
// File generated by OpenXava: Wed Apr 19 12:36:33 CEST 2006
// Archivo generado por OpenXava: Wed Apr 19 12:36:33 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Entity/Entidad

package org.openxava.test.model.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.openxava.ejbx.*;
import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.validators.ValidationException;

import org.openxava.test.model.*;


/**
 * @ejb:bean name="Customer" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/Customer" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.ICustomer"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Customer" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findBySeller(int number)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Seller_number = ?1 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findBySeller(int number)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Seller_number = ?1 " 	
 * @ejb:finder signature="Collection findByAlternateSeller(int number)" query="SELECT OBJECT(o) FROM Customer o WHERE o._AlternateSeller_number = ?1 " view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByAlternateSeller(int number)" query="SELECT OBJECT(o) FROM Customer o WHERE o._AlternateSeller_number = ?1 " 	
 * @ejb:finder signature="Customer findByNumber(int number)" query="SELECT OBJECT(o) FROM Customer o WHERE o.number = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Customer findByNumber(int number)" query="SELECT OBJECT(o) FROM Customer o WHERE o.number = ?1" 	
 * @ejb:finder signature="Collection findByNameLike(java.lang.String name)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Name like ?1 ORDER BY o._Name desc" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByNameLike(java.lang.String name)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Name like ?1 ORDER BY o._Name desc" 	
 * @ejb:finder signature="Collection findByNameLikeAndrelationWithSeller(java.lang.String name, java.lang.String relationWithSeller)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Name like ?1 and o._RelationWithSeller = ?2 ORDER BY o._Name desc" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByNameLikeAndrelationWithSeller(java.lang.String name, java.lang.String relationWithSeller)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Name like ?1 and o._RelationWithSeller = ?2 ORDER BY o._Name desc" 	
 * @ejb:finder signature="Collection findNormalOnes()" query="SELECT OBJECT(o) FROM Customer o WHERE o._Type = 1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findNormalOnes()" query="SELECT OBJECT(o) FROM Customer o WHERE o._Type = 1" 	
 * @ejb:finder signature="Collection findSteadyOnes()" query="SELECT OBJECT(o) FROM Customer o WHERE o._Type = 2" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findSteadyOnes()" query="SELECT OBJECT(o) FROM Customer o WHERE o._Type = 2" 	
 * @ejb:finder signature="Collection findByStreet(java.lang.String street)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Address_street = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByStreet(java.lang.String street)" query="SELECT OBJECT(o) FROM Customer o WHERE o._Address_street = ?1" 	
 * @ejb:finder signature="Collection findAll()" query="SELECT OBJECT(o) FROM Customer o" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findAll()" query="SELECT OBJECT(o) FROM Customer o" 
 * 
 * @jboss:table-name "XAVATEST_CUSTOMER"
 *
 * @author Javier Paniza
 */
abstract public class CustomerBean extends EJBReplicableBase 
			implements org.openxava.test.model.ICustomer, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CustomerKey ejbCreate(Map values) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		executeSets(values); 
			
		return null;
	} 
	public void ejbPostCreate(Map values) 
		throws
			CreateException,
			ValidationException { 
	} 
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CustomerKey ejbCreate(org.openxava.test.model.CustomerData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setNumber(data.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.CustomerData data) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.CustomerKey ejbCreate(org.openxava.test.model.CustomerValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setCustomerValue(value); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.CustomerValue value) 
		throws
			CreateException,
			ValidationException { 			
	}
	
	public void ejbLoad() {
		creating = false;
		modified = false; 
	}
	
	public void ejbStore() {
		if (creating) {
			creating = false;
			return;
		}
		if (!modified) return; 
		
		modified = false;
	} 	
	

	public void ejbRemove() throws RemoveException { 						
	} 	
	
	// Properties/Propiedades 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public boolean isLocal() {	
		try { 
			org.openxava.hibernate.XHibernate.setCmt(true); 		
			org.openxava.test.calculators.IsLocalCustomerCalculator localCalculator= (org.openxava.test.calculators.IsLocalCustomerCalculator)
				getMetaModel().getMetaProperty("local").getMetaCalculator().createCalculator();  	
			
			localCalculator.setStateId(getAddress().getState().getId());  	
			
			localCalculator.setStateName(getAddress().getState().getName()); 
			return ((Boolean) localCalculator.calculate()).booleanValue();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references
			return false; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.calculate_value_error", "Local", "Customer", ex.getLocalizedMessage()));
		} 
		finally {
			org.openxava.hibernate.XHibernate.setCmt(false);
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
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "type"));
			}
			
		}	
		return typeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "TYPE"
	 */
	public abstract java.lang.Integer get_Type();
	public abstract void set_Type(java.lang.Integer newType); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getType() {
		try {
			return ((Integer) getTypeConverter().toJava(get_Type())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Type", "Customer", "int"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setType(int newType) {
		try { 
			this.modified = true; 
			set_Type((java.lang.Integer) getTypeConverter().toDB(new Integer(newType)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Type", "Customer", "int"));
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
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "remarks"));
			}
			
		}	
		return remarksConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "REMARKS"
	 */
	public abstract java.lang.String get_Remarks();
	public abstract void set_Remarks(java.lang.String newRemarks); 	
	
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "Customer", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setRemarks(java.lang.String newRemarks) {
		try { 
			this.modified = true; 
			set_Remarks((java.lang.String) getRemarksConverter().toDB(newRemarks));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "Customer", "java.lang.String"));
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
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "relationWithSeller"));
			}
			
		}	
		return relationWithSellerConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "RELATIONSELLER"
	 */
	public abstract java.lang.String get_RelationWithSeller();
	public abstract void set_RelationWithSeller(java.lang.String newRelationWithSeller); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getRelationWithSeller() {
		try {
			return (String) getRelationWithSellerConverter().toJava(get_RelationWithSeller());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "RelationWithSeller", "Customer", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setRelationWithSeller(String newRelationWithSeller) {
		try { 
			this.modified = true; 
			set_RelationWithSeller((java.lang.String) getRelationWithSellerConverter().toDB(newRelationWithSeller));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "RelationWithSeller", "Customer", "String"));
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
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "photo"));
			}
			
		}	
		return photoConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "PHOTO"
	 */
	public abstract byte [] get_Photo();
	public abstract void set_Photo(byte [] newPhoto); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public byte[] getPhoto() {
		try {
			return (byte[]) getPhotoConverter().toJava(get_Photo());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Photo", "Customer", "byte[]"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setPhoto(byte[] newPhoto) {
		try { 
			this.modified = true; 
			set_Photo((byte []) getPhotoConverter().toDB(newPhoto));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Photo", "Customer", "byte[]"));
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
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "name"));
			}
			
		}	
		return nameConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "NAME"
	 */
	public abstract java.lang.String get_Name();
	public abstract void set_Name(java.lang.String newName); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getName() {
		try {
			return (String) getNameConverter().toJava(get_Name());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Customer", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setName(String newName) {
		try { 
			this.modified = true; 
			set_Name((java.lang.String) getNameConverter().toDB(newName));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Name", "Customer", "String"));
		}		
	} 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getCity() {	
		try { 
			org.openxava.hibernate.XHibernate.setCmt(true); 		
			org.openxava.calculators.ConcatCalculator cityCalculator= (org.openxava.calculators.ConcatCalculator)
				getMetaModel().getMetaProperty("city").getMetaCalculator().createCalculator();  	
			
			cityCalculator.setInt1(getAddress_zipCode());  	
			
			cityCalculator.setString2(getAddress_city()); 
			return (String) cityCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.calculate_value_error", "City", "Customer", ex.getLocalizedMessage()));
		} 
		finally {
			org.openxava.hibernate.XHibernate.setCmt(false);
		} 		
	}
	public void setCity(String newCity) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "NUMBER"
	 */
	public abstract int getNumber();
	/**
	  * 
	  */
	public abstract void setNumber(int newNumber); 

	// Colecciones/Collections	

	private org.openxava.test.model.DeliveryPlaceHome deliveryPlacesHome; 
	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getDeliveryPlaces() {		
		try {
			return getDeliveryPlacesHome().findByCustomer(getNumber());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "DeliveryPlaces", "Customer"));
		}
	}
		
	private org.openxava.test.model.DeliveryPlaceHome getDeliveryPlacesHome() throws Exception{
		if (deliveryPlacesHome == null) {
			deliveryPlacesHome = (org.openxava.test.model.DeliveryPlaceHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/DeliveryPlace"),
			 		org.openxava.test.model.DeliveryPlaceHome.class);			 		
		}
		return deliveryPlacesHome;
	}		

	// References/Referencias 

	// Seller : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.ISeller getSeller() {
		try {		
			return getSellerHome().findByPrimaryKey(getSellerKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Seller", "Customer"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.SellerRemote getSellerRemote() {
		return (org.openxava.test.model.SellerRemote) getSeller();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setSeller(org.openxava.test.model.ISeller newSeller) { 
		this.modified = true; 
		try {	
			if (newSeller == null) setSellerKey(null);
			else {
				if (newSeller instanceof org.openxava.test.model.Seller) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.SellerRemote remote = (org.openxava.test.model.SellerRemote) newSeller;
				setSellerKey((org.openxava.test.model.SellerKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Seller", "Customer"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.SellerKey getSellerKey() {				
		org.openxava.test.model.SellerKey key = new org.openxava.test.model.SellerKey(); 
		key.number = getSeller_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setSellerKey(org.openxava.test.model.SellerKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.SellerKey(); 
			setSeller_number(key.number);					
		}
		else { 
			setSeller_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "SELLER_NUMBER"
	 */
	public abstract int get_Seller_number();
	public abstract void set_Seller_number(int newSeller_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getSeller_number() { 
		return get_Seller_number(); 
	}
	public void setSeller_number(int newSeller_number) { 
		set_Seller_number(newSeller_number); 	
	} 

	private org.openxava.test.model.SellerHome sellerHome;	
	private org.openxava.test.model.SellerHome getSellerHome() throws Exception{
		if (sellerHome == null) {
			sellerHome = (org.openxava.test.model.SellerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Seller"),
			 		org.openxava.test.model.SellerHome.class);			 		
		}
		return sellerHome;
	} 

	// AlternateSeller : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.ISeller getAlternateSeller() {
		try {		
			return getAlternateSellerHome().findByPrimaryKey(getAlternateSellerKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "AlternateSeller", "Customer"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.SellerRemote getAlternateSellerRemote() {
		return (org.openxava.test.model.SellerRemote) getAlternateSeller();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAlternateSeller(org.openxava.test.model.ISeller newAlternateSeller) { 
		this.modified = true; 
		try {	
			if (newAlternateSeller == null) setAlternateSellerKey(null);
			else {
				if (newAlternateSeller instanceof org.openxava.test.model.Seller) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.SellerRemote remote = (org.openxava.test.model.SellerRemote) newAlternateSeller;
				setAlternateSellerKey((org.openxava.test.model.SellerKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "AlternateSeller", "Customer"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.SellerKey getAlternateSellerKey() {				
		org.openxava.test.model.SellerKey key = new org.openxava.test.model.SellerKey(); 
		key.number = getAlternateSeller_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setAlternateSellerKey(org.openxava.test.model.SellerKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.SellerKey(); 
			setAlternateSeller_number(key.number);					
		}
		else { 
			setAlternateSeller_number(key.number);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "ALTERNATESELLER_NUMBER"
	 */
	public abstract int get_AlternateSeller_number();
	public abstract void set_AlternateSeller_number(int newAlternateSeller_number);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public int getAlternateSeller_number() { 
		return get_AlternateSeller_number(); 
	}
	public void setAlternateSeller_number(int newAlternateSeller_number) { 
		set_AlternateSeller_number(newAlternateSeller_number); 	
	} 

	private org.openxava.test.model.SellerHome alternateSellerHome;	
	private org.openxava.test.model.SellerHome getAlternateSellerHome() throws Exception{
		if (alternateSellerHome == null) {
			alternateSellerHome = (org.openxava.test.model.SellerHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Seller"),
			 		org.openxava.test.model.SellerHome.class);			 		
		}
		return alternateSellerHome;
	}  	
	// Address : Aggregate/Agregado 
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */ 
	public org.openxava.test.model.Address getAddress() {
		org.openxava.test.model.Address r = new org.openxava.test.model.Address();		
		r.setZipCode(getAddress_zipCode());		
		r.setStreet(getAddress_street());		
		r.setAsString(getAddress_asString());		
		r.setCity(getAddress_city()); 
		r.setState(getAddress_state());		
		return r;
	} 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */ 	 
	public void setAddress(org.openxava.test.model.Address newAddress) throws java.rmi.RemoteException { 
		this.modified = true; 	
		if (newAddress == null) newAddress = new org.openxava.test.model.Address();		
		setAddress_zipCode(newAddress.getZipCode());		
		setAddress_street(newAddress.getStreet());		
		setAddress_asString(newAddress.getAsString());		
		setAddress_city(newAddress.getCity());		
		setAddress_state(newAddress.getState());			
	} 
	private static org.openxava.converters.IConverter address_zipCodeConverter;
	private org.openxava.converters.IConverter getAddress_zipCodeConverter() {
		if (address_zipCodeConverter == null) {
			try {
				address_zipCodeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("address_zipCode");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "address_zipCode"));
			}
			
		}	
		return address_zipCodeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "ZIPCODE"
	 */
	public abstract java.lang.String get_Address_zipCode();
	public abstract void set_Address_zipCode(java.lang.String newAddress_zipCode); 	
	
	/**
	 * 
	 * 
	 */
	private int getAddress_zipCode() {
		try {
			return ((Integer) getAddress_zipCodeConverter().toJava(get_Address_zipCode())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address_zipCode", "Address", "int"));
		}
	}
	
	/**
	 * 
	 */
	private void setAddress_zipCode(int newAddress_zipCode) {
		try { 
			this.modified = true; 
			set_Address_zipCode((java.lang.String) getAddress_zipCodeConverter().toDB(new Integer(newAddress_zipCode)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address_zipCode", "Address", "int"));
		}		
	} 
	private static org.openxava.converters.IConverter address_streetConverter;
	private org.openxava.converters.IConverter getAddress_streetConverter() {
		if (address_streetConverter == null) {
			try {
				address_streetConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("address_street");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "address_street"));
			}
			
		}	
		return address_streetConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "STREET"
	 */
	public abstract java.lang.String get_Address_street();
	public abstract void set_Address_street(java.lang.String newAddress_street); 	
	
	/**
	 * 
	 * 
	 */
	private String getAddress_street() {
		try {
			return (String) getAddress_streetConverter().toJava(get_Address_street());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address_street", "Address", "String"));
		}
	}
	
	/**
	 * 
	 */
	private void setAddress_street(String newAddress_street) {
		try { 
			this.modified = true; 
			set_Address_street((java.lang.String) getAddress_streetConverter().toDB(newAddress_street));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address_street", "Address", "String"));
		}		
	} 	
	/**
	 * 
	 * 
	 */
	public String getAddress_asString() {	
		try { 
			org.openxava.hibernate.XHibernate.setCmt(true); 		
			org.openxava.calculators.ConcatCalculator address_asStringCalculator= (org.openxava.calculators.ConcatCalculator)
				getMetaModel().getMetaProperty("address.asString").getMetaCalculator().createCalculator();  	
			
			address_asStringCalculator.setString1(getAddress_street());  	
			
			address_asStringCalculator.setInt2(getAddress_zipCode());  	
			
			address_asStringCalculator.setString3(getAddress_city());  	
			
			address_asStringCalculator.setString4(getAddress_state().getName()); 
			return (String) address_asStringCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.calculate_value_error", "Address_asString", "Address", ex.getLocalizedMessage()));
		} 
		finally {
			org.openxava.hibernate.XHibernate.setCmt(false);
		} 		
	}
	public void setAddress_asString(String newAddress_asString) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private static org.openxava.converters.IConverter address_cityConverter;
	private org.openxava.converters.IConverter getAddress_cityConverter() {
		if (address_cityConverter == null) {
			try {
				address_cityConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("address_city");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "address_city"));
			}
			
		}	
		return address_cityConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "CITY"
	 */
	public abstract java.lang.String get_Address_city();
	public abstract void set_Address_city(java.lang.String newAddress_city); 	
	
	/**
	 * 
	 * 
	 */
	private String getAddress_city() {
		try {
			return (String) getAddress_cityConverter().toJava(get_Address_city());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address_city", "Address", "String"));
		}
	}
	
	/**
	 * 
	 */
	private void setAddress_city(String newAddress_city) {
		try { 
			this.modified = true; 
			set_Address_city((java.lang.String) getAddress_cityConverter().toDB(newAddress_city));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Address_city", "Address", "String"));
		}		
	} 

	// Address_state : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.IState getAddress_state() {
		try {		
			return getAddress_stateHome().findByPrimaryKey(getAddress_stateKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Address_state", "Address"));
		}		
	}	
	
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.StateRemote getAddress_stateRemote() {
		return (org.openxava.test.model.StateRemote) getAddress_state();
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setAddress_state(org.openxava.test.model.IState newAddress_state) { 
		this.modified = true; 
		try {	
			if (newAddress_state == null) setAddress_stateKey(null);
			else {
				if (newAddress_state instanceof org.openxava.test.model.State) {
					throw new IllegalArgumentException(XavaResources.getString("pojo_to_ejb_illegal"));
				}
				org.openxava.test.model.StateRemote remote = (org.openxava.test.model.StateRemote) newAddress_state;
				setAddress_stateKey((org.openxava.test.model.StateKey) remote.getPrimaryKey());
			}	
		}
		catch (IllegalArgumentException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Address_state", "Address"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.model.StateKey getAddress_stateKey() {				
		org.openxava.test.model.StateKey key = new org.openxava.test.model.StateKey(); 
		key.id = getAddress_state_id();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setAddress_stateKey(org.openxava.test.model.StateKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.model.StateKey(); 
			setAddress_state_id(key.id);					
		}
		else { 
			setAddress_state_id(key.id);		
		}
	}
	/**		
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "STATE"
	 */
	public abstract String get_Address_state_id();
	public abstract void set_Address_state_id(String newAddress_state_id);

	/**		
	 * @ejb:interface-method
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 */
	public String getAddress_state_id() { 
		return get_Address_state_id(); 
	}
	public void setAddress_state_id(String newAddress_state_id) { 
		set_Address_state_id(newAddress_state_id); 	
	} 

	private org.openxava.test.model.StateHome address_stateHome;	
	private org.openxava.test.model.StateHome getAddress_stateHome() throws Exception{
		if (address_stateHome == null) {
			address_stateHome = (org.openxava.test.model.StateHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/State"),
			 		org.openxava.test.model.StateHome.class);			 		
		}
		return address_stateHome;
	} 

	// Methods/Metodos 
	/**
	 * @ejb:interface-method
	 */
	public void calculateShippingAndHandling()  {
		try { 
			org.openxava.hibernate.XHibernate.setCmt(true); 		
			org.openxava.test.calculators.ShippingAndHandlingCalculator calculateShippingAndHandlingCalculator = (org.openxava.test.calculators.ShippingAndHandlingCalculator)
				getMetaModel().getMetaMethod("calculateShippingAndHandling").getMetaCalculator().createCalculator();  	
			calculateShippingAndHandlingCalculator.setStateId(getAddress().getState().getId());  	
			calculateShippingAndHandlingCalculator.setStateName(getAddress().getState().getName()); 
			calculateShippingAndHandlingCalculator.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("method_execution_error", "calculateShippingAndHandling", "Customer"));
		} 
		finally {
			org.openxava.hibernate.XHibernate.setCmt(false);
		} 
		
	} 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Customer").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CustomerData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.CustomerData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.CustomerValue getCustomerValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setCustomerValue(org.openxava.test.model.CustomerValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setNumber(0); 
		setName(null); 
		setType(0); 
		setPhoto(null); 
		setRemarks(null); 
		setRelationWithSeller(null); 
		setSellerKey(null); 
		setAlternateSellerKey(null); 	
	} 		
}