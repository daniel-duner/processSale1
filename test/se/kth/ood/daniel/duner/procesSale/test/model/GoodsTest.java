package se.kth.ood.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.Goods;
import se.kth.ood.daniel.duner.procesSale.model.Item;

public class GoodsTest {
	private Item item1;
	private Item item2;
	private Goods goods; 
	@Before
	public void setUp() throws Exception {
		item1 = new Item(1101, new Amount(1), "description", "name");
		item2 = new Item(1102, new Amount(1), "description", "name");
		item1.setItemExistTrue();
		item2.setItemExistTrue();
		goods = new Goods();
	}
	
	@After
	public void tearDown() {
		item1 = null;
		item2 = null;
		goods = null;
	}

	@Test
	public void testObjectAttributesNotNull() throws Exception {
		Goods goods = new Goods();
		assertNotNull("Verify that goods NOT NULL", goods.getQuantity());
		assertNotNull("Verify that goods NOT NULL", goods.getItems());
		assertNotNull("Verify that goods NOT NULL", goods.getPrice());
	}
	@Test
	public void testCorrectValuesOnInstantiation() throws Exception {
		Goods goods = new Goods();
		Amount price = new Amount(0);
		int[] quantity = new int[0];
		Item[] items = new Item[0];
		double delta = price.getAmount()-goods.getPrice().getAmount();
		assertEquals("Verifies correct value of price",price.getAmount(),goods.getPrice().getAmount(),delta);
		assertEquals("Verifies correct length of quantity", quantity.length, goods.getQuantity().length);
		assertEquals("Verifies correct length of items",items.length,goods.getItems().length);
	}
	
	@Test
	public void addItemToEmptyArrayTest() throws Exception {
		goods = new Goods();
		goods.addItem(item1);
		assertTrue("Item should have been added to goods",goods.getItems()[0].getItemId() == 1101);

	}
	@Test
	public void addItemToArrayWithItemInItTest() throws Exception {
		Goods goods = new Goods();
		goods.addItem(item1);
		goods.addItem(item2);
		assertTrue("Item should be added and Item Id should be 1101 on the first position",goods.getItems()[0].getItemId() == 1101);
		assertTrue("Item should be added and Item Id should be 1102 id on the second position",goods.getItems()[1].getItemId() == 1102);

	}
	
	@Test
	public void addItemToArrayWithItemOfSameIdInItTest() throws Exception {
		goods.addItem(item1);
		goods.addItem(item1);
		assertTrue("Quantity should be 2",goods.getQuantity()[0] == 2);
		assertTrue("length of itemArray should be 1",goods.getItems().length == 1);
	}

	@Test
	public void toStringTest() throws Exception {
		goods.addItem(item1);
		String expResult = "1. name - QTY[1] - Price ea. SEK 1,00:-\nTotal Cost exl. discounts and VAT: SEK 1,00:-";
		String result = goods.toString();
		assertEquals("Strings should be equal",expResult, result);
	}
}
