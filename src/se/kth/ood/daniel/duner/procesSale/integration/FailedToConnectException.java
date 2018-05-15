package se.kth.ood.daniel.duner.procesSale.integration;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.model.ReportLogger;

public class FailedToConnectException extends RuntimeException {

	public FailedToConnectException(String message) throws FileNotFoundException, UnsupportedEncodingException {
		super(message);
		 ReportLogger logger = ReportLogger.getInstance();
	        logger.addReport(message);
	}
}
