package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.Item;
/**
 * The Interface is to be implemented by classes that are supposed to 
 * be new algorithms for finding an item in the inventory in <InventorySystemHandler>
 * @author danielduner
 *
 */
public interface FindItemStrategy {
	
	/**
	 * This class shall consist of a searchAlgorithm specifically used to search the 
	 * inventory for an Item with specified Id in <InvenrtoySystemHandler>
	 * @param itemId represents itemId that is passed from the class <InventorySystemHandler> in it's method findItem
	 * @param inventory represents itemId that is passed from the class <InventorySystemHandler> in it's method findItem
	 * @return returns an Item Object
	 */
	public Item findItem(int itemId, Item[] inventory);
}
