package se.kth.oop.daniel.duner.procesSale.test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import integration.Amount;
import integration.Item;

public class ItemTest {

	@Test
	public void objectNotNullTest() throws Exception {
		Item  itemCreatedWithNoArgument = new Item();
		Item  itemCreatedWithItemId = new Item(1101);
		Item  itemCreatedWithAllAttributes = new Item(1101,new Amount(0), "Description", "name");
		
		assertNotNull("Verify that item is NOT NULL", itemCreatedWithNoArgument);
		assertNotNull("Verify that item is NOT NULL", itemCreatedWithItemId );
		assertNotNull("Verify that item is NOT NULL", itemCreatedWithAllAttributes);
	}
	
	@Test
	public void testToStringCorrect() throws Exception {
	Item  item = new Item(1101,new Amount(0), "Description", "name");	
	String result =  item.toString();
	String expResult = "name\n1101\nSEK 0,00:-\nDescription\n";
	
	assertEquals("Verify String is correct",expResult, result);
	}


}
