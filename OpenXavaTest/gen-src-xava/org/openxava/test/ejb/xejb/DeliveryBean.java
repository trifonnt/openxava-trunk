
// File generated by OpenXava: Tue Apr 26 19:08:01 CEST 2005
// Archivo generado por OpenXava: Tue Apr 26 19:08:01 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Delivery		Entity/Entidad

package org.openxava.test.ejb.xejb;

import java.util.*;
import java.math.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

import org.openxava.ejbx.*;
import org.openxava.util.*;
import org.openxava.component.*;
import org.openxava.model.meta.*;
import org.openxava.validators.ValidationException;

import org.openxava.test.ejb.*;


/**
 * @ejb:bean name="Delivery" type="CMP" jndi-name="@subcontext@/ejb/org.openxava.test.ejb/Delivery" reentrant="false" view-type="remote"
 * @ejb:interface extends="org.openxava.ejbx.EJBReplicable, org.openxava.test.ejb.IDelivery"
 * @ejb:data-object extends="java.lang.Object"
 * @ejb:home extends="javax.ejb.EJBHome"
 * @ejb:pk extends="java.lang.Object"
 *
 * @ejb.value-object name="Delivery" match="persistentCalculatedAndAggregate"
 *   
 * @ejb:env-entry name="DATA_SOURCE" type="java.lang.String" value="jdbc/DataSource"
 * @ejb:resource-ref  res-name="jdbc/DataSource" res-type="javax.sql.DataSource"  res-auth="Container" jndi-name="jdbc/@datasource@"
 * @jboss:resource-ref  res-ref-name="jdbc/DataSource" resource-name="jdbc/DataSource"
 * 	
 * @ejb:finder signature="Collection findByType(int number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.type_number = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByType(int number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.type_number = ?1 " 	
 * @ejb:finder signature="Collection findByShipment(java.lang.String type, int mode, int number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.shipment_type = ?1 AND o.shipment_mode = ?2 AND o.shipment_number = ?3" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByShipment(java.lang.String type, int mode, int number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.shipment_type = ?1 AND o.shipment_mode = ?2 AND o.shipment_number = ?3 " 	
 * @ejb:finder signature="Collection findByCarrier(java.lang.Integer number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.carrier_number = ?1" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByCarrier(java.lang.Integer number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.carrier_number = ?1 " 	
 * @ejb:finder signature="Collection findByInvoice(int year, int number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.invoice_year = ?1 AND o.invoice_number = ?2" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findByInvoice(int year, int number)" query="SELECT OBJECT(o) FROM Delivery o WHERE o.invoice_year = ?1 AND o.invoice_number = ?2 " 	
 * @ejb:finder signature="Collection findAll()" query="SELECT OBJECT(o) FROM Delivery o" view-type="remote" result-type-mapping="Remote"
 * @jboss:query signature="Collection findAll()" query="SELECT OBJECT(o) FROM Delivery o" 
 * 
 * @jboss:table-name "XAVATEST_DELIVERY"
 *
 * @author Javier Paniza
 */
