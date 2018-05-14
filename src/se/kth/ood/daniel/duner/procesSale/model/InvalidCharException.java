package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Exception used when a char isn't correct and is not allowed
 * @author danielduner
 *
 */
public class InvalidCharException extends Exception {
    public InvalidCharException(String message) throws FileNotFoundException, UnsupportedEncodingException {
        super(message);
        ReportLogger logger = ReportLogger.getInstance();
        logger.addReport("Invalid Char");
    }
}
