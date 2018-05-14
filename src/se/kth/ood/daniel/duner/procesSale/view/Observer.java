package se.kth.ood.daniel.duner.procesSale.view;

import se.kth.ood.daniel.duner.procesSale.model.Amount;

/**
 * Observer interface, which is implemented by t
 * @author danielduner
 *
 */
public interface Observer {
	
	public void update(Amount totalRevenue);
	
}
