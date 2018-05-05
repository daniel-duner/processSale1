package se.kth.ood.daniel.duner.procesSale.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.Item;
import se.kth.ood.daniel.duner.procesSale.model.Sale;
import se.kth.ood.daniel.duner.procesSale.model.SaleDTO;

public class InventorySystemHandlerTest {
	private InventorySystemHandler invSys;
	private Sale sale;
	private Sale sale2;
	private Item item;
	private SaleDTO saleDTO;
	private SaleDTO saleDTO2;
	@Before
	public void setUp() throws Exception {
		sale = new Sale(1);
		sale2 = new Sale(2);
		item = new Item(1101, new Amount(2), "description", "name");
		item.setItemExistTrue();
		sale.addMultipleItems(item, 3);
		saleDTO = new SaleDTO(sale);
		saleDTO2 = new SaleDTO(sale2);
		invSys = new InventorySystemHandler();
	}

	@After
	public void tearDown() throws Exception {
		sale = null;
		sale2 = null;
		item = null;
		saleDTO = null;
		saleDTO2 = null;
		invSys = null;
	}

	@Test
	public void testUpdateInventoryQuantites() throws Exception {
		invSys = new InventorySystemHandler();
		invSys.updateInventory(saleDTO);
		assertTrue("Quantity should be 0",invSys.getQuantity()[0] == 0);
	}
	@Test
	public void testFindItemsCorrect() throws Exception {
		int itemId = 1102;
		assertEquals("Does not find the correct item","Blyertspenna", invSys.findItem(itemId).getName());
	}
	@Test
	public void testFindItemsIncorrect() throws Exception {
		int itemId = 1106;
		assertFalse("Does not find the correct item",invSys.findItem(itemId).getItemValid());
	}
	

}
