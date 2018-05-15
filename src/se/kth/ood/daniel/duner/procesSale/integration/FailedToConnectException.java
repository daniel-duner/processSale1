package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.ReportLogger;
/**
 * An exception that is used when the program fails to connect to an external system 
 * @author danielduner
 *
 */
public class FailedToConnectException extends RuntimeException {
/**
 * creates an instance of the FailedToConnectException
 * @param message represents the error message that is written in the console to the developer
 * @throws FileNotFoundException
 * @throws UnsupportedEncodingException
 */
	public FailedToConnectException(String message) throws FileNotFoundException, UnsupportedEncodingException {
		super(message);
		 ReportLogger logger = ReportLogger.getInstance();
	        logger.addReport(message);
	}
}
