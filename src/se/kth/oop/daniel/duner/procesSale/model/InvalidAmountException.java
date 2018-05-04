package se.kth.oop.daniel.duner.procesSale.model;

public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}