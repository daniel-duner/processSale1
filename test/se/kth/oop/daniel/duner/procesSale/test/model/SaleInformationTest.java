package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.model.Amount;
import se.kth.oop.daniel.duner.procesSale.model.Goods;
import se.kth.oop.daniel.duner.procesSale.model.Item;
import se.kth.oop.daniel.duner.procesSale.model.SaleInformation;

public class SaleInformationTest {
	private SaleInformation saleInf;
	private Goods goods;
	private Item item;
	@Before
	public void setUp() throws Exception {
		saleInf = new SaleInformation();
		goods = new Goods();
		item = new Item(1101,new Amount(0), "description", "name");
		item.setItemExistTrue();
	}

	@After
	public void tearDown() throws Exception {
		saleInf = null;
	}

	@Test
	public void testInstantiatedCorrectly() {
		assertTrue("running Total not created correctly",saleInf.getRunningTotal() == null);
		assertTrue("item not set to null on instantiation",saleInf.getItem() == null);
		assertTrue("itemValid not set to false on instantiation",saleInf.getItemValid() == false);
		assertTrue("quantity not set to 0 on instantiation",saleInf.getQuantity() == 0);
		assertTrue("noOnList not set to 0 on instantiation",saleInf.getNoOnList() == 0);
	}
	@Test
	public void testUpdateSaleInformation() throws Exception {
		saleInf.updateSaleInformation(goods, item);
		assertTrue("quantity not set to 1", saleInf.getQuantity() == 1);
		assertTrue("item Id not correctly added", saleInf.getItem().getItemId() == 1101);
	}
	@Test
	public void testUpdateSaleInformationWithMultipleItems() throws Exception {
		saleInf.updateSaleInformation(goods, item, 2);
		assertTrue("quantity not set to 2", saleInf.getQuantity() == 2);
		assertTrue("itemId not correctly added", saleInf.getItem().getItemId() == 1101);
	}
	@Test
	public void testUpdateSaleInformationItemInvalid() throws Exception {
		item.setItemExistFalse();
		saleInf.updateSaleInformation(goods, item);
		assertTrue("noOnList should be 0",saleInf.getNoOnList() == 0);
	}
	

}
