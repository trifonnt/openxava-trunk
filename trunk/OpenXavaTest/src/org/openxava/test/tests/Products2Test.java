package org.openxava.test.tests;

import java.math.*;

import org.openxava.test.ejb.*;
import org.openxava.tests.*;


/**
 * @author Javier Paniza
 */

public class Products2Test extends ModuleTestBase {
	
	public Products2Test(String testName) {
		super(testName, "OpenXavaTest", "Products2");		
	}
	
	public void testReferencesAsDescriptionListUsesFilterOfDefaultTab() throws Exception {
		execute("CRUD.new");
		execute("Products2.changeLimitZone");
		
		WarehouseKey key1 = new WarehouseKey();
		key1.setZoneNumber(1);
		key1.set_Number(new Integer(1));
		WarehouseKey key2 = new WarehouseKey();
		key2.setZoneNumber(1);
		key2.set_Number(new Integer(2));
		WarehouseKey key3 = new WarehouseKey();
		key3.setZoneNumber(1);
		key3.set_Number(new Integer(3));
		
		String [][] warehouses = {
				{ "", "" },
				{ key1.toString(), "CENTRAL VALENCIA" },
				{ key3.toString(), "VALENCIA NORTE" },
				{ key2.toString(), "VALENCIA SURETE" } 
		};		
		assertValidValues("warehouse.KEY", warehouses);
	}
	
	public void testDefaultValueCalculatorForReferences() throws Exception {
		execute("CRUD.new");
		assertValue("family.number", "2");		
		assertValue("warehouse.KEY", "[.4.4.]");
	}
	
	public void testFocusMoveToReferenceAsDescriptionsList() throws Exception {
		execute("CRUD.new");
		setValue("family.number", "1");
		assertFocusOn("subfamily.number");
	}
	
	public void testListToDetailAlwaysMainView() throws Exception {
		execute("CRUD.new");		
		assertExists("unitPrice");
		execute("Reference.createNew", "model=Family2,keyProperty=xava.Product2.family.number");
		assertNotExists("unitPrice");
		execute("Mode.list");
		execute("CRUD.new");		
		assertExists("unitPrice");				
	}
	
	public void testSetEditableOnReferencesAsDescriptionsList() throws Exception {		
		execute("CRUD.new");
		assertEditable("family");
		execute("Products2.deactivateType");
		assertNoEditable("family");		
	}
	
	public void testOnChageDescriptionsListReferenceMultipleKey() throws Exception {
		execute("CRUD.new");
		assertNotExists("zoneOne");
		
		WarehouseKey warehouseKeyZone1 = new WarehouseKey();
		warehouseKeyZone1.set_Number(new Integer(1));
		warehouseKeyZone1.setZoneNumber(1); 
		setValue("warehouse.KEY", warehouseKeyZone1.toString());
		assertExists("zoneOne");
		
		WarehouseKey warehouseKeyZone2 = new WarehouseKey();
		warehouseKeyZone2.set_Number(new Integer(1));
		warehouseKeyZone2.setZoneNumber(2); 
		setValue("warehouse.KEY", warehouseKeyZone2.toString());
		assertNotExists("zoneOne");
		
		createProduct(66, "JUNIT ZONE 1", 1);
		createProduct(67, "JUNIT ZONE 2", 2);
		
		setValue("number", "66");
		execute("CRUD.search");
		assertNoErrors();
		assertValue("description", "JUNIT ZONE 1");
		assertExists("zoneOne");
		
		execute("CRUD.new");
		setValue("number", "67");
		execute("CRUD.search");
		assertNoErrors();
		assertValue("description", "JUNIT ZONE 2");
		assertNotExists("zoneOne");
		
		setValue("warehouse.KEY", "");
		assertValue("warehouse.KEY", "");
				
		deleteProduct(66);
		deleteProduct(67);
	}

	

	public void testDescriptionsListReferenceDependents() throws Exception {
		
		execute("CRUD.new");
	
		// Verifying initial state		
		String [][] familyValues = {
			{ "", "" },
			{ "1", "SOFTWARE" },
			{ "2", "HARDWARE" },
			{ "3", "SERVICIOS" }	
		};
		
		assertValue("family.number", "2"); // 2 is the default value		
		assertValidValues("family.number", familyValues);
		setValue("family.number", "");
		
		String [][] voidValues = {
			{ "", "" }
		};
		
		assertValue("subfamily.number", "");		
		assertValidValues("subfamily.number", voidValues);
		
		// Change value
		setValue("family.number", "2");
		String [][] hardwareValues = {
			{ "", ""},
			{ "12", "PC"},
			{ "13", "PERIFERICOS"},			
			{ "11", "SERVIDORES"}						
		};
		assertValue("subfamily.number", "");
		assertValidValues("subfamily.number", hardwareValues);
		
		// Changing the value again
		setValue("family.number", "1");
		String [][] softwareValues = {
			{ "", ""},
			{ "1", "DESARROLLO"},
			{ "2", "GESTION"},						  
			{ "3", "SISTEMA"}						
		};
		assertValue("subfamily.number", "");
		assertValidValues("subfamily.number", softwareValues);										
	}
	
