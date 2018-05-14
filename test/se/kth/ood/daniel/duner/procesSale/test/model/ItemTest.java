package se.kth.ood.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.Item;

public class ItemTest {
	private Item testItem;
	@Before
	public void setUp() throws Exception {
		testItem = new Item(1101,new Amount(0), "description", "name");
	}
	@After
	public void tearDown() {
		testItem = null;
		
	}

	@Test
	public void itemCreatedWithNoArgumentTest() throws Exception {
		Item  itemCreatedWithNoArgument = new Item();
		assertNotNull("Verify that item is NOT NULL", itemCreatedWithNoArgument);
	}

	@Test
	public void itemCreatedWithItemIdTest() throws Exception {
		Item  itemCreatedWithItemId = new Item(1101);
		assertNotNull("Verify that item is NOT NULL", itemCreatedWithItemId );
	}
	@Test
	public void itemCreatedWithAllAttributes() throws Exception {
		Item  itemCreatedWithAllAttributes = new Item(1101,new Amount(0), "Description", "name");
		assertNotNull("Verify that item is NOT NULL", itemCreatedWithAllAttributes);
	}
	
	@Test
	public void testToStringCorrect() throws Exception {
	Item  item = new Item(1101,new Amount(0), "description", "name");	
	String result =  item.toString();
	String expResult = "name\n1101\nSEK 0,00:-\ndescription\n";
	
	assertEquals("Verify String is correct",expResult, result);
	}

	@Test
	public void testGetters() {
		assertEquals("Description is not transfered correctly","description", testItem.getItemDescription());
		assertEquals("Item Id is not transfered correctly",1101, testItem.getItemId());
		assertEquals("Price is not transfered correctly",0, testItem.getPrice().getAmount(),0);
		assertEquals("Name is not transfered correctly","name", testItem.getName());
	}
	

}
