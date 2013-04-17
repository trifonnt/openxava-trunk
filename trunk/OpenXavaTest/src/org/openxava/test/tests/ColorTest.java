package org.openxava.test.tests;

import javax.persistence.*;

import org.apache.commons.logging.*;
import org.openxava.test.model.*;
import org.openxava.tests.*;
import org.openxava.util.*;


/**
 * @author Javier Paniza
 */

public class ColorTest extends ModuleTestBase {
	private static Log log = LogFactory.getLog(ColorTest.class);
	
	public ColorTest(String testName) {
		super(testName, "Color");		
	}
	
	public void testPrintPDF() throws Exception {
		execute("List.orderBy", "property=number");
		checkRow(1);
		String number1 = getValueInList(1, 0);
		String name1 = getValueInList(1, 1);
		String hexValue1 = getValueInList(1, 2);
		String useTo1 = getValueInList(1, 3);
		String characteristicThing1 = getValueInList(1, 4);
		checkRow(5);
		String number5 = getValueInList(5, 0);
		String name5 = getValueInList(5, 1);
		String hexValue5 = getValueInList(5, 2);
		String useTo5 = getValueInList(5, 3);
		String characteristicThing5 = getValueInList(5, 4);
		execute("List.orderBy", "property=number");
		checkRow(0);
		String number0 = getValueInList(0, 0);
		String name0 = getValueInList(0, 1);
		String hexValue0 = getValueInList(0, 2);
		String useTo0 = getValueInList(0, 3);
		String characteristicThing0 = getValueInList(0, 4);
		execute("Color.seeMessageSelected");
		assertMessage("(before) Rows of selected colors [0]");
		assertMessage("(after) Rows of selected colors [{number=" + number1 + "}][{number=" + number5 + "}][{number=" + number0 + "}]");
		
		execute("Print.generatePdf");
		assertContentTypeForPopup("application/pdf");
		assertPopupPDFLinesCount(7);
		assertPopupPDFLine(3, getPDFLine(number0, name0, hexValue0, useTo0, characteristicThing0));
		assertPopupPDFLine(4, getPDFLine(number5, name5, hexValue5, useTo5, characteristicThing5));
		assertPopupPDFLine(5, getPDFLine(number1, name1, hexValue1, useTo1, characteristicThing1));
	}
	
	private String getPDFLine(String number, String name, String hexValue, String useTo, String characteristicThing){
		String s = "";
		s += Is.empty(number) ? "" : number + " ";
		s += Is.empty(name) ? "" : name + " ";
		s += Is.empty(hexValue) ? "" : hexValue + " ";
		s += Is.empty(useTo) ? "" : useTo + " ";
		s += Is.empty(characteristicThing) ? "" : characteristicThing + " ";
		return s.trim();
	}
	
	public void testActionWithSelectedRowFromAnotherPage() throws Exception{
		checkRow(2);
		String number2 = getValueInList(2, 0);
		checkRow(6);
		String number6 = getValueInList(6, 0); 
		execute("List.goNextPage");
		checkRow(10);
		String number10 = getValueInList(0, 0);
		execute("List.goNextPage");
		execute("Color.seeMessageSelected");
		assertMessage("(before) Rows of selected colors [2][6][10]");
		assertMessage("(after) Rows of selected colors [{number=" + number2 + "}][{number=" + number6 + "}][{number=" + number10 + "}]");
		assertNoErrors();
	}
	
	public void testSelectedAllAndDeselectedAll() throws Exception {
		execute("List.orderBy", "property=number");
		assertLabelInList(1, "Name");
		assertTrue(getValueInList(0, 1).equals("ROJO"));
		checkAll();
		assertAllChecked();
		execute("List.orderBy", "property=number");
		assertFalse(getValueInList(0, 1).equals("ROJO"));
		assertAllUnchecked();
		execute("List.orderBy", "property=number");
		assertTrue(getValueInList(0, 1).equals("ROJO"));
		uncheckRow(0);
		uncheckRow(5);
		execute("List.orderBy", "property=number");
		assertFalse(getValueInList(0, 1).equals("ROJO"));
		assertAllUnchecked();
		checkAll();
		assertRowChecked(0);
		execute("List.orderBy", "property=number");
		assertRowUnchecked(0);
		assertRowUnchecked(5);
		checkAll();
		assertRowChecked(0);
		uncheckAll();
		assertRowUnchecked(0);
		execute("List.orderBy", "property=number");
		assertFalse(getValueInList(0, 1).equals("ROJO"));
		assertAllChecked();
	}
	
