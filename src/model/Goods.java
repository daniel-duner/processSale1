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

	public Goods(String currency) throws Exception {
		price = new Amount(0, currency);
	}

	public void addItem(Item item) throws Exception {
		
		if (itemAlreadyInGoods(item) == true) {
			quantity[searchItem(item)]++;
		} else {
			Item[] newItems = new Item[items.length + 1];
			int[] newQuantity = new int[quantity.length + 1];
			newItems[newItems.length - 1] = item;
			newQuantity[newQuantity.length - 1]++;
			for (int i = 0; i < items.length - 1; i++) {
				newItems[i] = items[i];
				newQuantity[i] = quantity[i];
			}
			items = newItems;
			quantity = newQuantity;
			increasePrice(item);
		}
	}
	
	public String toString(){
		StringBuilder listOfItems = new StringBuilder();
		for(int i = 0; i < items.length;i++) {
			listOfItems.append(i + ". "+ "QTY[" +quantity[i] + "] - " + items[i].getName() + " - Price ea. " + items[i].getPrice().getAmount() +":-"+ "\n");
		}
		listOfItems.append("Total Cost exl. VAT and discounts: " + price.getAmount() +":-");
		return listOfItems.toString();
	}

	private void increasePrice(Item item) throws Exception {
		Amount newAmount = new Amount(price, item.getPrice(), '+');
		price = newAmount;
	}

	private boolean itemAlreadyInGoods(Item item) {
		if (searchItem(item) == doesNotExist) {
			return false;
		} else {
			return true;
		}
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
