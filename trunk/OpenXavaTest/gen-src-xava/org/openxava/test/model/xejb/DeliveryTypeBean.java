
// File generated by OpenXava: Thu Nov 16 09:44:09 CET 2006
// Archivo generado por OpenXava: Thu Nov 16 09:44:09 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: DeliveryType		Entity/Entidad

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
 * @ejb:bean name="DeliveryType" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.model/DeliveryType" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.model.IDeliveryType"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="DeliveryType" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="DeliveryType findByNumber(int number)" query="SELECT OBJECT(o) FROM DeliveryType o WHERE o.number = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="DeliveryType findByNumber(int number)" query="SELECT OBJECT(o) FROM DeliveryType o WHERE o.number = ?1" 
 * 
 * @jboss:table-name "XAVATEST_DeliveryType"
 *
 * @author Javier Paniza
 */
abstract public class DeliveryTypeBean extends EJBReplicableBase 
			implements org.openxava.test.model.IDeliveryType, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DeliveryTypeKey ejbCreate(Map values) 
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
		boolean cmtActivated = false;
		if (!org.openxava.hibernate.XHibernate.isCmt()) {
			org.openxava.hibernate.XHibernate.setCmt(true);
			cmtActivated = true;
		}
		try { 		
			org.openxava.test.calculators.DeliveryTypePostcreateCalculator calculator0= (org.openxava.test.calculators.DeliveryTypePostcreateCalculator)
				getMetaModel().getMetaCalculatorPostCreate(0).createCalculator(); 
			calculator0.setNumber(getNumber()); 
			calculator0.setModel(this); 
			calculator0.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryType", ex.getLocalizedMessage()));
		}
		finally {
			if (cmtActivated) {
				org.openxava.hibernate.XHibernate.setCmt(false);
			}
		} 
	} 
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DeliveryTypeKey ejbCreate(org.openxava.test.model.DeliveryTypeData data) 
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
	public void ejbPostCreate(org.openxava.test.model.DeliveryTypeData data) 
		throws
			CreateException,
			ValidationException { 
		boolean cmtActivated = false;
		if (!org.openxava.hibernate.XHibernate.isCmt()) {
			org.openxava.hibernate.XHibernate.setCmt(true);
			cmtActivated = true;
		}
		try { 		
			org.openxava.test.calculators.DeliveryTypePostcreateCalculator calculator0= (org.openxava.test.calculators.DeliveryTypePostcreateCalculator)
				getMetaModel().getMetaCalculatorPostCreate(0).createCalculator(); 
			calculator0.setNumber(getNumber()); 
			calculator0.setModel(this); 
			calculator0.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryType", ex.getLocalizedMessage()));
		}
		finally {
			if (cmtActivated) {
				org.openxava.hibernate.XHibernate.setCmt(false);
			}
		} 			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.model.DeliveryTypeKey ejbCreate(org.openxava.test.model.DeliveryTypeValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setDeliveryTypeValue(value); 
		setNumber(value.getNumber()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.model.DeliveryTypeValue value) 
		throws
			CreateException,
			ValidationException { 
		boolean cmtActivated = false;
		if (!org.openxava.hibernate.XHibernate.isCmt()) {
			org.openxava.hibernate.XHibernate.setCmt(true);
			cmtActivated = true;
		}
		try { 		
			org.openxava.test.calculators.DeliveryTypePostcreateCalculator calculator0= (org.openxava.test.calculators.DeliveryTypePostcreateCalculator)
				getMetaModel().getMetaCalculatorPostCreate(0).createCalculator(); 
			calculator0.setNumber(getNumber()); 
			calculator0.setModel(this); 
			calculator0.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_create_error", "DeliveryType", ex.getLocalizedMessage()));
		}
		finally {
			if (cmtActivated) {
				org.openxava.hibernate.XHibernate.setCmt(false);
			}
		} 			
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
		boolean cmtActivated = false;
		if (!org.openxava.hibernate.XHibernate.isCmt()) {
			org.openxava.hibernate.XHibernate.setCmt(true);
			cmtActivated = true;
		}
		try { 		
			org.openxava.test.calculators.DeliveryTypePostmodifyCalculator calculator0= (org.openxava.test.calculators.DeliveryTypePostmodifyCalculator)
				getMetaModel().getMetaCalculatorPostModify(0).createCalculator(); 
			calculator0.setModel(this); 
			calculator0.calculate(); 
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("entity_modify_error", "DeliveryType", ex.getLocalizedMessage()));
		}
		finally {
			if (cmtActivated) {
				org.openxava.hibernate.XHibernate.setCmt(false);
			}
		} 
		
		modified = false;
	} 	
	

	public void ejbRemove() throws RemoveException { 						
	} 	
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter descriptionConverter;
	private org.openxava.converters.IConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("description");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "description"));
			}
			
		}	
		return descriptionConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DESCRIPTION"
	 */
	public abstract java.lang.String get_Description();
	public abstract void set_Description(java.lang.String newDescription); 	
	
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "DeliveryType", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDescription(String newDescription) {
		try { 
			this.modified = true; 
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "DeliveryType", "String"));
		}		
	} 
	/**
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 *
	 * @jboss:column-name "number"
	 */
	public abstract int getNumber();
	/**
	  * 
	  */
	public abstract void setNumber(int newNumber); 

	// Colecciones/Collections	

	private org.openxava.test.model.DeliveryHome deliveriesHome; 
	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getDeliveries() {		
		try {
			return getDeliveriesHome().findByType(getNumber());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "Deliveries", "DeliveryType"));
		}
	}
		
	private org.openxava.test.model.DeliveryHome getDeliveriesHome() throws Exception{
		if (deliveriesHome == null) {
			deliveriesHome = (org.openxava.test.model.DeliveryHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.model/Delivery"),
			 		org.openxava.test.model.DeliveryHome.class);			 		
		}
		return deliveriesHome;
	}		

	// References/Referencias 

	// Methods/Metodos 

	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("DeliveryType").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DeliveryTypeData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.model.DeliveryTypeData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.model.DeliveryTypeValue getDeliveryTypeValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setDeliveryTypeValue(org.openxava.test.model.DeliveryTypeValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	} 

	private void initMembers() { 
		setNumber(0); 
		setDescription(null); 	
	} 		
}