abstract public class DeliveryBean extends EJBReplicableBase 
			implements org.openxava.test.ejb.IDelivery, EntityBean {	
			
	private boolean creating = false;		
	private boolean modified = false;

	// Create 

	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.DeliveryKey ejbCreate(Map values) 
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
	public org.openxava.test.ejb.DeliveryKey ejbCreate(org.openxava.test.ejb.DeliveryData data) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setData(data); 
		setNumber(data.getNumber()); 
		setType_number(data.getType_number()); 
		setInvoice_year(data.getInvoice_year()); 
		setInvoice_number(data.getInvoice_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.DeliveryData data) 
		throws
			CreateException,
			ValidationException {			
	}
	
	
	/**
	 * @ejb:create-method
	 */	 
	public org.openxava.test.ejb.DeliveryKey ejbCreate(org.openxava.test.ejb.DeliveryValue value) 
		throws
			CreateException,
			ValidationException {
		initMembers();	
		creating = true;	
		modified = false;
		setDeliveryValue(value); 
		setNumber(value.getNumber()); 
		setType_number(value.getType_number()); 
		setInvoice_year(value.getInvoice_year()); 
		setInvoice_number(value.getInvoice_number()); 
			
		return null;
	} 
	public void ejbPostCreate(org.openxava.test.ejb.DeliveryValue value) 
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
	
	// Properties/Propiedades 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.util.Date getDateAsLabel() {
		try { 		
			org.openxava.calculators.ByPassCalculator dateAsLabelCalculator= (org.openxava.calculators.ByPassCalculator)
				getMetaModel().getMetaProperty("dateAsLabel").getMetaCalculator().getCalculator();  	
			dateAsLabelCalculator.setSource(getDate()); 
			return (java.util.Date) dateAsLabelCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.calculate_value_error", "DateAsLabel", "Delivery", ex.getLocalizedMessage()));
		}
	}
	public void setDateAsLabel(java.util.Date newDateAsLabel) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private org.openxava.converters.ValidValuesLetterConverter distanceConverter;
	private org.openxava.converters.ValidValuesLetterConverter getDistanceConverter() {
		if (distanceConverter == null) {
			try {
				distanceConverter = (org.openxava.converters.ValidValuesLetterConverter) 
					getMetaModel().getMapping().getConverter("distance");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "distance"));
			}
			
		}	
		return distanceConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DISTANCE"
	 */
	public abstract java.lang.String get_Distance();
	public abstract void set_Distance(java.lang.String newDistance); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public int getDistance() {
		try {
			return ((Integer) getDistanceConverter().toJava(get_Distance())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Distance", "Delivery", "int"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDistance(int newDistance) {
		try { 
			this.modified = true; 
			set_Distance((java.lang.String) getDistanceConverter().toDB(new Integer(newDistance)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Distance", "Delivery", "int"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter incidentsConverter;
	private org.openxava.converters.TrimStringConverter getIncidentsConverter() {
		if (incidentsConverter == null) {
			try {
				incidentsConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("incidents");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "incidents"));
			}
			
		}	
		return incidentsConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "INCIDENTS"
	 */
	public abstract java.lang.String get_Incidents();
	public abstract void set_Incidents(java.lang.String newIncidents); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.lang.String getIncidents() {
		try {
			return (java.lang.String) getIncidentsConverter().toJava(get_Incidents());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Incidents", "Delivery", "java.lang.String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setIncidents(java.lang.String newIncidents) {
		try { 
			this.modified = true; 
			set_Incidents((java.lang.String) getIncidentsConverter().toDB(newIncidents));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Incidents", "Delivery", "java.lang.String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter driverTypeConverter;
	private org.openxava.converters.TrimStringConverter getDriverTypeConverter() {
		if (driverTypeConverter == null) {
			try {
				driverTypeConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("driverType");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "driverType"));
			}
			
		}	
		return driverTypeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "DRIVERTYPE"
	 */
	public abstract java.lang.String get_DriverType();
	public abstract void set_DriverType(java.lang.String newDriverType); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getDriverType() {
		try {
			return (String) getDriverTypeConverter().toJava(get_DriverType());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "DriverType", "Delivery", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setDriverType(String newDriverType) {
		try { 
			this.modified = true; 
			set_DriverType((java.lang.String) getDriverTypeConverter().toDB(newDriverType));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "DriverType", "Delivery", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter remarksConverter;
	private org.openxava.converters.TrimStringConverter getRemarksConverter() {
		if (remarksConverter == null) {
			try {
				remarksConverter = (org.openxava.converters.TrimStringConverter) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "Delivery", "java.lang.String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Remarks", "Delivery", "java.lang.String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter employeeConverter;
	private org.openxava.converters.TrimStringConverter getEmployeeConverter() {
		if (employeeConverter == null) {
			try {
				employeeConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("employee");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "employee"));
			}
			
		}	
		return employeeConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "EMPLOYEE"
	 */
	public abstract java.lang.String get_Employee();
	public abstract void set_Employee(java.lang.String newEmployee); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getEmployee() {
		try {
			return (String) getEmployeeConverter().toJava(get_Employee());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Employee", "Delivery", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setEmployee(String newEmployee) {
		try { 
			this.modified = true; 
			set_Employee((java.lang.String) getEmployeeConverter().toDB(newEmployee));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Employee", "Delivery", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter descriptionConverter;
	private org.openxava.converters.TrimStringConverter getDescriptionConverter() {
		if (descriptionConverter == null) {
			try {
				descriptionConverter = (org.openxava.converters.TrimStringConverter) 
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Delivery", "String"));
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
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Description", "Delivery", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter vehicleConverter;
	private org.openxava.converters.TrimStringConverter getVehicleConverter() {
		if (vehicleConverter == null) {
			try {
				vehicleConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("vehicle");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "vehicle"));
			}
			
		}	
		return vehicleConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * 
	 * @jboss:column-name "VEHICLE"
	 */
	public abstract java.lang.String get_Vehicle();
	public abstract void set_Vehicle(java.lang.String newVehicle); 	
	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getVehicle() {
		try {
			return (String) getVehicleConverter().toJava(get_Vehicle());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Vehicle", "Delivery", "String"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public void setVehicle(String newVehicle) {
		try { 
			this.modified = true; 
			set_Vehicle((java.lang.String) getVehicleConverter().toDB(newVehicle));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Vehicle", "Delivery", "String"));
		}		
	} 	
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public String getTransportMode() {
		try { 		
			org.openxava.test.calculators.DeliveryTransportModeCalculator transportModeCalculator= (org.openxava.test.calculators.DeliveryTransportModeCalculator)
				getMetaModel().getMetaProperty("transportMode").getMetaCalculator().getCalculator();  	
			transportModeCalculator.setVehicle(getVehicle()); 
			return (String) transportModeCalculator.calculate();
		}
		catch (NullPointerException ex) {
			// Usually for multilevel property access with null references 
			return null; 			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.calculate_value_error", "TransportMode", "Delivery", ex.getLocalizedMessage()));
		}
	}
	public void setTransportMode(String newTransportMode) {
		// for it is in value object
		// para que aparezca en los value objects
	} 
	private org.openxava.converters.Date3Converter dateConverter;
	private org.openxava.converters.Date3Converter getDateConverter() {
		if (dateConverter == null) {
			try {
				dateConverter = (org.openxava.converters.Date3Converter) 
					getMetaModel().getMapping().getMultipleConverter("date");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new EJBException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	/**	 
	 * @ejb:persistent-field
	 * @jboss:column-name "DAY"
	 */		
	public abstract int getDate_day();
	public abstract void setDate_day(int newValue); 
	/**	 
	 * @ejb:persistent-field
	 * @jboss:column-name "MONTH"
	 */		
	public abstract int getDate_month();
	public abstract void setDate_month(int newValue); 
	/**	 
	 * @ejb:persistent-field
	 * @jboss:column-name "YEAR"
	 */		
	public abstract int getDate_year();
	public abstract void setDate_year(int newValue); 
	/**
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @ejb:interface-method
	 */
	public java.util.Date getDate() {
		try { 
			getDateConverter().setDay(getDate_day()); 
			getDateConverter().setMonth(getDate_month()); 
			getDateConverter().setYear(getDate_year()); 
			return (java.util.Date) getDateConverter().toJava();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_error", "Date", "Delivery", "java.util.Date"));
		}
	}

	/**
	 * @ejb:interface-method
	 */
	public void setDate(java.util.Date newDate) {
		try {
			this.modified = true; 
			getDateConverter().toDB(newDate); 
			setDate_day(getDateConverter().getDay()); 
			setDate_month(getDateConverter().getMonth()); 
			setDate_year(getDateConverter().getYear()); 			
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("generator.conversion_db_error", "Date", "Delivery"));
		}		
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

	private org.openxava.test.ejb.DeliveryDetailHome detailsHome; 

	/**
	 * @ejb:interface-method
	 */
	public java.util.Collection getDetails() {		
		try {
			return getDetailsHome().findByDelivery(getNumber(), getType_number(), getInvoice_year(), getInvoice_number());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_collection_elements_error", "Details", "Delivery"));
		}
	}
		
	private org.openxava.test.ejb.DeliveryDetailHome getDetailsHome() throws Exception{
		if (detailsHome == null) {
			detailsHome = (org.openxava.test.ejb.DeliveryDetailHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/DeliveryDetail"),
			 		org.openxava.test.ejb.DeliveryDetailHome.class);			 		
		}
		return detailsHome;
	}		

	// References/Referencias 

	// Type : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.DeliveryType getType() {
		try {		
			return getTypeHome().findByPrimaryKey(getTypeKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Type", "Delivery"));
		}		
	}	
	/**
	 * 
	 */
	public void setType(org.openxava.test.ejb.DeliveryType newType) { 
		this.modified = true; 
		try {	
			if (newType == null) setTypeKey(null);
			else setTypeKey((org.openxava.test.ejb.DeliveryTypeKey) newType.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Type", "Delivery"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.DeliveryTypeKey getTypeKey() {				
		org.openxava.test.ejb.DeliveryTypeKey key = new org.openxava.test.ejb.DeliveryTypeKey(); 
		key.number = getType_number();		
		return key;
	}	
	
	/**
	 * 
	 */
	public void setTypeKey(org.openxava.test.ejb.DeliveryTypeKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.DeliveryTypeKey();
		} 
		setType_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "TYPE"
	 */
	public abstract int getType_number();
	public abstract void setType_number(int newType_number); 

	private org.openxava.test.ejb.DeliveryTypeHome typeHome;	
	private org.openxava.test.ejb.DeliveryTypeHome getTypeHome() throws Exception{
		if (typeHome == null) {
			typeHome = (org.openxava.test.ejb.DeliveryTypeHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/DeliveryType"),
			 		org.openxava.test.ejb.DeliveryTypeHome.class);			 		
		}
		return typeHome;
	} 

	// Shipment : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Shipment getShipment() {
		try {		
			return getShipmentHome().findByPrimaryKey(getShipmentKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Shipment", "Delivery"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setShipment(org.openxava.test.ejb.Shipment newShipment) { 
		this.modified = true; 
		try {	
			if (newShipment == null) setShipmentKey(null);
			else setShipmentKey((org.openxava.test.ejb.ShipmentKey) newShipment.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Shipment", "Delivery"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.ShipmentKey getShipmentKey() {				
		org.openxava.test.ejb.ShipmentKey key = new org.openxava.test.ejb.ShipmentKey(); 
		key._Type = getShipment_type(); 
		key.mode = getShipment_mode(); 
		key.number = getShipment_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setShipmentKey(org.openxava.test.ejb.ShipmentKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.ShipmentKey();
		} 
		setShipment_type(key._Type); 
		setShipment_mode(key.mode); 
		setShipment_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "SHIPMENT_TYPE"
	 */
	public abstract java.lang.String getShipment_type();
	public abstract void setShipment_type(java.lang.String newShipment_type);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "SHIPMENT_MODE"
	 */
	public abstract int getShipment_mode();
	public abstract void setShipment_mode(int newShipment_mode);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "SHIPMENT_NUMBER"
	 */
	public abstract int getShipment_number();
	public abstract void setShipment_number(int newShipment_number); 

	private org.openxava.test.ejb.ShipmentHome shipmentHome;	
	private org.openxava.test.ejb.ShipmentHome getShipmentHome() throws Exception{
		if (shipmentHome == null) {
			shipmentHome = (org.openxava.test.ejb.ShipmentHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Shipment"),
			 		org.openxava.test.ejb.ShipmentHome.class);			 		
		}
		return shipmentHome;
	} 

	// Carrier : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Carrier getCarrier() {
		try {		
			return getCarrierHome().findByPrimaryKey(getCarrierKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Carrier", "Delivery"));
		}		
	}	
	/**
	 * @ejb:interface-method
	 */
	public void setCarrier(org.openxava.test.ejb.Carrier newCarrier) { 
		this.modified = true; 
		try {	
			if (newCarrier == null) setCarrierKey(null);
			else setCarrierKey((org.openxava.test.ejb.CarrierKey) newCarrier.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Carrier", "Delivery"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.CarrierKey getCarrierKey() {				
		org.openxava.test.ejb.CarrierKey key = new org.openxava.test.ejb.CarrierKey(); 
		key._Number = getCarrier_number();		
		return key;
	}	
	
	/**
	 * @ejb:interface-method
	 */
	public void setCarrierKey(org.openxava.test.ejb.CarrierKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.CarrierKey();
		} 
		setCarrier_number(key._Number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * 
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "CARRIER"
	 */
	public abstract java.lang.Integer getCarrier_number();
	public abstract void setCarrier_number(java.lang.Integer newCarrier_number); 

	private org.openxava.test.ejb.CarrierHome carrierHome;	
	private org.openxava.test.ejb.CarrierHome getCarrierHome() throws Exception{
		if (carrierHome == null) {
			carrierHome = (org.openxava.test.ejb.CarrierHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Carrier"),
			 		org.openxava.test.ejb.CarrierHome.class);			 		
		}
		return carrierHome;
	} 

	// Invoice : Entity reference/Referencia a entidad
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.Invoice getInvoice() {
		try {		
			return getInvoiceHome().findByPrimaryKey(getInvoiceKey());
		}
		catch (ObjectNotFoundException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("get_reference_error", "Invoice", "Delivery"));
		}		
	}	
	/**
	 * 
	 */
	public void setInvoice(org.openxava.test.ejb.Invoice newInvoice) { 
		this.modified = true; 
		try {	
			if (newInvoice == null) setInvoiceKey(null);
			else setInvoiceKey((org.openxava.test.ejb.InvoiceKey) newInvoice.getPrimaryKey());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException(XavaResources.getString("set_reference_error", "Invoice", "Delivery"));
		}
	}
	
	/**
	 * @ejb:interface-method
	 */
	public org.openxava.test.ejb.InvoiceKey getInvoiceKey() {				
		org.openxava.test.ejb.InvoiceKey key = new org.openxava.test.ejb.InvoiceKey(); 
		key.year = getInvoice_year(); 
		key.number = getInvoice_number();		
		return key;
	}	
	
	/**
	 * 
	 */
	public void setInvoiceKey(org.openxava.test.ejb.InvoiceKey key) { 
		this.modified = true; 		
		if (key == null) {
			key = new org.openxava.test.ejb.InvoiceKey();
		} 
		setInvoice_year(key.year); 
		setInvoice_number(key.number);		
		
	}
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "INVOICE_YEAR"
	 */
	public abstract int getInvoice_year();
	public abstract void setInvoice_year(int newInvoice_year);
	/**		
	 * @ejb:interface-method
	 * @ejb:persistent-field
	 * @ejb:pk-field
	 * @ejb.value-object match="persistentCalculatedAndAggregate"
	 * @jboss:column-name "INVOICE_NUMBER"
	 */
	public abstract int getInvoice_number();
	public abstract void setInvoice_number(int newInvoice_number); 

	private org.openxava.test.ejb.InvoiceHome invoiceHome;	
	private org.openxava.test.ejb.InvoiceHome getInvoiceHome() throws Exception{
		if (invoiceHome == null) {
			invoiceHome = (org.openxava.test.ejb.InvoiceHome) PortableRemoteObject.narrow(
			 		BeansContext.get().lookup("ejb/org.openxava.test.ejb/Invoice"),
			 		org.openxava.test.ejb.InvoiceHome.class);			 		
		}
		return invoiceHome;
	} 
	// Methods/Metodos 

	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Delivery").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.DeliveryData getData();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setData(org.openxava.test.ejb.DeliveryData data);
	
	/**
	 * @ejb:interface-method
	 */	
	public abstract org.openxava.test.ejb.DeliveryValue getDeliveryValue();		
	
	/**
	 * @ejb:interface-method
	 */		
	public abstract void setDeliveryValue(org.openxava.test.ejb.DeliveryValue value);
	
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
	}
	public void unsetEntityContext() {
		super.unsetEntityContext();
	}
	
	private void initMembers() { 
		setNumber(0); 
		setDate(null); 
		setDescription(null); 
		setDistance(0); 
		setVehicle(null); 
		setDriverType(null); 
		setEmployee(null); 
		setRemarks(null); 
		setIncidents(null); 
	}
		
}