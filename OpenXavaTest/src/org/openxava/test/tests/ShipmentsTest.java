package org.openxava.test.tests;

import org.openxava.tests.*;


/**
 * @author Javier Paniza
 */

public class ShipmentsTest extends ModuleTestBase {
	
	public ShipmentsTest(String testName) {
		super(testName, "OpenXavaTest", "Shipments");		
	}
		
	public void testCreateReadDeleteWithConverterInKey() throws Exception {
		// Create
		execute("CRUD.new");
		
		setValue("type", "1");
		setValue("mode", "2");
		setValue("number", "66");
		setValue("description", "JUNIT SHIPMENT");
		execute("CRUD.save"); 		
		assertNoErrors();
		
		assertValue("number", "");
		assertValue("type", "0");
		assertValue("mode", "0");
		assertValue("description", "");
		
		// Search just created
		setValue("type", "1");
		setValue("mode", "2");
		setValue("number", "66");
		execute("CRUD.search");
		assertValue("type", "1"); 		
		assertValue("mode", "2");
		assertValue("number", "66");
		assertValue("description", "JUNIT SHIPMENT");
				
		// Modify
		setValue("description", "JUNIT SHIPMENT MODIFIED");
		execute("CRUD.save");
		assertNoErrors();
		assertValue("type", "0");
		assertValue("mode", "0");
		assertValue("number", "");		
		assertValue("description", "");
		
		// Verify
		setValue("type", "1");
		setValue("mode", "2");
		setValue("number", "66");
		execute("CRUD.search");		
		assertValue("number", "66");
		assertValue("mode", "2");
		assertValue("type", "1"); 
		assertValue("description", "JUNIT SHIPMENT MODIFIED");
										
		// Delete
		execute("CRUD.delete");											
		assertNoErrors();
		assertMessage("Shipment deleted successfully");		
	}
	
	public void testDeleteSelectedOnesWithConverterInKey() throws Exception {
		// Create
		execute("CRUD.new");
		
		setValue("type", "1");
		setValue("mode", "2");
		setValue("number", "66");
		setValue("description", "JUNIT SHIPMENT");
		execute("CRUD.save"); 		
		assertNoErrors();
		
		execute("Mode.list");
				
		int rowCount = getListRowCount();
		assertTrue("Must to be at least 2 shipments for run this test", rowCount >= 2);
		assertTrue("Must not to be more than 9 shipments for run this test", rowCount < 10);

		boolean found = false;
		int row = 0;
		for (; row < rowCount; row++) {
			String number = getValueInList(row, "number");
			String description = getValueInList(row, "description");
			if ("66".equals(number) && "JUNIT SHIPMENT".equals(description)) {
				found = true;
				break;
			}
		}
		assertTrue("Objet not found in list", found);		
		
		checkRow(row);
				
		execute("CRUD.deleteSelected");
		assertNoErrors();
		
		assertListRowCount(rowCount - 1);
		
		found = false;		
		rowCount = getListRowCount();
		for (row = 0; row < rowCount; row++) {
			String number = getValueInList(row, "number");
			String description = getValueInList(row, "description");
			if ("66".equals(number) && "JUNIT SHIPMENT".equals(description)) {
				found = true;
				break;
			}
		}
		assertTrue("Objet found in list", !found);				
	}
	
	public void testFilterByTimestamp() throws Exception {
		assertListRowCount(3);
		setConditionValues( new String [] { "", "", "11/10/2006"} );
		execute("List.filter");
		assertListRowCount(1);
		assertValueInList(0, "description", "CINC");
	}
		
}
