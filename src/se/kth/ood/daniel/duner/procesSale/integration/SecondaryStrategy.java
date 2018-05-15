package se.kth.ood.daniel.duner.procesSale.integration;

import se.kth.ood.daniel.duner.procesSale.model.Item;
/**
 * The secondary algorithm that the <InventorySystemHandler> can use in it's  method 
 * @author danielduner
 *
 */
public class SecondaryStrategy implements FindItemStrategy {
	/**
	 * Instantiates the SecondaryStrategy
	 */
	public SecondaryStrategy() {
		
	}
	/**
	 * The Secondary method used when searching for an item in the inventory in <InventorySystemHandler>
	 */
	@Override
	public Item findItem(int itemId, Item[] inventory) {
		System.out.println("Secondary Strategy is now used for search");
		for(int i = 0; i<inventory.length;i++) {
			if (itemId == inventory[i].getItemId()) {
				return inventory[i];
			}
		}
		return null;
	}

}
