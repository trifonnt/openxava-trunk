package org.openxava.test.tests;

import org.openxava.tests.*;

/**
 * @author Javier Paniza
 */

public class CustomersSomeMembersReadOnlyTest extends ModuleTestBase {
		
	public CustomersSomeMembersReadOnlyTest(String testName) {
		super(testName, "CustomersSomeMembersReadOnly");
	}
	
	public void testReadOnly() throws Exception {
		execute("CRUD.new");
		assertEditable("type");
		assertNoEditable("name");
		assertNoEditable("seller.number");
		assertNoEditable("alternateSeller");
	}
	
	public void test2LevelsReferenceInDescriptionsList() throws Exception {
		execute("Mode.detailAndFirst");
		assertValue("number", "1");
		assertDescriptionValue("alternateSeller.number", "MANAGER JUANVI LLAVADOR");
	}
		
}
