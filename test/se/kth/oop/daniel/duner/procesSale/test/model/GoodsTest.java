package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.Test;

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
	public void addItemTest() throws Exception {
		Goods goods = new Goods();
		
		
	}

}
