package org.openxava.util;

import java.io.*;
import java.util.*;

/**
 * @author Javier Paniza
 */
public class XavaPreferences {
	
	private final static String FILE_PROPERTIES="xava.properties";
		
	private Properties properties;
	private static XavaPreferences instance;
	private boolean ejb2PersistenceLoaded=false;
	private boolean ejb2Persistence=false;
	private boolean jpaPersistenceLoaded=false;
	private boolean jpaPersistence=false;	
	private boolean duplicateComponentWarningsLoaded=false;
	private boolean duplicateComponentWarnings=false;

	private int maxSizeForTextEditor;	
  
	public static XavaPreferences getInstance() {
		if (instance == null) {
			instance = new XavaPreferences();
		}
		return instance;
	}
	

	private Properties getProperties() {
		if (properties == null) {
			PropertiesReader reader = new PropertiesReader(XavaPreferences.class, FILE_PROPERTIES);
			try {
				properties = reader.get();
			} 
			catch (IOException e) {			
				System.err.println(XavaResources.getString("properties_file_error", FILE_PROPERTIES));
				properties = new Properties();
			}
		}
		return properties;
	}

	public boolean isReadOnlyAsLabel() {
		return "true".equalsIgnoreCase(getProperties().getProperty("readOnlyAsLabel", "false").trim());
	}
	
	public boolean isButtonBarOnTop() {
		return "true".equalsIgnoreCase(getProperties().getProperty("buttonBarOnTop", "true").trim());
	}
	
	public boolean isButtonBarOnBottom() {
		return "true".equalsIgnoreCase(getProperties().getProperty("buttonBarOnBottom", "true").trim());
	}
	
	public boolean isTabAsEJB() {
		return "true".equalsIgnoreCase(getProperties().getProperty("tabAsEJB", "false").trim());
	}
	
	public boolean isShowCountInList() {
		return "true".equalsIgnoreCase(getProperties().getProperty("showCountInList", "true").trim());
	}
		
	public String getFormLineSpacing() {
		return getProperties().getProperty("formLineSpacing", "1");
	}
	
	public String getPersistenceProviderClass() {
		return getProperties().getProperty("persistenceProviderClass", "org.openxava.model.impl.HibernatePersistenceProvider").trim();
	}
	
	public boolean isMapFacadeAsEJB() {
		return "true".equalsIgnoreCase(getProperties().getProperty("mapFacadeAsEJB", "false").trim());
	}

	public boolean isEJB2Persistence() {
		if (!ejb2PersistenceLoaded) {
			ejb2PersistenceLoaded = true;
			ejb2Persistence = getPersistenceProviderClass().toUpperCase().indexOf("EJB") >= 0;
		}	
		return ejb2Persistence;
	}
	
	public boolean isJPAPersistence() {
		if (!jpaPersistenceLoaded) {
			jpaPersistenceLoaded = true;
			jpaPersistence = getPersistenceProviderClass().toUpperCase().indexOf("JPA") >= 0;
		}	
		return jpaPersistence;
	}
	
	/**
	 * Useful when you want to force some code (as finders) to not use JPA implementation. <p>
	 * 
	 * Warning! This does not change the value of persistenceProviderClass,
	 * only change the behaviour of code that call to isJPAPersistence.<br>
	 * Usually you use this method inside of test code to force to use hibernate
	 * or jpa implementation when work with POJOs.
	 * 
	 * For example, if you call <code>setJPAPersistence(false)</code> 
	 * then you force to the POJO finder to use hibernate always, instead of JPA.
	 */
	public void setJPAPersistence(boolean jpaPersistence) {
		this.jpaPersistence = jpaPersistence;
		this.jpaPersistenceLoaded = true;
	}
	

	public boolean isI18nWarnings() {
		return "true".equalsIgnoreCase(getProperties().getProperty("i18nWarnings", "true").trim());		
	}


	public boolean isDuplicateComponentWarnings() {
		if (!duplicateComponentWarningsLoaded) { 
			duplicateComponentWarnings = "true".equalsIgnoreCase(getProperties().getProperty("duplicateComponentWarnings", "true").trim());
			duplicateComponentWarningsLoaded = true;
		}
		return duplicateComponentWarnings;
	}
	
	public int getMaxSizeForTextEditor() {
		if (maxSizeForTextEditor == 0) { 
			maxSizeForTextEditor = Integer.parseInt(getProperties().getProperty("maxSizeForTextEditor", "100"));
		}
		return maxSizeForTextEditor;
	}	
	
	public void setDuplicateComponentWarnings(boolean duplicateComponentWarnings) {
		this.duplicateComponentWarnings = duplicateComponentWarnings;
		duplicateComponentWarningsLoaded = true;
	}
	
}