	public void testNavigationWithDescriptionsListReferenceDependents() throws Exception {		
		execute("Mode.detailAndFirst");
		assertValue("number", "1");
		assertValue("family.number", "1");
		assertValue("subfamily.number", "2");		
		execute("Navigation.next");		
		assertValue("number", "2");
		assertValue("family.number", "2");
		assertValue("subfamily.number", "11");		
		execute("Navigation.next");
		assertValue("number", "3");
		assertValue("family.number", "1");
		assertValue("subfamily.number", "1");						
	}
	
	public void testCreateModifyAndReadWithDescriptionsListReference() throws Exception {
				
		// Create
		execute("CRUD.new");		
		setValue("number", "66");
		setValue("description", "JUNIT PRODUCT");
		setValue("family.number", "2");
		assertNoErrors();
		setValue("subfamily.number", "12");
		WarehouseKey warehouseKey = new WarehouseKey();
		warehouseKey.set_Number(new Integer(1));
		warehouseKey.setZoneNumber(2); 
		setValue("warehouse.KEY", warehouseKey.toString());
		setValue("unitPrice", "125.66");
		assertNoErrors();
		assertNoEditable("unitPriceInPesetas");
		execute("CRUD.save");				
		assertNoErrors();
				
		// Search for verify
		setValue("number", "66");
		execute("CRUD.search");
		assertNoErrors();
		assertValue("number", "66");
		assertValue("description", "JUNIT PRODUCT");
		assertValue("family.number", "2");
		assertValue("subfamily.number", "12");
		assertValue("warehouse.KEY", warehouseKey.toString());
		assertValue("unitPrice", "125.66");
		
		// Modify
		setValue("subfamily.number", "13");
		execute("CRUD.save");
		assertNoErrors();
		assertValue("number", "");
		assertValue("description", "");
		
		// Verifying just modified
		setValue("number", "66");
		execute("CRUD.search");
		assertNoErrors();
		assertValue("number", "66");
		assertValue("description", "JUNIT PRODUCT");
		assertValue("family.number", "2");
		assertValue("subfamily.number", "13");

				
		// Delete
		execute("CRUD.delete");
		assertMessage("Product deleted successfully");		
	}
					
	public void testReferencesInListMode() throws Exception {				
		assertValueInList(1, "number", "2");
		assertValueInList(1, "family.description", "HARDWARE");
		assertValueInList(1, "subfamily.description", "SERVIDORES");
	}
	
	public void testCreateReferencesFromDescriptionsList() throws Exception {
		
		execute("CRUD.new");		

		// Verifying initial state		
		String [][] familyValues = {
			{ "", "" },
			{ "1", "SOFTWARE" },
			{ "2", "HARDWARE" },
			{ "3", "SERVICIOS" }	
		};
		assertValidValues("family.number", familyValues);
		
		execute("Reference.createNew", "model=Family2,keyProperty=xava.Product2.family.number");
		assertAction("NewCreation.saveNew");
		assertAction("NewCreation.cancel");
		execute("NewCreation.cancel");	
		execute("Reference.createNew", "model=Family2,keyProperty=xava.Product2.family.number");
		assertAction("NewCreation.saveNew");
		assertAction("NewCreation.cancel");
		execute("NewCreation.saveNew");
		assertError("Value for Number in Family is required");
		assertError("Value for Description in Family is required");
		setValue("Family2", "number", "1");
		setValue("Family2", "description", "JUNIT TEST");
		execute("NewCreation.saveNew");
		assertError("Impossible to create: an object with that key already exists");
		setValue("Family2", "number", "66");
		execute("NewCreation.saveNew");
		assertNoErrors();		
		
		// Test just added
		String [][] familyValuesUpdated = {
			{ "", "" },
			{ "1", "SOFTWARE" },
			{ "2", "HARDWARE" },
			{ "3", "SERVICIOS" },	
			{ "66", "JUNIT TEST" }
		};				
		assertValidValues("family.number", familyValuesUpdated);
		
		// Delete it
		Family2Util.getHome().remove(new Family2Key(66));
	}
	
	public void testDescriptionsListReferenceValidation() throws Exception {						
		execute("CRUD.new");	
		setValue("family.number", ""); // because has a default value
		execute("CRUD.save");				
		assertError("Value for Family in Product is required");
		assertError("Value for Subfamily in Product is required");
	}
	
	private void createProduct(int number, String description, int zone) throws Exception {
		Product2Value v = new Product2Value();
		v.setNumber(number);
		v.setDescription(description);
		v.setFamily_number(1);
		v.setSubfamily_number(1);
		v.setWarehouse_number(new Integer(1));
		v.setWarehouse_zoneNumber(zone);
		v.setUnitPrice(new BigDecimal("1.00"));
		Product2Util.getHome().create(v);		
	}
			
	private void deleteProduct(int number) throws Exception {
		Product2Key k = new Product2Key();
		k.setNumber(number);
		Product2Util.getHome().remove(k);		
	}
					
}
