package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.Item;
import se.kth.ood.daniel.duner.procesSale.model.SaleDTO;

/**
 * Represents the system that handles the database containing the inventory
 * 
 * @author danielduner
 *
 */

public class InventorySystemHandler {
	private Item[] inventory;
	private int[] quantities;

	/**
	 * Instantiates the InventorySystem
	 * 
	 * @throws Exception
	 */
	public InventorySystemHandler() throws Exception {
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
	 * returns the quantities
	 * @return the array containing the quantities
	 */
	public int[] getQuantity() {
		return quantities;
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
			quantities[indexNoInInventory]=quantities[indexNoInInventory]-quantitySold[i];
		}
	}
	
	/**
	 * Searches after the item in the inventory and returns an Item either empty if it doesn't
	 * exist else it will return an empty item
	 * @param itemId item ID of the searched item
	 * @return returns either the found item or an empty item declared that it doesn't exist
	 * @throws FailedToConnectException 
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 * @throws Exception
	 */
	public Item findItem(int itemId) throws ItemNotFoundException, FailedToConnectException, FileNotFoundException, UnsupportedEncodingException {
		if(itemId == 1111){
			throw new FailedToConnectException("Database failure", itemId);	
		}else if(checkIfItemExists(itemId))
		for (Item item : inventory) {
			if (itemId == item.getItemId()) {
				return item;
			}
		}
		else {
			throw new ItemNotFoundException(itemId);
		}
		return null;
	}

/**
 * Checks if an item with the same item Id exists in the inventory
 * @param searchedItemId represents the searched item id
 * @return returns true if the item exists or false if it doesn't
 * @throws FailedToConnectException 
 * @throws UnsupportedEncodingException 
 * @throws FileNotFoundException 
 */
	private boolean checkIfItemExists(int searchedItemId) throws FailedToConnectException, FileNotFoundException, UnsupportedEncodingException {
		for (Item item : inventory) {
			if (searchedItemId == item.getItemId()) {
				return true;
			}
		}
		return false;
	}

/**
 * Fetches an items position in the inventory
 * @param searchedItem represents the searched item
 * @return an items position in the inventory
 */
	private int getItemIndexNo(Item searchedItem) {
		int searchedIndexNo = 0;
		int currentIndex = 0;
		for (Item item : inventory) {
			if (searchedItem == item) {
				searchedIndexNo = currentIndex;
			}
			currentIndex++;
		}
		return searchedIndexNo;

	}
}


