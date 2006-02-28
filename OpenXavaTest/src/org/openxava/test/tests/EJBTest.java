package org.openxava.test.tests;

import java.math.*;
import java.util.*;

import javax.rmi.*;

import org.openxava.test.model.*;

import junit.framework.*;

/**
 * @author Javier Paniza
 */

public class EJBTest extends TestCase {

	public EJBTest(String name) {
		super(name);
	}
	
	public void testOrderBy() throws Exception {
		Collection customers = CustomerUtil.getHome().findByNameLike("%");		
		String previous = "{}";
		for (Iterator it = customers.iterator(); it.hasNext();) {
			CustomerRemote customer = (CustomerRemote) PortableRemoteObject.narrow(it.next(), CustomerRemote.class);
			String name = customer.getName();			
			if (name.compareTo(previous) > 0) {				
				fail("The names must to be ordered");
			}
			previous = name;
		}
	}
	
	public void testKeyToAndFromString() throws Exception {
		DeliveryKey key = new DeliveryKey();		
		key.set_Invoice_year(2002);
		key.set_Invoice_number(1);
		key.set_Type_number(7);
		key.setNumber(66);
		DeliveryKey key2 = DeliveryKey.createFromString(key.toString());
		assertEquals("invoice_year", 2002, key2.get_Invoice_year());
		assertEquals("invoice_number", 1, key2.get_Invoice_number());
		assertEquals("type_number", 7, key2.get_Type_number());
		assertEquals("number", 66, key2.getNumber());		
	}
	
	public void testCalculatedPropertyDependOnMultiLevelProperty() throws Exception {
		InvoiceValue value = new InvoiceValue();
		value.setYear(2005);
		value.setNumber(66);
		InvoiceRemote invoice = InvoiceUtil.getHome().create(value);		
		assertEquals(null,  invoice.getSellerDiscount());
		invoice.remove();
	}
	
	public void testAggregatesInValues() throws Exception {
		CustomerValue v = new CustomerValue();
		v.getAddress(); // Only for test no compile error
	}
	
	public void testImplementInterfaces() throws Exception {
		assertTrue("Customer should implement IWithName", IWithName.class.isAssignableFrom(CustomerRemote.class));
		assertTrue("Address should implemenr IWithState", IWithCity.class.isAssignableFrom(Address.class));
	}
	
	public void testValueObjectWithCalculatedProperties() throws Exception {
		InvoiceKey key = new InvoiceKey();		
		key.year = 2002;
		key.number = 1;		
		InvoiceRemote invoice = InvoiceUtil.getHome().findByPrimaryKey(key);
		InvoiceValue v = invoice.getInvoiceValue();
		assertEquals("amountsSum", new BigDecimal("2500.00"), v.getAmountsSum());
		assertEquals("vat", new BigDecimal("400.00"), v.getVat());
		assertEquals("detailsCount", 2, v.getDetailsCount());
		assertEquals("importance", "Normal", v.getImportance());		
	}
	
	public void testCreateWithValueObject() throws Exception {
		Family2Value value = new Family2Value();
		value.setNumber(66);
		value.setDescription("PROVA JUNIT");
		Family2Util.getHome().create(value);
		Family2Remote f = Family2Util.getHome().findByPrimaryKey(new Family2Key(66));
		assertEquals("number", 66, f.getNumber());
		assertEquals("description", "PROVA JUNIT", f.getDescription());
		Family2Value obtainedValue = f.getFamily2Value();
		assertEquals("number", 66, obtainedValue.getNumber());
		assertEquals("description", "PROVA JUNIT", obtainedValue.getDescription());
		f.remove();  
	}
	
