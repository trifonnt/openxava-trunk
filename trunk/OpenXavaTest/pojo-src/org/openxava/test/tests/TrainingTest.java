package org.openxava.test.tests;

import org.openxava.tests.*;



/**
 * @author Javier Paniza
 */

public class TrainingTest extends ModuleTestBase {
	
	public TrainingTest(String testName) {
		super(testName, "Training");		
	}
	
	public void testElementCollection() throws Exception {
		execute("CRUD.new");
		setValue("sportsman.id", "4028819617a634cc0117a63750af0002");
		setValue("description", "JUNIT TRAINING");
		assertCollectionRowCount("sessions", 0); 
		setValueInCollection("sessions", 0, "description", "RUNNING IN THE STREET"); 
		assertCollectionRowCount("sessions", 1);
		assertValueInCollection("sessions", 1, "description", "");  
		assertValueInCollection("sessions", 1, "kms", "");
		assertValueInCollection("sessions", 1, "date", "");		
		setValueInCollection("sessions", 0, "kms", "5");
		setValueInCollection("sessions", 0, "date", "1/1/14");
		setValueInCollection("sessions", 1, "description", "CORRIENDO EN LA CALLE");
		assertCollectionRowCount("sessions", 2);
		assertValueInCollection("sessions", 2, "description", ""); 
		assertValueInCollection("sessions", 2, "kms", "");
		assertValueInCollection("sessions", 2, "date", "");
		setValueInCollection("sessions", 1, "kms", "7");
		setValueInCollection("sessions", 1, 2, "2/1/14");
		setValueInCollection("sessions", 2, "description", "WALKING"); // The third row is generated
		assertCollectionRowCount("sessions", 3);
		assertValueInCollection("sessions", 3, "description", ""); 
		assertValueInCollection("sessions", 3, "kms", "");
		assertValueInCollection("sessions", 3, "date", "");		
		setValueInCollection("sessions", 2, "kms", "2");
		setValueInCollection("sessions", 2, "date", "3/1/14");
		assertCollectionRowCount("sessions", 3);
		execute("CRUD.save");
		assertValue("description", "");
		assertCollectionRowCount("sessions", 0);
		assertValueInCollection("sessions", 0, "description", ""); 
		assertValueInCollection("sessions", 0, "kms", "");
		assertValueInCollection("sessions", 0, "date", "");
		
		execute("Mode.list");
		execute("Mode.detailAndFirst");
		assertValue("description", "JUNIT TRAINING");
		assertCollectionRowCount("sessions", 3);
		assertValueInCollection("sessions", 0, "description", "RUNNING IN THE STREET"); 
		assertValueInCollection("sessions", 0, 1, "5");
		assertValueInCollection("sessions", 0, "date", "1/1/14");
		assertValueInCollection("sessions", 1, "description", "CORRIENDO EN LA CALLE");
		assertValueInCollection("sessions", 1, "kms", "7");
		assertValueInCollection("sessions", 1, "date", "2/1/14");
		assertValueInCollection("sessions", 2, "description", "WALKING"); 
		assertValueInCollection("sessions", 2, "kms", "2");
		assertValueInCollection("sessions", 2, "date", "3/1/14");		
		assertValueInCollection("sessions", 3, "description", ""); 
		assertValueInCollection("sessions", 3, "kms", "");
		assertValueInCollection("sessions", 3, "date", "");
		
		execute("CRUD.delete");
		assertNoErrors();
	}
		
}