package model;

import integration.Item;

public class SaleInformation {
	private Amount runningTotal;
	private Item item;
	private boolean itemValid;
	private int quantity;

	public SaleInformation(){
		runningTotal = null;
		item = null;
		itemValid = false;
		quantity = 0;
	}

	public void updateSaleInformation(Goods goods, Item item) throws Exception {
		this.runningTotal = new Amount(goods.getPrice().getAmount());
		this.item = item;
		this.itemValid = item.getItemValid();
		this.quantity = 1;
	}
	public void updateSaleInformation(Goods goods, Item item, int quantity) throws Exception {
		this.runningTotal = new Amount(goods.getPrice().getAmount());
		this.item = item;
		this.itemValid = item.getItemValid();
		this.quantity = quantity;
	}

	public Amount getRunningTotal() {
		return runningTotal;
	}

	public boolean getItemValid() {
		return itemValid;
	}
	public Item getItem() {
		return item;
	}
	public int getQuantity() {
		return quantity;
	}
}
