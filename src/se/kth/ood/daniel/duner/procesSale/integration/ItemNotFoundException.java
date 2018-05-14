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
	
    public ItemNotFoundException(int itemIdNotFound) throws FileNotFoundException, UnsupportedEncodingException {
    	super("The Item Id:" + itemIdNotFound + " could not be found");
        this.itemIdNotFound = itemIdNotFound;
        ReportLogger logger = ReportLogger.getInstance();
        logger.addReport("Item with ID: "+itemIdNotFound+" was searched but was not found");
    }
    
    /**
     * @return returns the itemId that could not be found
     */
    public int getItemNotFound() {
    	return itemIdNotFound;
    }
}