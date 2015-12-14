
// File generated by OpenXava: Fri Dec 11 13:00:37 CET 2015
// Archivo generado por OpenXava: Fri Dec 11 13:00:37 CET 2015

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Customer		Aggregate/Agregado: CustomerState

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
public class CustomerState implements java.io.Serializable, org.openxava.test.model.ICustomerState {	

	// Constructor
	public CustomerState() {
		initMembers();
	} 

	private void initMembers() { 	
	} 
	
	// Properties/Propiedades 

	// References/Referencias 

	private org.openxava.test.model.IState state; 	
	public org.openxava.test.model.IState getState() {
		if (state != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				state.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return state;
	}
	public void setState(org.openxava.test.model.IState newState) {
		if (newState != null && !(newState instanceof org.openxava.test.model.State)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.state = newState; 
	} 

	private org.openxava.test.model.ICustomer customer; 	
	public org.openxava.test.model.ICustomer getCustomer() {
		if (customer != null) {
			// Because not-found='ignore' annul lazy initialization, we simulate it
			try {
				customer.toString();
			}
			catch (Exception ex) {
				return null;
			}
		}	
		return customer;
	}
	public void setCustomer(org.openxava.test.model.ICustomer newCustomer) {
		if (newCustomer != null && !(newCustomer instanceof org.openxava.test.model.Customer)) {
			throw new IllegalArgumentException(XavaResources.getString("ejb_to_pojo_illegal")); 
		}
		this.customer = newCustomer; 
	} 

	// Colecciones/Collections 

	// Methods/Metodos 	

	// User defined finders/Buscadores definidos por el usuario 


	private static MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) { 
			metaModel = MetaComponent.get("Customer").getMetaAggregate("CustomerState"); 	
		}
		return metaModel;
	}
	
	public String toString() {		
		try {
			return getMetaModel().toString(this);
		}
		catch (XavaException ex) {
			System.err.println(XavaResources.getString("toString_warning", "CustomerState"));
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