
// File generated by OpenXava: Fri Dec 09 09:30:18 CET 2005
// Archivo generado por OpenXava: Fri Dec 09 09:30:18 CET 2005

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Access		Entity/Entidad

package org.openxava.tracking.model;

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
public class Access implements java.io.Serializable, org.openxava.tracking.model.IAccess {	
	
	// Properties/Propiedades 
	private org.openxava.converters.TrimStringConverter tableConverter;
	private org.openxava.converters.TrimStringConverter getTableConverter() {
		if (tableConverter == null) {
			try {
				tableConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("table");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "table"));
			}
			
		}	
		return tableConverter;
	} 
	private java.lang.String _table;
	private java.lang.String get_Table() {
		return _table;
	}
	private void set_Table(java.lang.String newTable) {
		this._table = newTable;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getTable() {
		try {
			return (String) getTableConverter().toJava(get_Table());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Table", "Access", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setTable(String newTable) {
		try { 
			set_Table((java.lang.String) getTableConverter().toDB(newTable));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Table", "Access", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter userConverter;
	private org.openxava.converters.TrimStringConverter getUserConverter() {
		if (userConverter == null) {
			try {
				userConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("user");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "user"));
			}
			
		}	
		return userConverter;
	} 
	private java.lang.String _user;
	private java.lang.String get_User() {
		return _user;
	}
	private void set_User(java.lang.String newUser) {
		this._user = newUser;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getUser() {
		try {
			return (String) getUserConverter().toJava(get_User());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "User", "Access", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setUser(String newUser) {
		try { 
			set_User((java.lang.String) getUserConverter().toDB(newUser));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "User", "Access", "String"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter recordIdConverter;
	private org.openxava.converters.TrimStringConverter getRecordIdConverter() {
		if (recordIdConverter == null) {
			try {
				recordIdConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("recordId");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "recordId"));
			}
			
		}	
		return recordIdConverter;
	} 
	private java.lang.String _recordId;
	private java.lang.String get_RecordId() {
		return _recordId;
	}
	private void set_RecordId(java.lang.String newRecordId) {
		this._recordId = newRecordId;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getRecordId() {
		try {
			return (String) getRecordIdConverter().toJava(get_RecordId());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "RecordId", "Access", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setRecordId(String newRecordId) {
		try { 
			set_RecordId((java.lang.String) getRecordIdConverter().toDB(newRecordId));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "RecordId", "Access", "String"));
		}		
	} 
	private org.openxava.converters.Boolean01Converter authorizedConverter;
	private org.openxava.converters.Boolean01Converter getAuthorizedConverter() {
		if (authorizedConverter == null) {
			try {
				authorizedConverter = (org.openxava.converters.Boolean01Converter) 
					getMetaModel().getMapping().getConverter("authorized");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "authorized"));
			}
			
		}	
		return authorizedConverter;
	} 
	private java.lang.Integer _authorized;
	private java.lang.Integer get_Authorized() {
		return _authorized;
	}
	private void set_Authorized(java.lang.Integer newAuthorized) {
		this._authorized = newAuthorized;
	} 	
	
	/**
	 * 
	 * 
	 */
	public boolean isAuthorized() {
		try {
			return ((Boolean) getAuthorizedConverter().toJava(get_Authorized())).booleanValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Authorized", "Access", "boolean"));
		}
	}
	
	/**
	 * 
	 */
	public void setAuthorized(boolean newAuthorized) {
		try { 
			set_Authorized((java.lang.Integer) getAuthorizedConverter().toDB(new Boolean(newAuthorized)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Authorized", "Access", "boolean"));
		}		
	} 
	private org.openxava.converters.ValidValuesLetterConverter typeConverter;
	private org.openxava.converters.ValidValuesLetterConverter getTypeConverter() {
		if (typeConverter == null) {
			try {
				typeConverter = (org.openxava.converters.ValidValuesLetterConverter) 
					getMetaModel().getMapping().getConverter("type");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "type"));
			}
			
		}	
		return typeConverter;
	} 
	private java.lang.String _type;
	private java.lang.String get_Type() {
		return _type;
	}
	private void set_Type(java.lang.String newType) {
		this._type = newType;
	} 	
	
	/**
	 * 
	 * 
	 */
	public int getType() {
		try {
			return ((Integer) getTypeConverter().toJava(get_Type())).intValue();
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Type", "Access", "int"));
		}
	}
	
	/**
	 * 
	 */
	public void setType(int newType) {
		try { 
			set_Type((java.lang.String) getTypeConverter().toDB(new Integer(newType)));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Type", "Access", "int"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter timeConverter;
	private org.openxava.converters.TrimStringConverter getTimeConverter() {
		if (timeConverter == null) {
			try {
				timeConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("time");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "time"));
			}
			
		}	
		return timeConverter;
	} 
	private java.lang.String _time;
	private java.lang.String get_Time() {
		return _time;
	}
	private void set_Time(java.lang.String newTime) {
		this._time = newTime;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getTime() {
		try {
			return (String) getTimeConverter().toJava(get_Time());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Time", "Access", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setTime(String newTime) {
		try { 
			set_Time((java.lang.String) getTimeConverter().toDB(newTime));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Time", "Access", "String"));
		}		
	} 
	private int oid;
	public int getOid() {
		return oid;
	}
	public void setOid(int newOid) {
		this.oid = newOid;
	} 
	private org.openxava.converters.TrimStringConverter modelConverter;
	private org.openxava.converters.TrimStringConverter getModelConverter() {
		if (modelConverter == null) {
			try {
				modelConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("model");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "model"));
			}
			
		}	
		return modelConverter;
	} 
	private java.lang.String _model;
	private java.lang.String get_Model() {
		return _model;
	}
	private void set_Model(java.lang.String newModel) {
		this._model = newModel;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getModel() {
		try {
			return (String) getModelConverter().toJava(get_Model());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Model", "Access", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setModel(String newModel) {
		try { 
			set_Model((java.lang.String) getModelConverter().toDB(newModel));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Model", "Access", "String"));
		}		
	} 
	private org.openxava.converters.DateUtilSQLConverter dateConverter;
	private org.openxava.converters.DateUtilSQLConverter getDateConverter() {
		if (dateConverter == null) {
			try {
				dateConverter = (org.openxava.converters.DateUtilSQLConverter) 
					getMetaModel().getMapping().getConverter("date");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "date"));
			}
			
		}	
		return dateConverter;
	} 
	private java.sql.Date _date;
	private java.sql.Date get_Date() {
		return _date;
	}
	private void set_Date(java.sql.Date newDate) {
		this._date = newDate;
	} 	
	
	/**
	 * 
	 * 
	 */
	public java.util.Date getDate() {
		try {
			return (java.util.Date) getDateConverter().toJava(get_Date());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Access", "java.util.Date"));
		}
	}
	
	/**
	 * 
	 */
	public void setDate(java.util.Date newDate) {
		try { 
			set_Date((java.sql.Date) getDateConverter().toDB(newDate));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Date", "Access", "java.util.Date"));
		}		
	} 
	private org.openxava.converters.TrimStringConverter applicationConverter;
	private org.openxava.converters.TrimStringConverter getApplicationConverter() {
		if (applicationConverter == null) {
			try {
				applicationConverter = (org.openxava.converters.TrimStringConverter) 
					getMetaModel().getMapping().getConverter("application");
			}
			catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(XavaResources.getString("generator.create_converter_error", "application"));
			}
			
		}	
		return applicationConverter;
	} 
	private java.lang.String _application;
	private java.lang.String get_Application() {
		return _application;
	}
	private void set_Application(java.lang.String newApplication) {
		this._application = newApplication;
	} 	
	
	/**
	 * 
	 * 
	 */
	public String getApplication() {
		try {
			return (String) getApplicationConverter().toJava(get_Application());
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Application", "Access", "String"));
		}
	}
	
	/**
	 * 
	 */
	public void setApplication(String newApplication) {
		try { 
			set_Application((java.lang.String) getApplicationConverter().toDB(newApplication));
		}
		catch (org.openxava.converters.ConversionException ex) {
			ex.printStackTrace();
			throw new RuntimeException(XavaResources.getString("generator.conversion_error", "Application", "Access", "String"));
		}		
	} 

	// References/Referencias 

	// Colecciones/Collections 

	// Methods/Metodos 	

	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Access").getMetaEntity(); 	
		}
		return metaModel;
	}
	
	public String toString() { 
		return "Access::" + oid;
	}

	public boolean equals(Object other) {		
		if (other == null) return false;
		return toString().equals(other.toString());
	}
	
	public int hashCode() {		
		return toString().hashCode();
	}
	
}