package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import integration.Amount;
import integration.Item;
import model.Goods;

public class GoodsTest {

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
		double delta = 0.000001;
		assertEquals("Verifies correct value of price",price.getAmount(),goods.getPrice().getAmount(),delta);
		assertEquals("Verifies correct length of quantity", quantity.length, goods.getQuantity().length);
		assertEquals("Verifies correct length of items",items.length,goods.getItems().length);
	}
	
	@Test
	public void addItemToEmptyArrayTest() throws Exception {
		Item item = new Item(1101, new Amount(1), "description", "name");
		item.setItemExistTrue();
		Goods goods = new Goods();
		boolean result = false;
		goods.addItem(item);
		if (goods.getItems()[0].getItemId() == 1101) {	
			result = true;
		}
		assertTrue("Item should have been added to goods",result);

	}
	@Test
	public void addItemToArrayWithItemInItTest() throws Exception {
		Item item1 = new Item(1101, new Amount(1), "description", "name");
		Item item2 = new Item(1102, new Amount(1), "description", "name");
		item1.setItemExistTrue();
		item2.setItemExistTrue();
		Goods goods = new Goods();
		goods.addItem(item1);
		boolean result = false;
		goods.addItem(item2);
		if (goods.getItems()[0].getItemId() == 1101 && goods.getItems()[1].getItemId() == 1102) {	
			result = true;
		}
		assertTrue("Item should be added and Item Id 1101 on first item in array and 1102 on second",result);

	}
	
	@Test
	public void addItemToArrayWithItemOfSameIdInItTest() throws Exception {
		Item item1 = new Item(1101, new Amount(1), "description", "name");
		Item item2 = new Item(1101, new Amount(1), "description", "name");
		item1.setItemExistTrue();
		item2.setItemExistTrue();
		Goods goods = new Goods();
		goods.addItem(item1);
		boolean result = false;
		goods.addItem(item2);
		if (goods.getItems().length == 1 && goods.getQuantity()[0] == 2) {	
			result = true;
		}
		assertTrue("Quantity should be 2 and length of itemArray should be 1",result);
	}

	@Test
	public void toStringTest() throws Exception {
		Item item1 = new Item(1101, new Amount(1), "description", "name");
		item1.setItemExistTrue();
		Goods goods = new Goods();
		goods.addItem(item1);
		String expResult = "1. name - QTY[1] - Price ea. SEK 1,00:-\nTotal Cost exl. discounts and VAT: SEK 1,00:-";
		String result = goods.toString();
		assertEquals("Strings should be equal",expResult, result);
	}

}
