

// File generated by OpenXava: Mon May 09 13:02:14 CEST 2016
// Archivo generado por OpenXava: Mon May 09 13:02:14 CEST 2016

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Color		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IColor  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_hexValue = "hexValue"; 
	String getHexValue() throws RemoteException;
	void setHexValue(String hexValue) throws RemoteException; 	
	public static final String PROPERTY_name = "name"; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	Integer getNumber() throws RemoteException; 	
	public static final String PROPERTY_sample = "sample"; 	
	java.lang.String getSample() throws RemoteException; 	
	public static final String PROPERTY_version = "version"; 
	int getVersion() throws RemoteException;
	void setVersion(int version) throws RemoteException;		

	// References/Referencias 

	// AnotherCT : Reference/Referencia
	
	org.openxava.test.model.ICharacteristicThing getAnotherCT() throws RemoteException;
	void setAnotherCT(org.openxava.test.model.ICharacteristicThing newAnotherCT) throws RemoteException; 

	// Mixture : Reference/Referencia
	
	org.openxava.test.model.IMixture getMixture() throws RemoteException;
	void setMixture(org.openxava.test.model.IMixture newMixture) throws RemoteException; 

	// CharacteristicThing : Reference/Referencia
	
	org.openxava.test.model.ICharacteristicThing getCharacteristicThing() throws RemoteException;
	void setCharacteristicThing(org.openxava.test.model.ICharacteristicThing newCharacteristicThing) throws RemoteException; 

	// UsedTo : Reference/Referencia
	
	org.openxava.test.model.IThing getUsedTo() throws RemoteException;
	void setUsedTo(org.openxava.test.model.IThing newUsedTo) throws RemoteException;

	// Methods 


}