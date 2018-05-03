package database;

import integration.Amount;
import integration.Item;
import model.Goods;
import model.SaleDTO;

/**
 * Represents the printer system that prints out receipts
 * 
 * @author danielduner
 *
 */

public class InventorySystem {
	private Item[] inventory;
	private int[] quantities;
	private boolean itemFound;

	/**
	 * Instantiates the InventorySystem
	 * 
	 * @throws Exception
	 */
	public InventorySystem() throws Exception {
		inventory = new Item[5];
		inventory[0] = new Item(1101, new Amount(130), "Blå T-shirt av märket X", "T-shirt");
		inventory[1] = new Item(1102, new Amount(20), "Blyertspenna med 0.5 cm stift", "Blyertspenna");
		inventory[2] = new Item(1103, new Amount(179), "Genre Deckare, skriven av Anders Svensson", "Anders Resor");
		inventory[3] = new Item(1104, new Amount(1099), "Röd mountaincykel av märket X", "Mountainbike BMX26");
		inventory[4] = new Item(1105, new Amount(8799), "16 GGB Ram, 512 GB SSD-Hårddisk, 13\' skärm", "Bärbar Dator");
		quantities = new int[5];
		quantities[0] = 3;
		quantities[1] = 3;
		quantities[2] = 3;
		quantities[3] = 3;
		quantities[4] = 3;
	}
	/**
	 * returns the inventory
	 * @return the array containing the inventory
	 */
	public Item[] getInventory() {
		return inventory;
	}
/**
 * Updates the inventory with the information about sold items
 * @param saleDTO contains information about the sold items
 */
	public void updateInventory(SaleDTO saleDTO) {
		Item[] soldItems = saleDTO.getGoods().getItems();
		int[] quantitySold = saleDTO.getGoods().getQuantity();

		for (int i = 0; i < soldItems.length; i++) {
			int indexNoInInventory = getItemIndexNo(soldItems[i]);
			quantities[indexNoInInventory]=-quantitySold[i];
		}
	}
	
	/**
	 * 
	 * Searches after the item in the inventory and returns an Item either empty if it doesn't
	 * exist else it will return an empty item
	 * 
	 * @param itemId item ID of the searched item
	 * @return returns either the found item or an empty item declared that it doesn't exist
	 * @throws Exception
	 */

	public Item findItem(int itemId) throws Exception {
		Item searchedItem = new Item(itemId);
		int foundItemIndex = (getItemIndexNo(searchedItem));
		if (itemFound) {
			Item foundItem = inventory[foundItemIndex];
			foundItem.setItemExistTrue();
			return foundItem;
		} else {
			Item itemNotFound = searchedItem;
			itemNotFound.setItemExistFalse();
			return itemNotFound;
		}
	}

/**
 *	Fetches and items position in the array, if item doesn't exist it will return that
 *	set itemFound
 * @param item represent the searched item
 * @return returns the position and if the item is found or not
 */
	private int getItemIndexNo(Item item) {
		int searchedIndexNo = item.getItemId();
		int indexNoNotFound = -1;
		for (int i = 0; i < inventory.length; i++) {
			if (searchedIndexNo == inventory[i].getItemId()) {
				int foundItemIndex = i;
				itemFound = true;
				return foundItemIndex;
			}
		}
		itemFound = false;
		return indexNoNotFound;
	}
}
