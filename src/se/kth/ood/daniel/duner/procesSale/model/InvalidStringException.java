package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Exception used when a String isn't correct and is not allowed
 * @author danielduner
 *
 */
public class InvalidStringException extends Exception {
    public InvalidStringException(String message) throws FileNotFoundException, UnsupportedEncodingException {
        super(message);
        ReportLogger logger = ReportLogger.getInstance();
        logger.addReport("Invalid String");
    }
}