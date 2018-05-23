package se.kth.ood.daniel.duner.procesSale.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject interface which is the subject of observation by the observers implementing the <Observer> interface
 * @author danielduner
 *
 */

public interface Subject {
	/**
	 * Adds a new <Observer> to a list of Observers in the subject class
	 * @param observer represents an <Observer> object
	 */
	public void addObserver(Observer observer);
	/**
	 * Removes an <Observer> from the list of Observers in the subject class
	 * @param observer represents an <Observer> object
	 */
	public void removeObserver(Observer observer);
	/**
	 * Updates all observers with information, used when a state changes
	 */
	public void notifyObservers();
}
