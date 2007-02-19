
// File generated by OpenXava: Thu Feb 15 13:07:03 CET 2007
// Archivo generado por OpenXava: Thu Feb 15 13:07:03 CET 2007

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Invoice2		Aggregate/Agregado: InvoiceDetail2

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
public class InvoiceDetail2 implements java.io.Serializable, org.openxava.test.model.IInvoiceDetail2 {	

	// Constructor
	public InvoiceDetail2() {
		initMembers();
	} 

	private void initMembers() { 
		setOid(null); 
		setQuantity(0); 
		setUnitPrice(null); 	
	} 
	
	// Properties/Propiedades 	
	/**
	 * 
	 * 
	 */
	public java.math.BigDecimal getAmount() { 		
		try {			
			org.openxava.test.calculators.DetailAmountCalculator amountCalculator= (org.openxava.test.calculators.DetailAmountCalculator)
				getMetaModel().getMetaProperty("amount").getMetaCalculator().createCalculator();  	
			
			amountCalculator.setUnitPrice(getUnitPrice());  	
			
			amountCalculator.setQuantity(getQuantity()); 
			return (java.math.BigDecimal) amountCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "Amount", "InvoiceDetail2", ex.getLocalizedMessage()));
		} 		
	}
	public void setAmount(java.math.BigDecimal newAmount) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private static org.openxava.converters.IConverter unitPriceConverter;
	private org.openxava.converters.IConverter getUnitPriceConverter() {
		if (unitPriceConverter == null) {
			try {
				unitPriceConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("unitPrice");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "unitPrice"));
			}
			
		}	
		return unitPriceConverter;
	} 
	private java.math.BigDecimal unitPrice;
	private java.math.BigDecimal get_UnitPrice() {
		return unitPrice;
	}
	private void set_UnitPrice(java.math.BigDecimal newUnitPrice) {
		this.unitPrice = newUnitPrice;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.math.BigDecimal getUnitPrice() {
		try {
			return (java.math.BigDecimal) getUnitPriceConverter().toJava(get_UnitPrice());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "UnitPrice", "InvoiceDetail2", "java.math.BigDecimal"));
		}
	}
	
	/**
	 * 
	 */
	public void setUnitPrice(java.math.BigDecimal newUnitPrice) {
		try { 
			set_UnitPrice((java.math.BigDecimal) getUnitPriceConverter().toDB(newUnitPrice));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "UnitPrice", "InvoiceDetail2", "java.math.BigDecimal"));
		}		
	} 
	private String oid;
	public String getOid() {
		return oid;
	}
	public void setOid(String newOid) {
		this.oid = newOid;
	} 
	private static org.openxava.converters.IConverter quantityConverter;
	private org.openxava.converters.IConverter getQuantityConverter() {
		if (quantityConverter == null) {
			try {
				quantityConverter = (org.openxava.converters.IConverter) 
					getMetaModel().getMapping().getConverter("quantity");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "quantity"));
			}
			
		}	
		return quantityConverter;
	} 
	private java.lang.Integer quantity;
	private java.lang.Integer get_Quantity() {
		return quantity;
	}
	private void set_Quantity(java.lang.Integer newQuantity) {
		this.quantity = newQuantity;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getQuantity() {
		try {
			return ((Integer) getQuantityConverter().toJava(get_Quantity())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Quantity", "InvoiceDetail2", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setQuantity(int newQuantity) {
		try { 
			set_Quantity((java.lang.Integer) getQuantityConverter().toDB(new Integer(newQuantity)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Quantity", "InvoiceDetail2", "int"));
		}		
	} 

	// References/Referencias 

	private org.openxava.test.model.IProduct product; 	
	public org.openxava.test.model.IProduct getProduct() {
		if (product != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				product.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return product;
	}
	public void setProduct(org.openxava.test.model.IProduct newProduct) {
		if (newProduct != null && !(newProduct instanceof org.openxava.test.model.Product)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.product = newProduct; 
	} 

	private org.openxava.test.model.IInvoice2 invoice2; 	
	public org.openxava.test.model.IInvoice2 getInvoice2() {
		if (invoice2 != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				invoice2.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return invoice2;
	}
	public void setInvoice2(org.openxava.test.model.IInvoice2 newInvoice2) {
		if (newInvoice2 != null && !(newInvoice2 instanceof org.openxava.test.model.Invoice2)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.invoice2 = newInvoice2; 
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Invoice2").getMetaAggregate("InvoiceDetail2"); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "InvoiceDetail2"));
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