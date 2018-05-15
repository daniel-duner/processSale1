package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.Item;

public interface FindItemStrategy {
	public Item findItem(int itemId, Item[] inventory);
}