	/*
	 This test requires at least 6 pages (more than 50 elements) to work. 
	 When you did: select, change page, select, order, select and change page. It lost the selection 
	 */
	public void testSelectAndOrderWithALotOfElements() throws Exception { 
		execute("List.orderBy", "property=number");
		checkRow(0);
		checkRow(1);
		execute("List.goPage", "page=2");
		checkRow(12);
		checkRow(13);
		execute("List.goPage", "page=1");
		assertRowUnchecked(2);
		assertRowUnchecked(3);
		execute("List.orderBy", "property=number");
		assertRowUnchecked(0);
		assertRowUnchecked(1);
		assertRowUnchecked(2);
		assertRowUnchecked(3);
		execute("List.goPage", "page=2");
		assertRowUnchecked(10); 
		assertRowUnchecked(11);
		assertRowUnchecked(12);
		assertRowUnchecked(13);
		execute("List.goPage", "page=1");
		checkRow(4);
		execute("List.orderBy", "property=number");
		assertRowChecked(0);
		assertRowChecked(1);
		assertRowUnchecked(2);
		assertRowUnchecked(3);
		assertRowUnchecked(4);
		execute("List.goPage", "page=2");
		assertRowUnchecked(10);
		assertRowUnchecked(11);
		assertRowChecked(12);
		assertRowChecked(13);
		assertRowUnchecked(14);
		execute("List.orderBy", "property=number");
		assertRowUnchecked(10);
		assertRowUnchecked(11);
		assertRowUnchecked(12);
		assertRowUnchecked(13);
		assertRowUnchecked(14);
		execute("List.goPage", "page=1");
		assertRowUnchecked(0);
		assertRowUnchecked(1);
		assertRowUnchecked(2);
		assertRowUnchecked(3);
		assertRowChecked(4);
	}
	
	public void testNavigationByKeyZero() throws Exception {
		assertLabelInList(0, "Number");
		assertValueInList(0, 0, "0");
		assertValueInList(1, 0, "1");
		execute("List.viewDetail", "row=1");
		assertValue("number", "1");
		assertValue("name", "NEGRO");
		execute("Navigation.previous");
		assertValue("number", "0");
		assertValue("name", "ROJO");
		execute("Navigation.previous");
		assertError("We already are at the beginning of the list");
		assertValue("number", "0");
		assertValue("name", "ROJO");
	}
	
	public void testKeysWithZeroValue() throws Exception {
		assertValueInList(0, "number", "0");
		assertValueInList(0, "name", "ROJO");
		execute("Mode.detailAndFirst");
		assertNoErrors();
		assertValue("number", "0");
		assertValue("name", "ROJO");
		assertValue("sample", "RED");
	}		
	
	public void testMessageScapedWithQuotes() throws Exception{
		assertListNotEmpty();
		execute("List.viewDetail", "row=0");
		execute("Color.seeMessage");
		assertMessage("Message: A.B.C");
	}

	public void testIdentityCalculator() throws Exception {
		execute("CRUD.new");
		assertNoErrors(); 
		setValue("number", "-1"); // needed in this case because 0 is an existing key
		setValue("name", "JUNIT COLOR " + (int) (Math.random() * 200));
		execute("TypicalNotResetOnSave.save");
		assertNoErrors();						
		String last = getValue("number");
		
		execute("CRUD.new");
		assertNoErrors(); 
		setValue("number", "-1"); // needed in this case because 0 is an existing key
		setValue("name", "JUNIT COLOR " + (int) (Math.random() * 200));
		execute("TypicalNotResetOnSave.save");
		assertNoErrors();		
		String next = String.valueOf(Integer.parseInt(last) + 1);
		assertValue("number", next);		
	}
	
	public void testOptimisticConcurrency() throws Exception {
		// Must be called 2 times in order to fix some problems on second time
		modifyColorFromFirstUser(1);
		modifyColorFromFirstUser(2);
	}

	public void testFilterByNumberZero() throws Exception {
		setConditionValues(new String[] { "0" });
		execute("List.filter");
		assertListRowCount(1);
	}
	
	public void testFilterDescriptionsList_keyReferenceWithSameNameThatPropertyFather() throws Exception{
		changeModule("Color2");
		assertLabelInList(4, "Name of Used to");
		assertValueInList(0, 4, "CAR");
		setConditionValues(new String[] { "", "", "", "1"} );
		execute("List.filter");
		assertListNotEmpty();
	}
	
	public void modifyColorFromFirstUser(int id) throws Exception {		
		// First user
		execute("List.viewDetail", "row=2");		
		assertNotExists("version");
		setValue("name", "COLOR A" + id);
		
		// Second user, it's faster, he wins
		ColorTest otherSession = new ColorTest("Color2");
		otherSession.modifyColorFromSecondUser(id);
		
		// The first user continues		
		execute("TypicalNotResetOnSave.save");
		assertError("Impossible to execute Save action: Another user has modified this record");
		execute("Mode.list");		
		assertValueInList(2, "name", "COLOR B" + id); // The second user won
	}
	
