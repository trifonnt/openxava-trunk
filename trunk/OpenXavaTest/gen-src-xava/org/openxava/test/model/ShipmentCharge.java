
// File generated by OpenXava: Tue Sep 12 10:33:03 CEST 2006
// Archivo generado por OpenXava: Tue Sep 12 10:33:03 CEST 2006

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: ShipmentCharge		Entity/Entidad

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
public class ShipmentCharge implements java.io.Serializable, org.openxava.test.model.IShipmentCharge {	

	// Constructor
	public ShipmentCharge() {
		initMembers();
	} 

	private void initMembers() { 
		setOid(null); 
		setMode(0); 
		setAmount(null); 	
	} 
	
	// Properties/Propiedades 
	private static org.openxava.converters.IConverter amountConverter;
	private org.openxava.converters.IConverter getAmountConverter() {
		if (amountConverter == null) {
			try {
				amountConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("amount");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "amount"));
			}
			
		}	
		return amountConverter;
	} 
	private java.math.BigDecimal amount;
	private java.math.BigDecimal get_Amount() {
		return amount;
	}
	private void set_Amount(java.math.BigDecimal newAmount) {
		this.amount = newAmount;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.math.BigDecimal getAmount() {
		try {
			return (java.math.BigDecimal) getAmountConverter().toJava(get_Amount());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Amount", "ShipmentCharge", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * 
	 */
	public void setAmount(java.math.BigDecimal newAmount) {
		try { 
			set_Amount((java.math.BigDecimal) getAmountConverter().toDB(newAmount));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Amount", "ShipmentCharge", "java.math.BigDecimal"));
		}		
	} 
	private String oid;
	public String getOid() {
		return oid;
	}
	public void setOid(String newOid) {
		this.oid = newOid;
	} 
	private static org.openxava.converters.IConverter modeConverter;
	private org.openxava.converters.IConverter getModeConverter() {
		if (modeConverter == null) {
			try {
				modeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("mode");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "mode"));
			}
			
		}	
		return modeConverter;
	} 
	private java.lang.Integer mode;
	private java.lang.Integer get_Mode() {
		return mode;
	}
	private void set_Mode(java.lang.Integer newMode) {
		this.mode = newMode;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getMode() {
		try {
			return ((Integer) getModeConverter().toJava(get_Mode())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Mode", "ShipmentCharge", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setMode(int newMode) {
		try { 
			set_Mode((java.lang.Integer) getModeConverter().toDB(new Integer(newMode)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Mode", "ShipmentCharge", "int"));
		}		
	} 

	// References/Referencias 

	private org.openxava.test.model.IShipment shipment; 
	private java.lang.String shipment_type; 
	private static org.openxava.converters.IConverter shipment_typeConverter;
	private org.openxava.converters.IConverter getShipment_typeConverter() {
		if (shipment_typeConverter == null) {
			try {
				shipment_typeConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getReferenceMapping("shipment").getConverterForReferencedModelProperty("type");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "shipment.type"));
			}
			
		}	
		return shipment_typeConverter;
	} 
	private java.lang.Integer shipment_number; 	
	public org.openxava.test.model.IShipment getShipment() {
		if (shipment != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				shipment.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return shipment;
	}
	public void setShipment(org.openxava.test.model.IShipment newShipment) throws RemoteException{
		if (newShipment != null && !(newShipment instanceof org.openxava.test.model.Shipment)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.shipment = newShipment; 
		try {
			shipment_type = (java.lang.String) getShipment_typeConverter().toDB(newShipment==null?null:new Integer(newShipment.getType()));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "shipment.type", "ShipmentCharge", "int"));
		} 
		this.shipment_number = newShipment == null?null:new Integer(newShipment.getNumber()); 
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 	
 	public static ShipmentCharge findByOid(java.lang.String oid) throws javax.ejb.ObjectNotFoundException {
 		if (XavaPreferences.getInstance().isJPAPersistence()) { 			
 			javax.persistence.Query query = org.openxava.jpa.XPersistence.getManager().createQuery("from ShipmentCharge as o where o.oid = :arg0"); 
			query.setParameter("arg0", oid); 
 			try {
				return (ShipmentCharge) query.getSingleResult();
			}
			catch (Exception ex) {
				// In this way in order to work with Java pre 5 
				if (ex.getClass().getName().equals("javax.persistence.NoResultException")) {
					throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "ShipmentCharge"));
				}
				else {
					ex.printStackTrace();
					throw new RuntimeException(ex.getMessage());
				}
			}  		
 		}
 		else {
 			org.hibernate.Query query = org.openxava.hibernate.XHibernate.getSession().createQuery("from ShipmentCharge as o where o.oid = :arg0"); 
			query.setParameter("arg0", oid); 
			ShipmentCharge r = (ShipmentCharge) query.uniqueResult();
			if (r == null) {
				throw new javax.ejb.ObjectNotFoundException(XavaResources.getString("object_not_found", "ShipmentCharge"));
			}
			return r; 
 		}
 	} 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("ShipmentCharge").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "ShipmentCharge"));
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