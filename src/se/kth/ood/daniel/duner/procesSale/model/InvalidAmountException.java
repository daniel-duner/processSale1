package se.kth.ood.daniel.duner.procesSale.model;
/**
 * Exception used when an amount isn't correct and is not allowed
 * @author danielduner
 *
 */
public class InvalidAmountException extends Exception {
	/**
	 * Instantiates an invalidAmountException
	 * @param message represents the message that is printed in the console to the developer
	 */
    public InvalidAmountException(String message) {
        super(message);
    }
}