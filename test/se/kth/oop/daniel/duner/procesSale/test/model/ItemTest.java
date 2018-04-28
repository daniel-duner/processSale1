package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import integration.Item;
import model.Amount;

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

}