	public void testCreateAggregateWithValueObject() throws Exception {
		AdditionalDetailValue value = new AdditionalDetailValue();
		value.setCounter(0);
		value.setSubfamily(1);
		value.setType_number(2);
		ServiceValue serviceValue = new ServiceValue();
		serviceValue.setNumber(66);
		serviceValue.setDescription("SERVICE FOR JUNIT TEST");
		ServiceRemote service = ServiceUtil.getHome().create(serviceValue);
		AdditionalDetailUtil.getHome().create(service, 0, value);
		AdditionalDetailKey additionalDetailKey = new AdditionalDetailKey();
		additionalDetailKey.set_Service_number(66);
		additionalDetailKey.setCounter(0);

		AdditionalDetailRemote d = AdditionalDetailUtil.getHome().findByPrimaryKey(additionalDetailKey);
		assertEquals("counter", 0, d.getCounter());
		assertEquals("subfamily", 1, d.getSubfamily());
		assertEquals("type_number", 2, d.getType_number());
		assertEquals("service_number", 66, d.getService_number());		

		AdditionalDetailValue obtainedValue = d.getAdditionalDetailValue();
		assertEquals("counter", 0, obtainedValue.getCounter());
		assertEquals("subfamily", 1, obtainedValue.getSubfamily());
		assertEquals("type_number", 2, obtainedValue.getType_number());
		assertEquals("service_number", 66, obtainedValue.getService_number());		
		
		d.remove();		
		service.remove();
	}
	
	
	public void testKeyReferences() throws Exception {
		DeliveryValue value = new DeliveryValue();
		value.setInvoice_year(2099);
		value.setInvoice_number(99);
		value.setNumber(66);
		value.setDescription("JUNIT EJB");
		DeliveryUtil.getHome().create(value);
		DeliveryKey key = new DeliveryKey();
		key.set_Invoice_year(2099);
		key.set_Invoice_number(99);
		key.setNumber(66);
		DeliveryRemote delivery = DeliveryUtil.getHome().findByPrimaryKey(key);
		InvoiceKey invoiceKey = delivery.getInvoiceKey();
		assertEquals("invoice_year", 2099, invoiceKey.getYear());
		assertEquals("invoice_number", 99, invoiceKey.getNumber());
		assertEquals("number", 66, delivery.getNumber());
		assertEquals("description", "JUNIT EJB", delivery.getDescription());
		DeliveryValue deliveryValue = delivery.getDeliveryValue();
		assertEquals("value.invoice_year", 2099, deliveryValue.getInvoice_year());
		assertEquals("value.invoice_number", 99, deliveryValue.getInvoice_number());
		assertEquals("value.number", 66, deliveryValue.getNumber());
		assertEquals("value.description", "JUNIT EJB", deliveryValue.getDescription());		
		delivery.remove(); 
	}
	
	
	
	public void testXavaMethods() throws Exception {
		ProductValue value = new ProductValue();
		value.setNumber(66);
		value.setFamilyNumber(1);
		value.setSubfamilyNumber(1);
		value.setDescription("DESCRIPTION JUNIT");
		value.setUnitPrice(new BigDecimal("100.00"));
		ProductRemote product = ProductUtil.getHome().create(value);
		try {		
			assertEquals(new BigDecimal("100.00"), product.getUnitPrice());
			product.increasePrice();
			assertEquals(new BigDecimal("102.00"), product.getUnitPrice());

			assertEquals(new BigDecimal("102.00"), product.getPrice("Espa�a", new BigDecimal("0.00")));			 			
			assertEquals(new BigDecimal("103.00"), product.getPrice("Guatemala", new BigDecimal("1.00")));
			try {
				product.getPrice("El Puig", new BigDecimal("2.00"));
				fail("It should fail: 'El Puig' is not recognized as country");
			}
			catch (PriceException ex) {
			}		
		}
		finally {
			product.remove();	
		}		  		
	}
	
	public void testConvertersByDefault() throws Exception {
		Iterator it = InvoiceUtil.getHome().findAll().iterator();
		InvoiceRemote invoice = null;
		while (it.hasNext()) {
			invoice  = (InvoiceRemote) PortableRemoteObject.narrow(it.next(), InvoiceRemote.class);
			if (invoice.getDetailsCount() > 0) break;
			invoice = null;
		}
		assertNotNull("At least one invoice with details is required for run this test", invoice);
		invoice.setComment(" INVOICE WITH SPACES ");
		InvoiceDetailRemote detail = (InvoiceDetailRemote) PortableRemoteObject.narrow(
				invoice.getDetails().iterator().next(), InvoiceDetailRemote.class);
		detail.setRemarks(" DETAIL WITH SPACES ");
		
		assertEquals("INVOICE WITH SPACES", invoice.getComment());
		assertEquals("DETAIL WITH SPACES", detail.getRemarks());
	}
	
	public void testConvertersAllPropertiesOnCreate() throws Exception { // One way to avoid nulls	
		Map v = new HashMap();
		v.put("number", new Integer(77));
		v.put("description", "PROVA JUNIT 77");
		SubfamilyRemote f = SubfamilyUtil.getHome().create(v);
		SubfamilyKey key = (SubfamilyKey) f.getPrimaryKey(); 
		SubfamilyRemote f2 = SubfamilyUtil.getHome().findByPrimaryKey(key);
		assertEquals("PROVA JUNIT 77", f2.getDescription());
		assertEquals("", f2.getRemarksDB()); 		
		f.remove();
	}

}
