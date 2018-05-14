package se.kth.ood.daniel.duner.procesSale.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.ood.daniel.duner.procesSale.view.Observer;

/**
 * Subject interface which is the subject of observation by the observers implementing the <Observer> interface
 * @author danielduner
 *
 */

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
}
