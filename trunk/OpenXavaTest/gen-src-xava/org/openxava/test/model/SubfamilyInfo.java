

// File generated by OpenXava: Wed Feb 22 16:39:39 CET 2006
// Archivo generado por OpenXava: Wed Feb 22 16:39:39 CET 2006

// WARNING: NO EDIT
// OJO: NO EDITAR

package org.openxava.test.model;

import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.XavaException;

public class SubfamilyInfo implements java.io.Serializable, org.openxava.model.IModel {

	// Attributes/Atributos 
	private org.openxava.test.model.IFamily2 family; 
	private org.openxava.test.model.ISubfamily2 subfamily;



	// Properties/Propiedades

	// References 
	public org.openxava.test.model.IFamily2 getFamily() {
		return family;
	}
	public void setFamily(org.openxava.test.model.IFamily2 newFamily) {
		this.family = newFamily;
	} 
	public org.openxava.test.model.ISubfamily2 getSubfamily() {
		return subfamily;
	}
	public void setSubfamily(org.openxava.test.model.ISubfamily2 newSubfamily) {
		this.subfamily = newSubfamily;
	}
	
	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Product3").getMetaAggregate("SubfamilyInfo");
		}
		return metaModel;
	}
	
}