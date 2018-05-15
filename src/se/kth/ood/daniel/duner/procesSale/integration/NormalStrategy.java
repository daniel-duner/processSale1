package se.kth.ood.daniel.duner.procesSale.integration;

import se.kth.ood.daniel.duner.procesSale.model.Item;

public class NormalStrategy implements FindItemStrategy {
	
	public NormalStrategy() {
		
	}
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