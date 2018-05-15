package se.kth.ood.daniel.duner.procesSale.integration;

import se.kth.ood.daniel.duner.procesSale.model.Item;

public class SecondaryStrategy implements FindItemStrategy {
	
	public SecondaryStrategy() {
		
	}
	
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
