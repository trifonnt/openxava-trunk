package org.openxava.test.tests;

import org.openxava.tests.*;

/**
 * @author Javier Paniza
 */

public class Products3WithDescriptionsListTest extends ModuleTestBase {
	
	public Products3WithDescriptionsListTest(String testName) {
		super(testName, "OpenXavaTest", "Products3WithDescriptionsList");		
	}
	
	public void testNotOnChangeActionWhenSearch() throws Exception {
		execute("CRUD.new");
		execute("Products3.showDescription"); // description is hide in a init action for test purpose
		setValue("number", "77");
		execute("CRUD.search");
		assertValue("description", "ANATHEMA");
		assertEditable("description"); // well: on-change for make this not editable not throw
	}
	
	public void testDescriptionsListWithHiddenKeyThrowsChanged() throws Exception {
		execute("CRUD.new");
		execute("Products3.showDescription"); // description is hide in a init action for test purpose
		assertNoErrors();
		assertValue("comments", "");
		setValue("family.oid", "1037101892379");
		assertValue("comments", "Family changed");
	}
	
	public void testSetValueNotifyingOnReferenceWithHiddenKeyNotResetGroup() throws Exception {
		execute("CRUD.new");
		execute("Products3.showDescription"); // description is hide in a init action for test purpose
		setValue("description", "HOLA");
		execute("Products3.changeFamily");
		assertValue("description", "HOLA");
	}
						
}
