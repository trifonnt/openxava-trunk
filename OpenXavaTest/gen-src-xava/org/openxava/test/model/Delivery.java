
// File generated by OpenXava: Tue May 31 11:52:32 CEST 2005
// Archivo generado por OpenXava: Tue May 31 11:52:32 CEST 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Delivery		Entity/Entidad

package org.openxava.test.model;

import java.util.*;
import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.*;

/**
 * 
 * @author MCarmen Gimeno
 */
public class Delivery implements java.io.Serializable {	
	
	// Properties/Propiedades 	
	/**
	 * 
	 * 
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
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "DateAsLabel", "Delivery", ex.getLocalizedMessage()));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "distance"));
			}
			
		}	
		return distanceConverter;
	} 
	private java.lang.String _distance;
	private java.lang.String get_Distance() {
		return _distance;
	}
	private void set_Distance(java.lang.String newDistance) {
		this._distance = newDistance;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getDistance() {
		try {
			return ((Integer) getDistanceConverter().toJava(get_Distance())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Distance", "Delivery", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setDistance(int newDistance) {
		try { 
			set_Distance((java.lang.String) getDistanceConverter().toDB(new Integer(newDistance)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Distance", "Delivery", "int"));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "incidents"));
			}
			
		}	
		return incidentsConverter;
	} 
	private java.lang.String _incidents;
	private java.lang.String get_Incidents() {
		return _incidents;
	}
	private void set_Incidents(java.lang.String newIncidents) {
		this._incidents = newIncidents;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.lang.String getIncidents() {
		try {
			return (java.lang.String) getIncidentsConverter().toJava(get_Incidents());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Incidents", "Delivery", "java.lang.String"));
		}
	}
	
	/**
	 * 
	 */
	public void setIncidents(java.lang.String newIncidents) {
		try { 
			set_Incidents((java.lang.String) getIncidentsConverter().toDB(newIncidents));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Incidents", "Delivery", "java.lang.String"));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "driverType"));
			}
			
		}	
		return driverTypeConverter;
	} 
	private java.lang.String _driverType;
	private java.lang.String get_DriverType() {
		return _driverType;
	}
	private void set_DriverType(java.lang.String newDriverType) {
		this._driverType = newDriverType;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getDriverType() {
		try {
			return (String) getDriverTypeConverter().toJava(get_DriverType());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "DriverType", "Delivery", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setDriverType(String newDriverType) {
		try { 
			set_DriverType((java.lang.String) getDriverTypeConverter().toDB(newDriverType));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "DriverType", "Delivery", "String"));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "remarks"));
			}
			
		}	
		return remarksConverter;
	} 
	private java.lang.String _remarks;
	private java.lang.String get_Remarks() {
		return _remarks;
	}
	private void set_Remarks(java.lang.String newRemarks) {
		this._remarks = newRemarks;
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Delivery", "java.lang.String"));
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Remarks", "Delivery", "java.lang.String"));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "employee"));
			}
			
		}	
		return employeeConverter;
	} 
	private java.lang.String _employee;
	private java.lang.String get_Employee() {
		return _employee;
	}
	private void set_Employee(java.lang.String newEmployee) {
		this._employee = newEmployee;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getEmployee() {
		try {
			return (String) getEmployeeConverter().toJava(get_Employee());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Employee", "Delivery", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setEmployee(String newEmployee) {
		try { 
			set_Employee((java.lang.String) getEmployeeConverter().toDB(newEmployee));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Employee", "Delivery", "String"));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "description"));
			}
			
		}	
		return descriptionConverter;
	} 
	private java.lang.String _description;
	private java.lang.String get_Description() {
		return _description;
	}
	private void set_Description(java.lang.String newDescription) {
		this._description = newDescription;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getDescription() {
		try {
			return (String) getDescriptionConverter().toJava(get_Description());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Delivery", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setDescription(String newDescription) {
		try { 
			set_Description((java.lang.String) getDescriptionConverter().toDB(newDescription));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Description", "Delivery", "String"));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "vehicle"));
			}
			
		}	
		return vehicleConverter;
	} 
	private java.lang.String _vehicle;
	private java.lang.String get_Vehicle() {
		return _vehicle;
	}
	private void set_Vehicle(java.lang.String newVehicle) {
		this._vehicle = newVehicle;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getVehicle() {
		try {
			return (String) getVehicleConverter().toJava(get_Vehicle());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Vehicle", "Delivery", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setVehicle(String newVehicle) {
		try { 
			set_Vehicle((java.lang.String) getVehicleConverter().toDB(newVehicle));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Vehicle", "Delivery", "String"));
		}		
	} 	
	/**
	 * 
	 * 
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
			throw new RuntimeException(XavaResources.getString("generator.calculate_value_error", "TransportMode", "Delivery", ex.getLocalizedMessage()));
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
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	private int date_day;
	private int getDate_day() {
		return date_day;
	}
	private void setDate_day(int newValue) {
		this.date_day = newValue;
	} 
	private int date_month;
	private int getDate_month() {
		return date_month;
	}
	private void setDate_month(int newValue) {
		this.date_month = newValue;
	} 
	private int date_year;
	private int getDate_year() {
		return date_year;
	}
	private void setDate_year(int newValue) {
		this.date_year = newValue;
	} 
	/**
	 * 
	 * 
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
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Delivery", "java.util.Date"));
		}
	}

	/**
	 * 
	 */
	public void setDate(java.util.Date newDate) {
		try { 
			getDateConverter().toDB(newDate); 
			setDate_day(getDateConverter().getDay()); 
			setDate_month(getDateConverter().getMonth()); 
			setDate_year(getDateConverter().getYear()); 			
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_db_error", "Date", "Delivery"));
		}		
	} 
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int newNumber) {
		this.number = newNumber;
	} 

	// References/Referencias 
	private DeliveryType type;
	public DeliveryType getType() {
		return type;
	}
	public void setType(DeliveryType newDeliveryType) {
		this.type = newDeliveryType;
	} 
	private Shipment shipment;
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment newShipment) {
		this.shipment = newShipment;
	} 
	private Carrier carrier;
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier newCarrier) {
		this.carrier = newCarrier;
	} 
	private Invoice invoice;
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice newInvoice) {
		this.invoice = newInvoice;
	} 

	// Colecciones/Collections 
	private java.util.Collection details;
	public java.util.Collection getDetails() {
		return details;
	} 
	
	private MetaModel metaModel;
	private MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Delivery").getMetaEntity(); 	
		}
		return metaModel;
	}
}