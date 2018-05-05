package se.kth.ood.daniel.duner.procesSale.model;
/**
 * Exception used when an amount isn't correct and is not allowed
 * @author danielduner
 *
 */
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}