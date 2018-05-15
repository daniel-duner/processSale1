package se.kth.ood.daniel.duner.procesSale.integration;

import se.kth.ood.daniel.duner.procesSale.model.Item;
/**
 * The Normal algorithm that the <InventorySystemHandler> can use in it's  method 
 * @author danielduner
 *
 */
public class NormalStrategy implements FindItemStrategy {
	/**
	 * Instantiates the NormalStrategy
	 */
	public NormalStrategy() {
		
	}
	
	/**
	 * The Normal method used when searching for an item in the inventory in <InventorySystemHandler>
	 */
	@Override
	public Item findItem(int itemId, Item[] inventory) {
		System.out.println("Normal Strategy is now used for search");
		for (Item item : inventory) {
			if (itemId == item.getItemId()) {
				return item;
			}
		}
		return null;

	}
}