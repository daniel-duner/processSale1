package model;

import integration.Amount;
import integration.Item;

/**
 * Contains all the items the customer wants to buy during a sale, it will
 * update when an item is registered to the sale.
 * 
 * @author danielduner
 *
 */

public class Goods {
	private Item[] items;
	private int[] quantity;
	private Amount price;
	private final int doesNotExist = -1;
	private int empty = 0;

	/**
	 * Instantiates goods
	 * 
	 * @throws Exception
	 */
	public Goods() throws Exception {
		price = new Amount(0);
		quantity = new int[empty];
		items = new Item[empty];
	}

	/**
	 * adds an item to the goods
	 * 
	 * @param item represents the item that caller wants to add to goods
	 * @throws Exception
	 */
	public void addItem(Item item) throws Exception {

		boolean itemExists = item.getItemValid();
		if (itemExists) {
			if (items.length == empty) {
				items = new Item[1];
				quantity = new int[1];	
				items[0] = item;
				quantity[0] = 1;
				increasePrice(item);
			} else if (itemAlreadyInGoods(item)) {
				quantity[this.searchItemIndexNo(item)]++;
				increasePrice(item);
			} else {
				Item[] newItems = new Item[items.length + 1];
				int[] newQuantity = new int[quantity.length + 1];
				for (int i = 0; i < newItems.length - 1; i++) {
					newItems[i] = items[i];
					newQuantity[i] = quantity[i];
				}
				newItems[newItems.length - 1] = item;
				newQuantity[newQuantity.length - 1] = +1;
				items = newItems;
				quantity = newQuantity;
				increasePrice(item);
			}
		}
	}

/**
 * 
 * Format of the object when presented as string
 * 
 */
	public String toString() {
		StringBuilder listOfItems = new StringBuilder();
		for (int i = 0; i < items.length; i++) {
			int orderIndexNo = i + 1;
			listOfItems.append(orderIndexNo + ". " + items[i].getName() + " - " + "QTY[" + quantity[i] + "]"
					+ " - Price ea. " + items[i].getPrice() + "\n");
		}
		listOfItems.append("Total Cost exl. discounts and VAT: " + price);
		return listOfItems.toString();
	}
/**
 * Adds the price of the item to the total price of the goods
 * @param item represents the item which is added to a sale
 * @throws Exception
 */
	private void increasePrice(Item item) throws Exception {
		Amount newAmount = new Amount(price, item.getPrice(), '+');
		price = newAmount;
	}
/**
 * 
 * Checks if an item with same id already has been added to the goods
 * 
 * @param item represents the item that caller wants to check isn't already in the goods
 * @return returns true if the item already exists in the goods
 */
	private boolean itemAlreadyInGoods(Item item) {
		if (this.searchItemIndexNo(item) == doesNotExist) {
			return false;
		} else {
			return true;
		}
	}
/**
 * 
 * Searches after an item in the goods and returns it's position in the list if it exist
 * 
 * @param item represents the item which caller is looking for
 * @return returns the index of the position the item searched 
 * or returns doesNotExist if it's not in the list.
 */
	private int searchItemIndexNo(Item item) {
		int indexNo = 0;
		for (int i = 0; i < items.length; i++) {
			if (item.getItemId() == items[i].getItemId()) {
				indexNo = i;
				return indexNo;
			}
		}
		return doesNotExist;
	}

	
	public Item[] getItems() {
		return items;
	}

	public int[] getQuantity() {
		return quantity;
	}

	public Amount getPrice() {
		return price;
	}

}
