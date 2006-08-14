package org.openxava.test.tests;

import javax.ejb.*;

import org.openxava.hibernate.*;
import org.openxava.test.model.*;
import org.openxava.tests.*;

/**
 * @author Javier Paniza
 */

public class CustomersSellerAsAggregateTest extends ModuleTestBase {
	
	public CustomersSellerAsAggregateTest(String testName) {
		super(testName, "OpenXavaTest", "CustomersSellerAsAggregate");				
	}
	

	public void testReferenceToEntityAsAggregate() throws Exception {
		// Creating customer and its seller at once
		execute("CRUD.new");
		setValue("number", "66");
		setValue("name", "JUNIT CUSTOMER 66");
		setValue("address.street", "DOCTOR PESSET");
		setValue("address.zipCode", "46540");
		setValue("address.city", "EL PUIG");
		setValue("address.state.id", "CA");
		
		setValue("seller.number", "66");
		setValue("seller.name", "SELLER CREATED FROM CUSTOMER");
		
		execute("CRUD.save");
		assertNoErrors();
		
		// Searching to verify
		assertValue("name", "");
		setValue("number", "66");
		execute("CRUD.search");
		
		assertValue("name", "Junit Customer 66");
		assertValue("seller.number", "66");
		assertValue("seller.name", "SELLER CREATED FROM CUSTOMER");
		
		// Modifiying
		setValue("seller.name", "SELLER MODIFIED FROM CUSTOMER");
		
		execute("CRUD.save");
		assertNoErrors();
		
		// Searching to verify
		assertValue("name", "");
		setValue("number", "66");
		execute("CRUD.search");
		
		assertValue("name", "Junit Customer 66");
		assertValue("seller.number", "66");
		assertValue("seller.name", "SELLER MODIFIED FROM CUSTOMER");
		
		// Removing
		execute("CRUD.delete");
		assertNoErrors();
		assertMessage("Customer deleted successfully");
		
		// Asserting that seller is not removed
		// Although at IU level 'seller' behaves as aggreagate, actually it's a reference
		// to entity, therefore it cannot be removed automatically, because maybe reference
		// from other place.
		assertCustomerNotExist(66);
		assertSellerExist(66);
		deleteSeller(66);
	}


	private void deleteSeller(int number) throws Exception {
		XHibernate.getSession().delete(Seller.findByNumber(number));		
	}

	private void assertSellerExist(int number) {
		try {
			Seller.findByNumber(66);
		}
		catch (ObjectNotFoundException ex) {
			fail("Seller " + number + " does not exist, and it should");
		}
	}

	private void assertCustomerNotExist(int number) {
		try {
			Customer.findByNumber(number);
			fail("Customer " + number + " exists, and it shouldn't");
		}
		catch (ObjectNotFoundException ex) {			
		}		
	}
		
}