	private void modifyColorFromSecondUser(int id) throws Exception {
		setUp();
		execute("List.viewDetail", "row=2");
		setValue("name", "COLOR B" + id);
		execute("TypicalNotResetOnSave.save");
		assertNoErrors();		
		tearDown();
	}	
	
	public void testFilterDescriptionsList_forTabsAndNotForTabs() throws Exception{
		try{
			CharacteristicThing.findByNumber(2);	
		}
		catch(NoResultException ex){
			fail("It must to exist");
		}
		
		// Color: 'usedTo' without descriptionsList and 'characteristicThing' without descriptionsList
		assertLabelInList(4, "Name of Used to");
		assertLabelInList(5, "Description of Characteristic thing");
		assertValueInList(0, 4, "CAR");
		assertValueInList(0, 5, "3 PLACES");
		setConditionValues(new String[] { "", "", "", "CAR", "3 PLACES" } );
		execute("List.filter");
		assertNoErrors();
		assertListRowCount(1);
		
		// Color2: 'usedTo' with descriptionsList and 'characteristicThing' with descriptionsList and condition
		changeModule("Color2");
		assertLabelInList(4, "Name of Used to");
		assertLabelInList(5, "Description of Characteristic thing");
		assertValueInList(0, 4, "CAR");
		assertValueInList(0, 5, "3 PLACES");
		setConditionValues(new String[] { "", "", "", "1", "0" } );
		execute("List.filter");
		assertNoErrors();
		assertListRowCount(1);

		try{
			setConditionValues(new String[] { "", "", "", "", "2"} );	// descriptionsList has a condition: number < 2
		}
		catch(IllegalArgumentException ex){
			assertTrue(ex.getMessage().equals("No option found with value: 2"));
		}
	}
	
	public void testShowActionOnlyInEachRow() throws Exception{
		// confirmMessage with row
		String html = getHtml();
		assertTrue(html.contains("Delete record on row 2: Are you sure?"));
		
		// action with mode=NONE: it display only in each row
		assertAction("CRUD.deleteRow");
		setConditionValues(new String[] { "", "ZZZZZ"});
		execute("List.filter");
		assertListRowCount(0);
		assertNoAction("CRUD.deleteRow");
	}
	
	public void testIgnoreAccentsForStringArgumentsInTheFilter() throws Exception{ 
		// create record with name 'marrón'
		execute("CRUD.new");
		setValue("name", "marrón");
		execute("TypicalNotResetOnSave.save");
		assertNoErrors();
		
		// filter by 'marron'
		execute("Mode.list");
		setConditionValues("", "marron");
		execute("List.filter");
		assertListRowCount(1);
		assertValueInList(0, 1, "MARRÓN");
		
		// delete
		checkAll();
		execute("CRUD.deleteSelected");
		assertNoErrors();
		assertListRowCount(0);
	}
	
	public void testChangeModelNameInConditions() throws Exception{ 
		execute("CRUD.new");
		assertNoErrors();
		assertExists("anotherCT.number");
		assertValidValuesCount("anotherCT.number", 3); 
		String [][] validValues = { 
			{ "", "" },
			{ "0", "3 PLACES" },
			{ "1", "5 PLACES" }
		};
		assertValidValues("anotherCT.number", validValues);
	}
	
	public void testDescriptionsListWithMultipleKeyAndOneValueInBlank() throws Exception{
		execute("List.viewDetail", "row=0");
		assertExists("mixture.KEY");
		String [][] validValues = { 
			{ "", "" },
			{ "[.          .VERDE     .]", "----------&-----VERDE:complicated" },
			{ "[.ROJO      .          .]", "------ROJO&----------:simple" }
		};
		assertValidValues("mixture.KEY", validValues);
		
		setValue("mixture.KEY", "[.          .VERDE     .]");
		execute("TypicalNotResetOnSave.save");
		assertNoErrors();
		assertMessage("Color modified successfully");
		assertValue("mixture.KEY", "[.          .VERDE     .]");
		
		setValue("mixture.KEY", "");
		execute("TypicalNotResetOnSave.save");
		assertNoErrors();
		assertMessage("Color modified successfully");
		assertValue("mixture.KEY", "");
	}
	
	public void testFilterNotContains() throws Exception{
		assertLabelInList(1, "Name");
		assertLabelInList(5, "Description of Characteristic thing");
		setConditionValues("", "", "", "", "3 places");
		execute("List.filter");
		assertListRowCount(1);
		assertValueInList(0, 1, "ROJO");
		
		setConditionComparators("=", "not_contains_comparator", "starts_comparator", "starts_comparator", "contains_comparator");
		setConditionValues("", "ROJO", "", "", "");
		execute("List.filter");
		assertListNotEmpty();
		
		setConditionComparators("=", "not_contains_comparator", "starts_comparator", "starts_comparator", "contains_comparator");
		setConditionValues("", "ROJO", "", "", "3 places");
		execute("List.filter");
		assertListRowCount(0);
	}
	
}