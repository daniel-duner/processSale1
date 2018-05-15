package se.kth.ood.daniel.duner.procesSale.view;

import se.kth.ood.daniel.duner.procesSale.model.Amount;

/**
 * Observer interface, which is implemented by classes that wants to be updated
 * when the information of the total revenue during a run of the program
 * @author danielduner
 *
 */
public interface Observer {
	/**
	 * Sends the current total revenue to the observers
	 * @param totalRevenue
	 */
	public void update(Amount totalRevenue);
	
}
