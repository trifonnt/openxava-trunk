package org.openxava.test.tests

import org.openxava.tests.ModuleTestBase 

/**
 * Create on 09/06/2011 (16:04:34)
 * @author Ana Andres
 */
class AuthorTest extends ModuleTestBase {
	
	AuthorTest(String testName) {
		super(testName, "Author")		
	}

	void testCollectionViewWithGroup() {
		assertLabelInList(0, "Author")
		assertValueInList(1, 0, "MIGUEL DE CERVANTES")
		execute("List.viewDetail", "row=1")
		assertCollectionRowCount("humans", 1)
		execute("Collection.view", "row=0,viewObject=xava_view_humans")
		assertNoErrors()
		assertDialog()
	}
	
	void testCustomMessageWithBeanValidationJSR303() {
		execute "CRUD.new"
		setValue "author", "PEPE"
		execute "CRUD.save"
		assertError "Sorry, but PEPE is not a good name for an author"
	}


}
