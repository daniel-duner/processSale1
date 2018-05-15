package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.ReportLogger;

/**
 * Thrown when trying to find an item that doesn't exist in the inventory
 * @author danielduner
 *
 */
public class ItemNotFoundException extends Exception {
	private int itemIdNotFound;
	/**
	 * Creates an instance of the ItemNotFoundException
	 * @param itemIdNotFound represents the item that was searched but could not be found in the database
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
    public ItemNotFoundException(int itemIdNotFound) throws FileNotFoundException, UnsupportedEncodingException {
    	super("The Item Id:" + itemIdNotFound + " could not be found");
        this.itemIdNotFound = itemIdNotFound;
        ReportLogger logger = ReportLogger.getInstance();
        logger.addReport("Item with ID: "+itemIdNotFound+" was searched but was not found");
    }
    
    /**
     * Returns the itemIdNotFound to the caller
     * @return returns the itemId that could not be found
     */
    public int getItemNotFound() {
    	return itemIdNotFound;
    }
}