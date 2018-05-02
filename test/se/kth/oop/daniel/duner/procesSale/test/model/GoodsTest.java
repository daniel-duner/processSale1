package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import integration.Item;
import model.Amount;
import model.Goods;

public class GoodsTest {

	@Test
	public void objectNotNullTest() throws Exception {
		Goods goods = new Goods();
		assertNotNull("Verify that goods NOT NULL", goods.getQuantity());
		assertNotNull("Verify that goods NOT NULL", goods.getItems());
		assertNotNull("Verify that goods NOT NULL", goods.getPrice());
	}
	
	@Test
	public void addItemToEmptyArrayTest() throws Exception {
		Item item = new Item(1101, new Amount(1), "description", "name");
		Goods goods = new Goods();
		goods.addItem(item);
		int expResult = item.getItemId();
		int actResult = goods.getItems()[0].getItemId(); 
		
		assertFalse("Verify NOT NULL",expResult == actResult);
		
		
	}

}
