package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import se.kth.ood.daniel.duner.procesSale.integration.ItemNotFoundException;

/**
 * Handles and contains information about a sale that is needed during a sale
 * process
 * 
 * @author danielduner
 *
 */

public class SaleInformation {
	private Amount runningTotal;
	private Item item;
	private int quantity;
	private int noOnList;
	private final int singleItem = 1;
	

	/**
	 * Instantiates a saleInformation
	 */
	public SaleInformation() {
		runningTotal = null;
		item = null;
		quantity = 0;
		noOnList = 0;
		
	}

	/**
	 * updates the sale information
	 * 
	 * @param goods represents the goods at a certain time
	 * @param item represents the item that most recently was added to the sale
	 * @throws Exception
	 */
	public void updateSaleInformation(Goods goods, Item item) throws InvalidStringException, InvalidAmountException, 
	FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		this.updateInformation(goods, item);
		this.quantity = singleItem;
	}

	/**
	 * updates the sale information when more than one item is added to the sale
	 * 
	 * @param goods represents the goods at a certain time
	 * @param item represents the item that most recently was added to the sale
	 * @param quantity represents the quantity added of the item
	 * @throws Exception
	 */

	public void updateSaleInformation(Goods goods, Item item, int quantity) throws InvalidStringException, InvalidAmountException, 
	FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		this.updateInformation(goods, item);
		this.quantity = quantity;
	}

	public int getNoOnList() {
		return noOnList;
	}

	public Amount getRunningTotal() {
		return runningTotal;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	private void updateInformation(Goods goods, Item item) throws InvalidStringException, InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		runningTotal = new Amount(goods.getPrice().getAmount());
		this.item = item;
			noOnList++;
	}

}
