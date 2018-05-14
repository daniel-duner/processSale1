package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.ReportLogger;

public class FailedToConnectException extends Exception {

	public FailedToConnectException(String message, int searchedItemId) throws FileNotFoundException, UnsupportedEncodingException {
		super(message);
		 ReportLogger logger = ReportLogger.getInstance();
	        logger.addReport("Failed to connect to the Database when searching for item with ID: "+searchedItemId);
	}
}
