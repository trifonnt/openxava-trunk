

// File generated by OpenXava: Mon Jun 20 11:03:30 CEST 2016
// Archivo generado por OpenXava: Mon Jun 20 11:03:30 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR

package org.openxava.test.model;

import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.XavaException;

public class Detail implements java.io.Serializable, org.openxava.model.IModel {

	// Attributes/Atributos 
	private boolean free; 
	private int subfamily; 
	private int type; 
	private org.openxava.test.model.IServiceType typeRef;



	// Properties/Propiedades 
	public boolean getFree() {
		return free;
	}
	public void setFree(boolean newFree) {
		this.free = newFree;
	} 
	public int getSubfamily() {
		return subfamily;
	}
	public void setSubfamily(int newSubfamily) {
		this.subfamily = newSubfamily;
	} 
	public int getType() {
		return type;
	}
	public void setType(int newType) {
		this.type = newType;
	}

	// References 
	public org.openxava.test.model.IServiceType getTypeRef() {
		return typeRef;
	}
	public void setTypeRef(org.openxava.test.model.IServiceType newTypeRef) {
		this.typeRef = newTypeRef;
	}
	
	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Service").getMetaAggregate("Detail");
		}
		return metaModel;
	}
	
}