package database;

import integration.Item;
import model.Amount;
import model.Goods;
import model.SaleDTO;

public class Inventory {
	private Item[] inventory;
	private int[] quantities;
	private boolean itemFound;

	public Inventory() throws Exception {
		inventory = new Item[5];
		inventory[0] = new Item(1101, new Amount(130), "Blå T-shirt av märket X", "T-shirt");
		inventory[1] = new Item(1102, new Amount(20), "Blyertspenna med 0.5 cm stift", "Blyertspenna");
		inventory[2] = new Item(1103, new Amount(179), "Genre Deckare, skriven av Anders Svensson",
				"Anders Resor");
		inventory[3] = new Item(1104, new Amount(1099), "Röd mountaincykel av märket X", "Mountainbike BMX26");
		inventory[4] = new Item(1105, new Amount(8799), "16 GGB Ram, 512 GB SSD-Hårddisk, 13\' skärm",
				"Bärbar Dator");
	}

	public Item[] getInventory() {
		return inventory;
	}

	public void updateInventory(SaleDTO saleDTO) {
		Item[] soldItems = saleDTO.getGoods().getItems();
		int[] quantitySold = saleDTO.getGoods().getQuantity();
		
		for (int i = 0; i < soldItems.length; i++) {
			quantities[searchItem(soldItems[i])] = -quantitySold[i];
		}
	}
	
	public Item findItem(int itemId) throws Exception {
		Item searchedItem = new Item(itemId);
		int foundItemIndex = (searchItem(searchedItem));
		if(itemFound) {
			Item foundItem = inventory[foundItemIndex];
			foundItem.setItemExistTrue();
			return foundItem;
		} 
		else {
			Item itemNotFound = searchedItem;
			itemNotFound.setItemExistFalse();
			return itemNotFound;
		}
		
		
		
	}

	private int searchItem(Item item) {
		int searchedItem = item.getItemId();
		int itemNotFound = -1;
		for (int i = 0; i < inventory.length; i++) {
			if (searchedItem == inventory[i].getItemId()) {
				int foundItemIndex = i;
				itemFound = true;
				return foundItemIndex;
			}
		}
		itemFound = false;
		return itemNotFound;
	}
}
