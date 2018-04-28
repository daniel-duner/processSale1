package model;

import exceptions.InvalidAmountException;
import exceptions.InvalidStringException;
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

	public Goods() throws Exception {
		price = new Amount(0);
		quantity = new int[0];
		items = new Item[0];
	}

	public void addItem(Item item) throws Exception {
		int empty = 0;
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
				newItems[newItems.length-1] = item;
				newQuantity[newQuantity.length-1]=+1;
				items = newItems;
				quantity = newQuantity;
				increasePrice(item);
			}
		}
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

	public String toString() {
		StringBuilder listOfItems = new StringBuilder();
		for (int i = 0; i < items.length; i++) {
			listOfItems.append(i + ". " + "QTY[" + quantity[i] + "] - " + items[i].getName() + " - Price ea. "
					+ items[i].getPrice().getAmount() + ":-" + "\n");
		}
		listOfItems.append("Total Cost exl. discounts and VAT: " + price.getAmount() + ":-");
		return listOfItems.toString();
	}

	private void increasePrice(Item item) throws Exception {
		Amount newAmount = new Amount(price, item.getPrice(), '+');
		price = newAmount;
	}

	private boolean itemAlreadyInGoods(Item item) {
		if (this.searchItem(item) == doesNotExist) {
			return false;
		} else {
			return true;
		}
	}
	private int searchItemIndexNo(Item item) {
		int indexNo = 0;
		for (int i = 0; i < items.length; i++) {
			if (item.getItemId() == items[i].getItemId()) {
				indexNo = i;
				return indexNo;
			}
		}
		return indexNo;
	}
	private int searchItem(Item item) {
		for (int i = 0; i < items.length; i++) {
			if (item.getItemId() == items[i].getItemId()) {
				int indexNo = i;
				return indexNo;
			}
		}
		return doesNotExist;
	}

}
