
// File generated by OpenXava: Wed Oct 05 17:17:02 CEST 2005
// Archivo generado por OpenXava: Wed Oct 05 17:17:02 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: TransportCharge		Entity/Entidad

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
public class TransportCharge implements java.io.Serializable, org.openxava.test.model.ITransportCharge {	
	
	// Properties/Propiedades 
	private org.openxava.converters.BigDecimalNumberConverter amountConverter;
	private org.openxava.converters.BigDecimalNumberConverter getAmountConverter() {
		if (amountConverter == null) {
			try {
				amountConverter = (org.openxava.converters.BigDecimalNumberConverter) 
					getMetaModel().getMapping().getConverter("amount");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "amount"));
			}
			
		}	
		return amountConverter;
	} 
	private java.math.BigDecimal _amount;
	private java.math.BigDecimal get_Amount() {
		return _amount;
	}
	private void set_Amount(java.math.BigDecimal newAmount) {
		this._amount = newAmount;
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Amount", "TransportCharge", "java.math.BigDecimal"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Amount", "TransportCharge", "java.math.BigDecimal"));
		}		
	} 

	// References/Referencias 
	private org.openxava.test.model.IDelivery delivery;
	public org.openxava.test.model.IDelivery getDelivery() {
		return delivery;
	}
	public void setDelivery(org.openxava.test.model.IDelivery newDelivery) {
		this.delivery = newDelivery;
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("TransportCharge").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "TransportCharge::" + delivery;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}